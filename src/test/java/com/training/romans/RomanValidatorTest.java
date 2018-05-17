package com.training.romans;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RomanValidatorTest {

    private static RomanValidator subject;

    @BeforeAll
    static void setUp() {
        subject = new RomanValidator();
    }

//    @DisplayName("Testing roman number validation when current symbol is null")
//    @Test
//    void when_CurrentSymbolIsNull_expect_FailedValidation() {
//        boolean result = subject.validate(null, null);
//
//        assertFalse(result, "Wrong validation, current symbol cannot be null");
//    }

    @DisplayName("Testing pairs of roman symbols that use the subtraction rule")
    @ParameterizedTest(name = "\"{0}\" is a valid roman number")
    @ValueSource(strings = {"IV", "IX", "XL", "XC", "CD", "CM"})
    void when_PairsOfRomanSymbolsThatUseSubtractionRule_expect_SuccessfulValidation(String roman) {
        boolean result = subject.validate(roman);

        assertTrue(result, "Wrong validation, roman number '" + roman + "' is valid");
    }

//    @DisplayName("Testing pairs of roman symbols that do not use the subtraction rule")
//    @ParameterizedTest(name = "\"{0}{1}\" is not a valid roman number")
//    @CsvSource({"V, X", "V, L", "V, C", "V, D", "V, M", "L, C", "L, D", "L, M", "D, M"})
//    void when_PairsOfRomanSymbolsThatDoNotUseSubtractionRule_expect_FailedValidation(
//            RomanSymbol previousSymbol, RomanSymbol currentSymbol)
//    {
//        boolean result = subject.validate(previousSymbol, currentSymbol);
//
//        assertFalse(result, "Wrong validation, roman number '" + previousSymbol + currentSymbol + "' is not valid");
//    }
//
//    @DisplayName("Testing pairs of roman symbols that first is greater than second")
//    @ParameterizedTest(name = "\"{0}{1}\" is a valid roman number")
//    @CsvSource({
//            "V, I", "X, I", "X, V", "L, I", "L, V", "L, X", "C, I", "C, V", "C, X", "C, L", "D, I", "D, V", "D, X",
//            "D, L", "D, C", "M, I", "M, V", "M, X", "M, L", "M, C", "M, D"
//    })
//    void when_PairsOfRomanSymbolsThatFirstGreaterThanSecond_expect_SuccessfulValidation(
//            RomanSymbol previousSymbol, RomanSymbol currentSymbol)
//    {
//        boolean result = subject.validate(previousSymbol, currentSymbol);
//
//        assertTrue(result, "Wrong validation, roman number '" + previousSymbol + currentSymbol + "' is valid");
//    }
}