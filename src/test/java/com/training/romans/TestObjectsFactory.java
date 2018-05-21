package com.training.romans;

import com.training.romans.model.RomanSymbolsInProgress;

public class TestObjectsFactory {

    public static RomanSymbolsInProgress getRomanSymbolsInProgress(RomanSymbol currentSymbol) {
        return new RomanSymbolsInProgress(null, null, null, currentSymbol);
    }

    public static RomanSymbolsInProgress getRomanSymbolsInProgress(char previousSymbol, char currentSymbol) {
        return new RomanSymbolsInProgress(
                null, null, RomanSymbol.fromCharacter(previousSymbol), RomanSymbol.fromCharacter(currentSymbol));
    }

    public static RomanSymbolsInProgress getRomanSymbolsInProgress(
            char beforePreviousSymbol, char previousSymbol, char currentSymbol)
    {
        return new RomanSymbolsInProgress(
                null,
                RomanSymbol.fromCharacter(beforePreviousSymbol),
                RomanSymbol.fromCharacter(previousSymbol),
                RomanSymbol.fromCharacter(currentSymbol));
    }

    public static RomanSymbolsInProgress getRomanSymbolsInProgress(
            char lastBeforePreviousSymbol, char beforePreviousSymbol, char previousSymbol, char currentSymbol)
    {
        return new RomanSymbolsInProgress(
                RomanSymbol.fromCharacter(lastBeforePreviousSymbol),
                RomanSymbol.fromCharacter(beforePreviousSymbol),
                RomanSymbol.fromCharacter(previousSymbol),
                RomanSymbol.fromCharacter(currentSymbol));
    }
}
