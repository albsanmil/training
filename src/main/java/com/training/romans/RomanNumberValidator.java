package com.training.romans;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;

import java.util.Set;

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

    public boolean validate(String romanNumber) {
        if (Strings.isNullOrEmpty(romanNumber))
            return false;

        char[] symbols = romanNumber.toUpperCase().toCharArray();
        RomanSymbol previousSymbol = null;
        RomanSymbol currentSymbol;
        for (char symbol : symbols) {
            try {
                currentSymbol = RomanSymbol.fromCharacter(symbol);
                if (nonNull(previousSymbol) && previousSymbol.getCode() < currentSymbol.getCode()) {
                    String pair = buildPair(previousSymbol, currentSymbol);
                    return validPairsUsingSubtractionRule.contains(pair);
                }
                previousSymbol = currentSymbol;
            }
            catch (IllegalArgumentException e) {
                return false;
            }
        }

        return true;
    }

    private String buildPair(RomanSymbol previousSymbol, RomanSymbol currentSymbol) {
        return new StringBuilder()
                .append(String.valueOf(previousSymbol.getCharacter()))
                .append(String.valueOf(currentSymbol.getCharacter()))
                .toString();
    }
}
