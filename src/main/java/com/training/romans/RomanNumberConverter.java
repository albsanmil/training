package com.training.romans;

import com.training.romans.exception.RomanNumberConversionException;
import com.training.romans.model.RomanSymbol;
import com.training.romans.model.RomanSymbolsInProgress;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;
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
            if (resultRequiresToBeMultipliedByThousand(symbol, result)) {
                result = result * 1000;
                symbolsInProgress = null;
            }
            else {
                symbolsInProgress = RomanSymbolsInProgressFactory.create(
                        symbolsInProgress, RomanSymbol.fromCharacter(symbol));

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
        }

        return result;
    }

    private boolean isSubtractionRuleApplicable(RomanSymbolsInProgress symbolsInProgress) {
        RomanSymbol previousSymbol = symbolsInProgress.getPreviousSymbol();
        RomanSymbol currentSymbol = symbolsInProgress.getCurrentSymbol();
        return nonNull(previousSymbol) && previousSymbol.getCode() < currentSymbol.getCode();
    }

    private boolean resultRequiresToBeMultipliedByThousand(char currentSymbol, int result) {
        return currentSymbol == '_' && result >= 4;
    }
}