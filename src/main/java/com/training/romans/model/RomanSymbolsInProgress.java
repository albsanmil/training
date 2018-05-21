package com.training.romans.model;

import com.training.romans.RomanSymbol;

public final class RomanSymbolsInProgress {

    private final RomanSymbol lastBeforePreviousSymbol;
    private final RomanSymbol beforePreviousSymbol;
    private final RomanSymbol previousSymbol;
    private final RomanSymbol currentSymbol;


    public RomanSymbolsInProgress(
            RomanSymbol lastBeforePreviousSymbol,
            RomanSymbol beforePreviousSymbol,
            RomanSymbol previousSymbol,
            RomanSymbol currentSymbol)
    {
        this.lastBeforePreviousSymbol = lastBeforePreviousSymbol;
        this.beforePreviousSymbol = beforePreviousSymbol;
        this.previousSymbol = previousSymbol;
        this.currentSymbol = currentSymbol;
    }

    public RomanSymbol getLastBeforePreviousSymbol() {
        return lastBeforePreviousSymbol;
    }

    public RomanSymbol getBeforePreviousSymbol() {
        return beforePreviousSymbol;
    }

    public RomanSymbol getPreviousSymbol() {
        return previousSymbol;
    }

    public RomanSymbol getCurrentSymbol() {
        return currentSymbol;
    }
}
