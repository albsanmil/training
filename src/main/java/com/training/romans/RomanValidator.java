package com.training.romans;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;

import java.util.Set;

import static java.util.Objects.isNull;

public class RomanValidator {

    private Set<String> wrongPairsOfRepeatedSymbols = ImmutableSet.<String>builder()
            .add("VV")
            .add("LL")
            .add("DD")
            .build();

    private Set<String> validPairsUsingSubtractionRule = ImmutableSet.<String>builder()
            .add("IV")
            .add("IX")
            .add("XL")
            .add("XC")
            .add("CD")
            .add("CM")
            .build();

    public boolean validate(String roman) {
        if (Strings.isNullOrEmpty(roman)) {
            return false;
        }

        char[] romanCharacters = roman.toUpperCase().toCharArray();
        RomanSymbol previousSymbol = null;
        RomanSymbol currentSymbol;
        for (char character : romanCharacters) {
            try {
                currentSymbol = RomanSymbol.fromCharacter(character);
                if (isWrongPairOfRepeatedSymbols(previousSymbol, currentSymbol)
                        || isNotPairUsingSubtractionRule(previousSymbol, currentSymbol)) {
                    return false;
                }
                else {
                    previousSymbol = currentSymbol;
                }
            }
            catch (IllegalArgumentException e) {
                return false;
            }
        }

        return true;
    }

    private boolean isWrongPairOfRepeatedSymbols(RomanSymbol previousSymbol, RomanSymbol currentSymbol) {
        if (isNull(previousSymbol) || isNull(currentSymbol)) {
            return false;
        }

        String pair = buildPair(previousSymbol, currentSymbol);
        return wrongPairsOfRepeatedSymbols.contains(pair);
    }

    private boolean isNotPairUsingSubtractionRule(RomanSymbol previousSymbol, RomanSymbol currentSymbol) {
        if (isNull(previousSymbol) || isNull(currentSymbol) || previousSymbol.getCode() >= currentSymbol.getCode()) {
            return false;
        }

        String pair = buildPair(previousSymbol, currentSymbol);
        return !validPairsUsingSubtractionRule.contains(pair);
    }

    private String buildPair(RomanSymbol previousSymbol, RomanSymbol currentSymbol) {
        return new StringBuilder()
                .append(String.valueOf(previousSymbol.getCharacter()))
                .append(String.valueOf(currentSymbol.getCharacter()))
                .toString();
    }
}
