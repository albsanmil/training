package com.training.romans;

import com.training.romans.model.RomanSymbol;
import com.training.romans.model.RomanSymbolsInProgress;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class RomanSymbolsInProgressFactory {

    public static RomanSymbolsInProgress create(
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
}
