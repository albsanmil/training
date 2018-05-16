package com.training.romans;

import static com.training.romans.RomanSymbol.*;
import static java.util.Objects.isNull;

public class RepeatedSymbolValidator {

    private short repeatedRomanSymbolCount = 0;
    private RomanSymbol previousSymbol;

    public boolean validate(RomanSymbol currentSymbol) {
        if (isNull(currentSymbol)) {
            previousSymbol = null;
            repeatedRomanSymbolCount = 0;
            return false;
        }

        if (isNull(previousSymbol)) {
            previousSymbol = currentSymbol;
            ++repeatedRomanSymbolCount;
            return true;
        }
        else {
            return isValidCombinationOfRepeatedSymbols(currentSymbol);
        }
    }

    private boolean isValidCombinationOfRepeatedSymbols(RomanSymbol currentSymbol) {
        if (isNull(currentSymbol)) {
            return true;
        }

        boolean areTheSameSymbols = previousSymbol.equals(currentSymbol);
        boolean isPreviousValidRepeatedSymbol = I.equals(previousSymbol)
                || X.equals(previousSymbol)
                || C.equals(previousSymbol)
                || M.equals(previousSymbol);

        if (areTheSameSymbols) {
            if (isPreviousValidRepeatedSymbol) {
                if (repeatedRomanSymbolCount < 3) {
                    ++repeatedRomanSymbolCount;
                    return true;
                }
                else {
                    repeatedRomanSymbolCount = 0;
                    previousSymbol = null;
                    return false;
                }
            }
            else {
                repeatedRomanSymbolCount = 0;
                previousSymbol = null;
                return false;
            }
        }
        else {
            if (previousSymbol.getCode() < currentSymbol.getCode() && repeatedRomanSymbolCount > 1) {
                repeatedRomanSymbolCount = 0;
                previousSymbol = null;
                return false;
            }
            else {
                repeatedRomanSymbolCount = 1;
                previousSymbol = currentSymbol;
                return true;
            }
        }
    }
}
