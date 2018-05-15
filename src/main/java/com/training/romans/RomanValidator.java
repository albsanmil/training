package com.training.romans;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;

import java.util.Set;

import static com.training.romans.RomanSymbol.*;
import static java.util.Objects.isNull;

public class RomanValidator {

    private Set<String> validCombinationBasedOnSubtractionRule = ImmutableSet.<String>builder()
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
                if (isWrongRepetitionOfSymbols(previousSymbol, currentSymbol) || isWrongCombinationBasedOnSubtractionRule(previousSymbol, currentSymbol)) {
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

    private boolean isWrongRepetitionOfSymbols(RomanSymbol previousSymbol, RomanSymbol currentSymbol) {
        if (isNull(previousSymbol) || isNull(currentSymbol)) {
            return false;
        }

        boolean areSameSymbols = previousSymbol.equals(currentSymbol);
        boolean isWrongCombination_VV = V.equals(previousSymbol) && areSameSymbols;
        boolean isWrongCombination_LL = L.equals(previousSymbol) && areSameSymbols;
        boolean isWrongCombination_DD = D.equals(previousSymbol) && areSameSymbols;

        return isWrongCombination_VV || isWrongCombination_LL || isWrongCombination_DD;
    }

    private boolean isWrongCombinationBasedOnSubtractionRule(RomanSymbol previousSymbol, RomanSymbol currentSymbol) {
        if (isNull(previousSymbol) || isNull(currentSymbol)) {
            return false;
        }

        String currentCombination = new StringBuilder()
                .append(String.valueOf(previousSymbol.getCharacter()))
                .append(String.valueOf(currentSymbol.getCharacter()))
                .toString();

        return !(previousSymbol.getCode() < currentSymbol.getCode() && validCombinationBasedOnSubtractionRule.contains(currentCombination));
    }
}
