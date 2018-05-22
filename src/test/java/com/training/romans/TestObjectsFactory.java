package com.training.romans;

import com.training.romans.model.RomanSymbolsInProgress;

import static java.util.Objects.nonNull;

public class TestObjectsFactory {

    public static RomanSymbolsInProgress getRomanSymbolsInProgress(RomanSymbol currentSymbol) {
        return new RomanSymbolsInProgress(null, null, null, nonNull(currentSymbol) ? currentSymbol : null);
    }

    public static RomanSymbolsInProgress getRomanSymbolsInProgress(char previousSymbol, char currentSymbol) {
        return getRomanSymbolsInProgress(null, null, previousSymbol, currentSymbol);
    }

    public static RomanSymbolsInProgress getRomanSymbolsInProgress(
            char beforePreviousSymbol, char previousSymbol, char currentSymbol)
    {
        return getRomanSymbolsInProgress(null, beforePreviousSymbol, previousSymbol, currentSymbol);
    }

    public static RomanSymbolsInProgress getRomanSymbolsInProgress(
            Character lastBeforePreviousSymbol,
            Character beforePreviousSymbol,
            Character previousSymbol,
            Character currentSymbol)
    {
        return new RomanSymbolsInProgress(
                nonNull(lastBeforePreviousSymbol) ? RomanSymbol.fromCharacter(lastBeforePreviousSymbol) : null,
                nonNull(beforePreviousSymbol) ? RomanSymbol.fromCharacter(beforePreviousSymbol) : null,
                nonNull(previousSymbol) ? RomanSymbol.fromCharacter(previousSymbol) : null,
                nonNull(currentSymbol) ? RomanSymbol.fromCharacter(currentSymbol) : null);
    }
}
