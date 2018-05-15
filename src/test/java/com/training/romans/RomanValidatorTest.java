package com.training.romans;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RomanValidatorTest {

    private static RomanValidator subject;

    @BeforeAll
    static void setUp() {
        subject = new RomanValidator();
    }

    @DisplayName("Testing known roman symbol")
    @ParameterizedTest(name = "\"{0}\" is a valid roman number")
    @ValueSource(strings = {"I", "V", "X", "L", "C", "D", "M"})
    void when_RomanSymbolIsKnown_expect_SuccessfulValidation(String roman) {
        boolean result = subject.validate(roman);

        assertTrue(result, "Wrong validation, roman symbol '" + roman + "' is a valid roman number");
    }

    @DisplayName("Testing unknown symbol")
    @ParameterizedTest(name = "\"{0}\" is not a valid roman number")
    @ValueSource(strings = {"A", "B", "H", "R", "Z"})
    void when_UnknownSymbol_expect_FailedValidation(String unknownSymbol) {
        boolean result = subject.validate(unknownSymbol);

        assertFalse(result, "Wrong validation, unknown symbol '" + unknownSymbol + "' is not a valid roman number");
    }

    @DisplayName("Testing empty argument")
    @Test
    void when_EmptyArgument_expect_FailedValidation() {
        boolean result = subject.validate("");

        assertFalse(result, "Wrong validation, validate an empty argument should fail the validation");
    }

    @DisplayName("Testing null argument")
    @Test
    void when_NullArgument_expect_FailedValidation() {
        boolean result = subject.validate(null);

        assertFalse(result, "Wrong validation, validate a null argument should fail the validation");
    }

    @DisplayName("Testing the repetition of acceptable roman symbols up to three times")
    @ParameterizedTest(name = "\"{0}\" is a valid roman number")
    @ValueSource(strings = {"II", "III", "XX", "XXX", "CC", "CCC", "MM", "MMM"})
    void when_RepeatingAcceptableRomanSymbolsUpToThreeTimes_expect_SuccessfulValidation(String roman) {
        boolean result = subject.validate(roman);

        assertTrue(result, "Wrong validation, roman symbols '" + roman + "' are a valid roman number");
    }

    @DisplayName("Testing the repetition of non acceptable roman symbols")
    @ParameterizedTest(name = "\"{0}\" is not a valid roman number")
    @ValueSource(strings = {"VV", "VVV", "LL", "LLL", "DD", "DDD"})
    void when_RepeatingNonAcceptableRomanSymbols_expect_FailedValidation(String wrongRoman) {
        boolean result = subject.validate(wrongRoman);

        assertFalse(result, "Wrong validation, roman symbols '" + wrongRoman + "' are not a valid roman number");
    }

    @DisplayName("Testing pairs of roman symbols that use the subtraction rule")
    @ParameterizedTest(name = "\"{0}\" is a valid roman number")
    @ValueSource(strings = {"IV", "IX", "XL", "XC", "CD", "CM"})
    void when_PairsOfRomanSymbolsThatUseSubtractionRule_expect_SuccessfulValidation(String roman) {
        boolean result = subject.validate(roman);

        assertTrue(result, "Wrong validation, roman symbols '" + roman + "' are a valid roman number");
    }

    @DisplayName("Testing pairs of roman symbols that do not use the subtraction rule")
    @ParameterizedTest(name = "\"{0}\" is not a valid roman number")
    @ValueSource(strings = {"VX"})
    void when_PairsOfRomanSymbolsThatDoNotUseSubtractionRule_expect_FailedValidation(String wrongRoman) {
        boolean result = subject.validate(wrongRoman);

        assertFalse(result, "Wrong validation, roman symbols '" + wrongRoman + "' are not a valid roman number");
    }

//    @DisplayName("Testing good combination of two known roman symbols")
//    @ParameterizedTest(name = "\"{0}\" is a valid roman number")
//    @ValueSource(strings = {"II", "XX", "CC", "MM", "IV", "VI", "IX", "XI", "CX", "CI", "CV"})
//    void when_GoodCombinationOfTwoKnownRomanSymbols_expect_SuccessfulValidation(String roman) {
//        boolean result = subject.validate(roman);
//
//        assertTrue(result, "Wrong validation, roman symbols '" + roman + "' are a valid roman number");
//    }
//
//    @DisplayName("Testing wrong combination of two known roman symbols")
//    @ParameterizedTest(name = "\"{0}\" is not a valid roman number")
//    @ValueSource(strings = {"VV"}) // , "VX", "VL", "VC", "VD", "VM", "LL", "LC", "LD", "LM", "DD", "DM"})
//    void when_WrongCombinationOfTwoKnownRomanSymbols_expect_FailedValidation(String wrongRoman) {
//        boolean result = subject.validate(wrongRoman);
//
//        assertFalse(result, "Wrong validation, roman symbols '" + wrongRoman + "' are not a valid roman number");
//    }
}