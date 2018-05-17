package com.training.romans;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

public class RomanValidator {

    private Set<String> validPairsUsingSubtractionRule = ImmutableSet.<String>builder()
            .add("IV")
            .add("IX")
            .add("XL")
            .add("XC")
            .add("CD")
            .add("CM")
            .build();

    public boolean validate(String roman) {
//        if (previousSymbol.getCode() > currentSymbol.getCode()) {
//            return true;
//        }
//
//        String pair = buildPair(previousSymbol, currentSymbol);
        return validPairsUsingSubtractionRule.contains(roman);
    }

    private String buildPair(RomanSymbol previousSymbol, RomanSymbol currentSymbol) {
        return new StringBuilder()
                .append(String.valueOf(previousSymbol.getCharacter()))
                .append(String.valueOf(currentSymbol.getCharacter()))
                .toString();
    }
}
