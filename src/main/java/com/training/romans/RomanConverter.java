package com.training.romans;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Strings.isNullOrEmpty;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class RomanConverter {

    private Map<Character, Integer> romanSymbols = ImmutableMap.<Character, Integer>builder()
            .put('I', 1)
            .put('V', 5)
            .put('X', 10)
            .put('L', 50)
            .put('C', 100)
            .put('D', 500)
            .put('M', 1000)
            .build();

    public int toNumber(String roman) {
        checkArgument(!isNullOrEmpty(roman), "Cannot convert roman number from a null or empty string");

        int result = 0;

        char[] symbols = roman.toUpperCase().toCharArray();
        Integer beforeOfBeforePreviousValue = null;
        Integer beforePreviousValue = null;
        Integer previousValue = null;
        Integer currentValue;
        for (char symbol : symbols) {
            currentValue = romanSymbols.get(symbol);
            if (nonNull(currentValue)) {
                if (!isGoodCombination(beforeOfBeforePreviousValue, beforePreviousValue, previousValue, currentValue)) {
                    if (isNull(previousValue) || previousValue >= currentValue) {
                        result += currentValue;
                    }
                    else if (previousValue < currentValue) {
                        result += currentValue - 2 * previousValue;
                    }

                    if (nonNull(previousValue)) {
                        beforePreviousValue = previousValue;
                    }
                    previousValue = currentValue;
                }
                else {
                    throw new IllegalArgumentException("Wrong combination of roman symbols " + roman);
                }
            }
            else {
                throw new IllegalArgumentException("Found a non-roman symbol " + symbol);
            }
        }


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
        return result;
    }

    private boolean isGoodCombination(
            Integer beforeOfBeforePreviousValue, Integer beforePreviousValue, Integer previousValue, Integer currentValue)
    {
        if (isNull(previousValue) || isNull(currentValue)) {
            return false;
        }

        return previousValue <= currentValue && (previousValue.equals(5) || previousValue.equals(50) || previousValue.equals(500))
                || (nonNull(beforePreviousValue) && beforePreviousValue < currentValue && previousValue < currentValue);
    }
}