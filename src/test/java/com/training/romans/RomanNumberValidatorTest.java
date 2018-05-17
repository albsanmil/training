package com.training.romans;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RomanNumberValidatorTest {

    private static RomanNumberValidator subject;

    @BeforeAll
    static void setUp() {
        subject = new RomanNumberValidator();
    }

    @DisplayName("Testing null argument")
    @Test
    void when_NullArgument_expect_FailedValidation() {
        boolean result = subject.validate(null);

        assertFalse(result, "Wrong validation, argument is null");
    }

    @DisplayName("Testing empty string argument")
    @Test
    void when_EmptyStringArgument_expect_FailedValidation() {
        boolean result = subject.validate("");

        assertFalse(result, "Wrong validation, argument is an empty string");
    }

    @DisplayName("Testing known roman symbol")
    @ParameterizedTest(name = "\"{0}\" is a valid roman number")
    @ValueSource(strings = {"I", "V", "X", "L", "C", "D", "M"})
    void when_RomanSymbolIsKnown_expect_SuccessfulValidation(String romanNumber) {
        boolean result = subject.validate(romanNumber);

        assertTrue(result, "Wrong validation, roman number '" + romanNumber + "' is valid");
    }

    @DisplayName("Testing unknown symbol")
    @ParameterizedTest(name = "\"{0}\" is not a valid roman number")
    @ValueSource(strings = {"A", "B", "H", "R", "Z"})
    void when_UnknownSymbol_expect_FailedValidation(String unknownSymbol) {
        boolean result = subject.validate(unknownSymbol);

        assertFalse(result, "Wrong validation, '" + unknownSymbol + "' is not a valid roman number");
    }

    @DisplayName("Testing pairs of roman symbols that use the subtraction rule")
    @ParameterizedTest(name = "\"{0}\" is a valid roman number")
    @ValueSource(strings = {"IV", "IX", "XL", "XC", "CD", "CM"})
    void when_PairsOfRomanSymbolsThatUseSubtractionRule_expect_SuccessfulValidation(String romanNumber) {
        boolean result = subject.validate(romanNumber);

        assertTrue(result, "Wrong validation, roman number '" + romanNumber + "' is valid");
    }

    @DisplayName("Testing pairs of roman symbols that first is less than second and do not use the subtraction rule")
    @ParameterizedTest(name = "\"{0}\" is not a valid roman number")
    @ValueSource(strings = {"VX", "VL", "VC", "VD", "VM", "LC", "LD", "LM", "DM"})
    void when_PairsOfRomanSymbolsThatDoNotUseSubtractionRule_expect_FailedValidation(String romanNumber) {
        boolean result = subject.validate(romanNumber);

        assertFalse(result, "Wrong validation, roman number '" + romanNumber + "' is not valid");
    }

    @DisplayName("Testing pairs of roman symbols that first is greater than second")
    @ParameterizedTest(name = "\"{0}\" is a valid roman number")
    @ValueSource(strings = {
            "VI", "XI", "XV", "LI", "LV", "LX", "CI", "CV", "CX", "CL", "DI", "DV", "DX", "DL", "DC", "MI", "MV", "MX",
            "ML", "MC", "MD"
    })
    void when_PairsOfRomanSymbolsThatFirstGreaterThanSecond_expect_SuccessfulValidation(String romanNumber) {
        boolean result = subject.validate(romanNumber);

        assertTrue(result, "Wrong validation, roman number '" + romanNumber + "' is valid");
    }
}