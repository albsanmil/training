package com.training.romans;

import com.google.common.collect.ImmutableSet;
import com.training.romans.model.RomanSymbolsInProgress;

import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Objects.nonNull;

public class RomanNumberValidator {

    private Set<String> validPairsUsingSubtractionRule = ImmutableSet.<String>builder()
            .add("IV")
            .add("IX")
            .add("XL")
            .add("XC")
            .add("CD")
            .add("CM")
            .build();

    private Set<RomanSymbol> validPreviousRepeatedSymbols = ImmutableSet.<RomanSymbol>builder()
            .add(RomanSymbol.I)
            .add(RomanSymbol.X)
            .add(RomanSymbol.C)
            .add(RomanSymbol.M)
            .build();

    public boolean validate(RomanSymbolsInProgress symbolsInProgress) {
        checkNotNull(symbolsInProgress, "Cannot validate from a null symbolsInProgress");

//        if (isNull(symbolsInProgress.getLastBeforePreviousSymbol())
//                && isNull(symbolsInProgress.getBeforePreviousSymbol())
//                && isNull(symbolsInProgress.getPreviousSymbol())
//                && nonNull(symbolsInProgress.getCurrentSymbol())) {
//            return true;
//        }

        RomanSymbol lastBeforePreviousSymbol = symbolsInProgress.getLastBeforePreviousSymbol();
        RomanSymbol beforePreviousSymbol = symbolsInProgress.getBeforePreviousSymbol();
        RomanSymbol previousSymbol = symbolsInProgress.getPreviousSymbol();
        RomanSymbol currentSymbol = symbolsInProgress.getCurrentSymbol();

        if (isSubtractionRuleValidationApplicable(previousSymbol, currentSymbol)) {
            String pair = buildPair(symbolsInProgress.getPreviousSymbol(), symbolsInProgress.getCurrentSymbol());
            if (!validPairsUsingSubtractionRule.contains(pair))
                return false;
        }

        if (isPreviousRepeatedSymbolInvalid(previousSymbol, currentSymbol))
            return false;

        if (areThreePreviousSymbolsRepeated(lastBeforePreviousSymbol, beforePreviousSymbol, previousSymbol,
                currentSymbol))
            return false;

        if (areTwoPreviousSymbolsSmallerThanCurrentSymbol(beforePreviousSymbol, previousSymbol, currentSymbol))
            return false;

        return true;
    }

    private boolean isSubtractionRuleValidationApplicable(RomanSymbol previousSymbol, RomanSymbol currentSymbol) {
        return nonNull(previousSymbol) && nonNull(currentSymbol) && previousSymbol.getCode() < currentSymbol.getCode();
    }

    private String buildPair(RomanSymbol previousSymbol, RomanSymbol currentSymbol) {
        return new StringBuilder()
                .append(String.valueOf(previousSymbol.getCharacter()))
                .append(String.valueOf(currentSymbol.getCharacter()))
                .toString();
    }

    private boolean isPreviousRepeatedSymbolInvalid(RomanSymbol previousSymbol, RomanSymbol currentSymbol) {
        return nonNull(previousSymbol)
                && previousSymbol.equals(currentSymbol)
                && !validPreviousRepeatedSymbols.contains(previousSymbol);
    }

    private boolean areThreePreviousSymbolsRepeated(
            RomanSymbol lastBeforePreviousSymbol,
            RomanSymbol beforePreviousSymbol,
            RomanSymbol previousSymbol,
            RomanSymbol currentSymbol)
    {
        return nonNull(lastBeforePreviousSymbol)
                && nonNull(beforePreviousSymbol)
                && nonNull(previousSymbol)
                && nonNull(currentSymbol)
                && lastBeforePreviousSymbol.equals(currentSymbol)
                && beforePreviousSymbol.equals(currentSymbol)
                && previousSymbol.equals(currentSymbol);
    }

    private boolean areTwoPreviousSymbolsSmallerThanCurrentSymbol(
            RomanSymbol beforePreviousSymbol,
            RomanSymbol previousSymbol,
            RomanSymbol currentSymbol)
    {
        return nonNull(beforePreviousSymbol)
                && nonNull(previousSymbol)
                && nonNull(currentSymbol)
                && beforePreviousSymbol.getCode() < currentSymbol.getCode()
                && previousSymbol.getCode() < currentSymbol.getCode();
    }
}
