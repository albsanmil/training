package com.training.romans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeatedSymbolValidatorTest {

    private RepeatedSymbolValidator subject;

    @BeforeEach
    void setUp() {
        subject = new RepeatedSymbolValidator();
    }

    @DisplayName("Testing valid roman number with one symbol")
    @ParameterizedTest(name = "\"{0}\" is a valid roman number")
    @ValueSource(chars = {'I', 'V', 'X', 'L', 'C', 'D', 'M'})
    void when_ValidRomanWithOneSymbol_expect_SuccessfulValidation(char roman) {
        RomanSymbol currentSymbol = RomanSymbol.fromCharacter(roman);

        boolean result = subject.validate(currentSymbol);

        assertTrue(result, "Wrong validation, roman number '" + roman + "' is valid");
    }

    @DisplayName("Testing valid roman number with the same symbol repeated twice")
    @ParameterizedTest(name = "\"{0}{1}\" is a valid roman number")
    @CsvSource({"I, I", "X, X", "C, C", "M, M"})
    void when_ValidRomanWithTheSameSymbolRepeatedTwice_expect_SuccessfulValidation(char first, char last) {
        RomanSymbol firstSymbol = RomanSymbol.fromCharacter(first);
        RomanSymbol lastSymbol = RomanSymbol.fromCharacter(last);

        boolean result = subject.validate(firstSymbol);
        assertTrue(result);

        result = subject.validate(lastSymbol);
        assertTrue(result, "Wrong validation, roman number '" + first + last + "' is valid");
    }

    @DisplayName("Testing invalid roman number with the same symbol repeated twice")
    @ParameterizedTest(name = "\"{0}{1}\" is not a valid roman number")
    @CsvSource({"V, V", "L, L", "D, D"})
    void when_InvalidRomanWithTheSameSymbolRepeatedTwice_expect_FailedValidation(char first, char last) {
        RomanSymbol firstSymbol = RomanSymbol.fromCharacter(first);
        RomanSymbol lastSymbol = RomanSymbol.fromCharacter(last);

        boolean result = subject.validate(firstSymbol);
        assertTrue(result);

        result = subject.validate(lastSymbol);
        assertFalse(result, "Wrong validation, roman number '" + first + last + "' is not valid");
    }

    @DisplayName("Testing valid roman number with the same symbol repeated three times")
    @ParameterizedTest(name = "\"{0}{1}{2}\" is a valid roman number")
    @CsvSource({"I, I, I", "X, X, X", "C, C, C", "M, M, M"})
    void when_ValidRomanWithTheSameSymbolRepeatedThreeTimes_expect_SuccessfulValidation(
            char first, char second, char last)
    {
        RomanSymbol firstSymbol = RomanSymbol.fromCharacter(first);
        RomanSymbol secondSymbol = RomanSymbol.fromCharacter(second);
        RomanSymbol lastSymbol = RomanSymbol.fromCharacter(last);

        boolean result = subject.validate(firstSymbol);
        assertTrue(result);

        result = subject.validate(secondSymbol);
        assertTrue(result);

        result = subject.validate(lastSymbol);
        assertTrue(result, "Wrong validation, roman number '" + first + second + last + "' is valid");
    }

    @DisplayName("Testing invalid roman number with the same symbol repeated four times")
    @ParameterizedTest(name = "\"{0}{1}{2}{3}\" is a valid roman number")
    @CsvSource({"I, I, I, I", "X, X, X, X", "C, C, C, C", "M, M, M, M"})
    void when_ValidRomanWithTheSameSymbolRepeatedFourTimes_expect_FailedValidation(
            char first, char second, char third, char last)
    {
        RomanSymbol firstSymbol = RomanSymbol.fromCharacter(first);
        RomanSymbol secondSymbol = RomanSymbol.fromCharacter(second);
        RomanSymbol thirdSymbol = RomanSymbol.fromCharacter(third);
        RomanSymbol lastSymbol = RomanSymbol.fromCharacter(last);

        boolean result = subject.validate(firstSymbol);
        assertTrue(result);

        result = subject.validate(secondSymbol);
        assertTrue(result);

        result = subject.validate(thirdSymbol);
        assertTrue(result);

        result = subject.validate(lastSymbol);
        assertFalse(result, "Wrong validation, roman number '" + first + second + third + last + "' is not valid");
    }

    @DisplayName("Testing invalid roman number with the same smaller symbol repeated twice followed by larger symbol")
    @ParameterizedTest(name = "\"{0}{1}{2}\" is not a valid roman number")
    @CsvSource({
            "I, I, V", "I, I, X", "I, I, L", "I, I, C", "I, I, D", "I, I, M",
            "X, X, L", "X, X, C", "X, X, D", "X, X, M",
            "C, C, D", "C, C, M"
    })
    void when_InvalidRomanWithTheSameSmallerSymbolRepeatedTwiceFollowedByLargerSymbol_expect_FailedValidation(
            char first, char second, char last)
    {
        RomanSymbol firstSymbol = RomanSymbol.fromCharacter(first);
        RomanSymbol secondSymbol = RomanSymbol.fromCharacter(second);
        RomanSymbol lastSymbol = RomanSymbol.fromCharacter(last);

        boolean result = subject.validate(firstSymbol);
        assertTrue(result);

        result = subject.validate(secondSymbol);
        assertTrue(result);

        result = subject.validate(lastSymbol);
        assertFalse(result, "Wrong validation, roman number '" + first + second + last + "' is not valid");
    }
}