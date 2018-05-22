package com.training.romans;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import static com.training.romans.TestObjectsFactory.getRomanSymbolsInProgress;
import static org.junit.jupiter.api.Assertions.*;

public class RomanNumberValidatorTest {

    private static RomanNumberValidator subject;

    @BeforeAll
    static void setUp() {
        subject = new RomanNumberValidator();
    }

    @DisplayName("Testing null argument")
    @Test
    void when_NullArgument_expect_FailedValidation() {
        assertThrows(NullPointerException.class, () -> subject.validate(null));
    }

    @DisplayName("Testing known roman symbol")
    @ParameterizedTest(name = "\"{0}\" is a valid roman number")
    @EnumSource(RomanSymbol.class)
    void when_RomanSymbolIsKnown_expect_SuccessfulValidation(RomanSymbol romanSymbol) {
        boolean result = subject.validate(getRomanSymbolsInProgress(romanSymbol));

        assertTrue(result, "Wrong validation, roman number '" + romanSymbol + "' is valid");
    }

    @DisplayName("Testing pairs of roman symbols that use the subtraction rule")
    @ParameterizedTest(name = "\"{0}{1}\" is a valid roman number")
    @CsvSource({"I, V", "I, X", "X, L", "X, C", "C, D", "C, M"})
    void when_PairsOfRomanSymbolsThatUseSubtractionRule_expect_SuccessfulValidation(
            char previousSymbol, char currentSymbol)
    {
        boolean result = subject.validate(getRomanSymbolsInProgress(previousSymbol, currentSymbol));

        assertTrue(result, "Wrong validation, roman number '" + previousSymbol + currentSymbol + "' is valid");
    }

    @DisplayName("Testing pairs of roman symbols that first is less than second and do not use the subtraction rule")
    @ParameterizedTest(name = "\"{0}{1}\" is not a valid roman number")
    @CsvSource({"V, X", "V, L", "V, C", "V, D", "V, M", "L, C", "L, D", "L, M", "D, M"})
    void when_PairsOfRomanSymbolsThatDoNotUseSubtractionRule_expect_FailedValidation(
            char previousSymbol, char currentSymbol)
    {
        boolean result = subject.validate(getRomanSymbolsInProgress(previousSymbol, currentSymbol));

        assertFalse(result, "Wrong validation, roman number '" + previousSymbol + currentSymbol + "' is not valid");
    }

    @DisplayName("Testing pairs of roman symbols that first is greater than second")
    @ParameterizedTest(name = "\"{0}{1}\" is a valid roman number")
    @CsvSource({
            "V, I", "X, I", "X, V", "L, I", "L, V", "L, X", "C, I", "C, V", "C, X", "C, L", "D, I", "D, V", "D, X",
            "D, L", "D, C", "M, I", "M, V", "M, X", "M, L", "M, C", "M, D"
    })
    void when_PairsOfRomanSymbolsThatFirstGreaterThanSecond_expect_SuccessfulValidation(
            char previousSymbol, char currentSymbol)
    {
        boolean result = subject.validate(getRomanSymbolsInProgress(previousSymbol, currentSymbol));

        assertTrue(result, "Wrong validation, roman number '" + previousSymbol + currentSymbol + "' is valid");
    }

    @DisplayName("Testing valid roman number with the same symbol repeated twice")
    @ParameterizedTest(name = "\"{0}{1}\" is a valid roman number")
    @CsvSource({"I, I", "X, X", "C, C", "M, M"})
    void when_ValidRomanWithTheSameSymbolRepeatedTwice_expect_SuccessfulValidation(
            char previousSymbol, char currentSymbol)
    {
        boolean result = subject.validate(getRomanSymbolsInProgress(previousSymbol, currentSymbol));

        assertTrue(result, "Wrong validation, roman number '" + previousSymbol + currentSymbol + "' is valid");
    }

    @DisplayName("Testing invalid roman number with the same symbol repeated twice")
    @ParameterizedTest(name = "\"{0}{1}\" is not a valid roman number")
    @CsvSource({"V, V", "L, L", "D, D"})
    void when_InvalidRomanWithTheSameSymbolRepeatedTwice_expect_FailedValidation(
            char previousSymbol, char currentSymbol)
    {
        boolean result = subject.validate(getRomanSymbolsInProgress(previousSymbol, currentSymbol));

        assertFalse(result, "Wrong validation, roman number '" + previousSymbol + currentSymbol + "' is not valid");
    }

    @DisplayName("Testing valid roman number with the same symbol repeated three times")
    @ParameterizedTest(name = "\"{0}{1}{2}\" is a valid roman number")
    @CsvSource({"I, I, I", "X, X, X", "C, C, C", "M, M, M"})
    void when_ValidRomanWithTheSameSymbolRepeatedThreeTimes_expect_SuccessfulValidation(
            char beforePreviousSymbol, char previousSymbol, char currentSymbol)
    {
        boolean result = subject.validate(getRomanSymbolsInProgress(
                beforePreviousSymbol, previousSymbol, currentSymbol));

        assertTrue(result, "Wrong validation, roman number '" + beforePreviousSymbol + previousSymbol + currentSymbol
                + "' is valid");
    }

    @DisplayName("Testing invalid roman number with the same symbol repeated four times")
    @ParameterizedTest(name = "\"{0}{1}{2}{3}\" is a valid roman number")
    @CsvSource({"I, I, I, I", "X, X, X, X", "C, C, C, C", "M, M, M, M"})
    void when_ValidRomanWithTheSameSymbolRepeatedFourTimes_expect_FailedValidation(
            char lastBeforePreviousSymbol, char beforePreviousSymbol, char previousSymbol, char currentSymbol)
    {
        boolean result = subject.validate(getRomanSymbolsInProgress(
                lastBeforePreviousSymbol, beforePreviousSymbol, previousSymbol, currentSymbol));

        assertFalse(result, "Wrong validation, roman number '" + lastBeforePreviousSymbol + beforePreviousSymbol
                + previousSymbol + currentSymbol + "' is not valid");
    }

    @DisplayName("Testing invalid roman number with two smaller symbols followed by larger symbol")
    @ParameterizedTest(name = "\"{0}{1}{2}\" is not a valid roman number")
    @CsvSource({
            "I, I, V", "I, I, X", "V, I, X", "I, X, L", "X, X, L", "X, X, C", "X, C, D", "C, C, D", "C, C, M", "D, C, M"
    })
    void when_InvalidRomanWithTheSameSmallerSymbolRepeatedTwiceFollowedByLargerSymbol_expect_FailedValidation(
            char beforePreviousSymbol, char previousSymbol, char currentSymbol)
    {
        boolean result = subject.validate(getRomanSymbolsInProgress(
                beforePreviousSymbol, previousSymbol, currentSymbol));

        assertFalse(result, "Wrong validation, roman number '" + beforePreviousSymbol + previousSymbol + currentSymbol
                + "' is not valid");
    }

    @DisplayName("Testing roman number where 1st symbol is greater or equals than 2nd and 2nd greater or equals than 3rd")
    @ParameterizedTest(name = "\"{0}{1}{2}\" is a valid roman number")
    @CsvSource({
            "V, I, I", "X, I, I", "X, V, I", "X, X, I", "X, X, V", "L, I, I", "L, V, I", "L, X, I", "L, X, X",
            "C, I, I", "C, V, I", "C, X, I", "C, X, V", "C, X, X", "C, L, I", "C, L, V", "C, L, X", "C, C, I",
            "C, C, V", "C, C, X", "C, C, L", "D, I, I", "D, V, I", "D, X, I", "D, X, V", "D, X, X", "D, L, I",
            "D, L, V", "D, L, X", "D, C, I", "D, C, V", "D, C, X", "D, C, L", "D, C, C", "M, I, I", "M, V, I",
            "M, X, I", "M, L, I", "M, C, I", "M, D, I", "M, X, V", "M, X, X", "M, L, V", "M, L, X", "M, C, V",
            "M, C, X", "M, C, L", "M, C, C", "M, D, V", "M, D, X", "M, D, L", "M, D, C"
    })
    void when_RomanNumberWhereFirstSymbolGreaterOrEqualsThanSecondAndSecondGreaterThanThird_expect_SuccessfulValidation(
            char beforePreviousSymbol, char previousSymbol, char currentSymbol)
    {
        boolean result = subject.validate(getRomanSymbolsInProgress(
                beforePreviousSymbol, previousSymbol, currentSymbol));

        assertTrue(result, "Wrong validation, roman number '" + previousSymbol + currentSymbol + "' is valid");
    }

    @DisplayName("Testing inconsistent state of the roman symbols in progress")
    @ParameterizedTest(name = "\"null{0}null{1} does not represent a consistent state of roman symbols in progress")
    @CsvSource({"X, X"})
    void when_RomanSymbolsInProgressHasAnInconsistentState_then_ExceptionThrown(
            char beforePreviousSymbol, char currentSymbol)
    {
        Throwable exception = assertThrows(IllegalStateException.class, () -> subject.validate(
                getRomanSymbolsInProgress(null, beforePreviousSymbol, null, currentSymbol)));

        assertEquals("Four last roman symbols \"first symbol is null, X, third symbol is null, X\" are in an "
                + "inconsistent state for the validation", exception.getMessage());
    }
}