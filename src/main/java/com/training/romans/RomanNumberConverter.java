package com.training.romans;

import com.training.romans.model.RomanSymbol;
import com.training.romans.model.RomanSymbolsInProgress;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Objects.nonNull;

public class RomanNumberConverter {

    public int convert(RomanNumber romanNumber) {
        checkNotNull(romanNumber);

        int result = 0;
        RomanSymbolsInProgress symbolsInProgress = null;
        char[] symbols = romanNumber.getRomanNumber().toCharArray();

        for (char symbol : symbols) {
            if (resultRequiresToBeMultipliedByThousand(symbol, result)) {
                result = result * 1000;
                symbolsInProgress = null;
            }
            else {
                symbolsInProgress = RomanSymbolsInProgressFactory.create(
                        symbolsInProgress, RomanSymbol.fromCharacter(symbol));

                if (isSubtractionRuleApplicable(symbolsInProgress))
                    result += symbolsInProgress.getCurrentSymbol().getCode()
                            - 2 * symbolsInProgress.getPreviousSymbol().getCode();
                else
                    result += symbolsInProgress.getCurrentSymbol().getCode();
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