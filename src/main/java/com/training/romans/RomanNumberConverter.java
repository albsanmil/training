package com.training.romans;


import com.training.romans.exception.RomanNumberConversionException;
import com.training.romans.model.RomanSymbol;
import com.training.romans.model.RomanSymbolsInProgress;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class RomanNumberConverter {

    private final RomanNumberValidator romanNumberValidator;

    public RomanNumberConverter(RomanNumberValidator romanNumberValidator) {
        this.romanNumberValidator = checkNotNull(romanNumberValidator, "romanNumberValidator was null");
    }

    public int convert(String romanNumber) {
        checkArgument(!isNullOrEmpty(romanNumber), "Cannot convert roman number from a null or empty string");

        int result = 0;
        RomanSymbolsInProgress symbolsInProgress = null;
        char[] symbols = romanNumber.toUpperCase().toCharArray();

        for (char symbol : symbols) {
            symbolsInProgress = createRomanSymbolsInProgress(symbolsInProgress, RomanSymbol.fromCharacter(symbol));
            if (romanNumberValidator.validate(symbolsInProgress)) {
                if (isSubtractionRuleApplicable(symbolsInProgress))
                    result += symbolsInProgress.getCurrentSymbol().getCode()
                            - 2 * symbolsInProgress.getPreviousSymbol().getCode();
                else
                    result += symbolsInProgress.getCurrentSymbol().getCode();
            }
            else
                throw new RomanNumberConversionException("Illegal roman number \"" + romanNumber + "\"");
        }

        return result;

//        // If the user passes it as a parameter, lowercase letters make it uppercase
//        roman = roman.toUpperCase();
//
//        if (roman.length() == 0) {
//            return 0;
//        }
//        else if (roman.length() == 1) {
//            for (int i = 0; i < roman.length(); i++) {
//                for (Character rom : romanSymbols.keySet()) {
//                    if (rom.equals(roman.charAt(i))) {
//                        return romanSymbols.get(rom);
//                    }
//                }
//            }
//            return 0;
//        }
//        else {
//            int result = 0;
//            int counter = 0;
//            int counterV = 0;
//            int counterL = 0;
//            int counterD = 0;
//            int k = 0;
//            for (int i = 0; i < roman.length(); i++) {
//                if (roman.charAt(i) == 'C' ||
//                        roman.charAt(i) == 'D' ||
//                        roman.charAt(i) == 'V' ||
//                        roman.charAt(i) == 'X' ||
//                        roman.charAt(i) == 'I' ||
//                        roman.charAt(i) == 'L' ||
//                        roman.charAt(i) == 'M') {
//
//                    int j = i + 1;
//                    if (i == roman.length() - 1) {
//                        j = i;
//                    }
//
//                    if (i != 0) {
//                        k = i - 1;
//                    }
//
//                    for (Character rom : romanSymbols.keySet()) {
//                        if (rom.equals(roman.charAt(i)) && romanSymbols.get(rom) >= romanSymbols.get(roman.charAt(j))) {
//                            result += romanSymbols.get(rom);
//                            // This controls that the Roman numeral can not contain more than three equal characters followed
//                            if (k >= 0 && romanSymbols.get(rom).equals(romanSymbols.get(roman.charAt(k)))) {
//                                counter++;
//
//                                if (counter >= 4) {
//                                    return 0;
//                                }
//                                if (rom.equals(roman.charAt(i)) && roman.charAt(i) == 'V') {
//                                    counterV++;
//                                    if (counterV == 2) {
//                                        return 0;
//                                    }
//                                } else if (rom.equals(roman.charAt(i)) && roman.charAt(i) == 'L') {
//                                    counterL++;
//                                    if (counterL == 2) {
//                                        return 0;
//                                    }
//                                } else if (rom.equals(roman.charAt(i)) && roman.charAt(i) == 'D') {
//                                    counterD++;
//                                    if (counterD == 2) {
//                                        return 0;
//                                    }
//                                }
//
//                            } else {
//                                counter = 1;
//
//                                if (rom.equals(roman.charAt(i)) && roman.charAt(i) == 'V') {
//                                    counterV++;
//                                    if (counterV == 2) {
//                                        return 0;
//                                    }
//                                } else if (rom.equals(roman.charAt(i)) && roman.charAt(i) == 'L') {
//                                    counterL++;
//                                    if (counterL == 2) {
//                                        return 0;
//                                    }
//                                } else if (rom.equals(roman.charAt(i)) && roman.charAt(i) == 'D') {
//                                    counterD++;
//                                    if (counterD == 2) {
//                                        return 0;
//                                    }
//                                }
//
//                            }
//                        } else if (rom.equals(roman.charAt(i)) && romanSymbols.get(rom) < romanSymbols.get(roman.charAt(j))) {
//                            result -= romanSymbols.get(rom);
//                            counter = 1;
//                            // This controls that when the value of a character is subtracted from the one to which
//                            // it has its right because it is greater, it checks that its character on the left is not the same. If so, return 0.
//                            if (k != 0 && romanSymbols.get(rom).equals(romanSymbols.get(roman.charAt(k)))) {
//                                return 0;
//                            }
//
//                            if (roman.charAt(i) == 'V') {
//                                counterV++;
//                                if (counterV == 2) {
//                                    return 0;
//                                }
//                            } else if (roman.charAt(i) == 'L') {
//                                counterL++;
//                                if (counterL == 2) {
//                                    return 0;
//                                }
//                            } else if (roman.charAt(i) == 'D') {
//                                counterD++;
//                                if (counterD == 2) {
//                                    return 0;
//                                }
//                            }
//
//                        }
//    //                    else if (rom.equals(roman.charAt(i)) && roman.charAt(i) == 'V') {
//    //                        counterV++;
//    //                        if (counterV == 2) {
//    //                            return 0;
//    //                        }
//    //                    }
//    //                    else if (rom.equals(roman.charAt(i)) && roman.charAt(i) == 'L') {
//    //                        counterL++;
//    //                        if (counterL == 2) {
//    //                            return 0;
//    //                        }
//    //                    }
//    //                    else if (rom.equals(roman.charAt(i)) && roman.charAt(i) == 'D') {
//    //                        counterD++;
//    //                        if (counterD == 2) {
//    //                            return 0;
//    //                        }
//    //                    }
//                    }
//                }
//                else {
//                    return 0;
//                }
//
//            }
//            return result;
//        }

    }

    private RomanSymbolsInProgress createRomanSymbolsInProgress(
            RomanSymbolsInProgress previousRomanSymbolsInProgress, RomanSymbol newCurrentSymbol)
    {
        if (isNull(previousRomanSymbolsInProgress)) {
            return new RomanSymbolsInProgress(null, null, null, newCurrentSymbol);
        }

        RomanSymbol beforePreviousSymbol = previousRomanSymbolsInProgress.getBeforePreviousSymbol();
        RomanSymbol previousSymbol = previousRomanSymbolsInProgress.getPreviousSymbol();
        RomanSymbol currentSymbol = previousRomanSymbolsInProgress.getCurrentSymbol();

        return new RomanSymbolsInProgress(
                nonNull(beforePreviousSymbol) ? beforePreviousSymbol : null,
                nonNull(previousSymbol) ? previousSymbol : null,
                nonNull(currentSymbol) ? currentSymbol : null,
                newCurrentSymbol);
    }

    private boolean isSubtractionRuleApplicable(RomanSymbolsInProgress symbolsInProgress) {
        RomanSymbol previousSymbol = symbolsInProgress.getPreviousSymbol();
        RomanSymbol currentSymbol = symbolsInProgress.getCurrentSymbol();
        return nonNull(previousSymbol) && previousSymbol.getCode() < currentSymbol.getCode();
    }
}