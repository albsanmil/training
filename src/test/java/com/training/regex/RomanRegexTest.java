package com.training.regex;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RomanRegexTest {

    private static RomanRegex subject;

    @BeforeAll
    static void setUp() {
        subject = new RomanRegex();
    }

    @DisplayName("Testing known roman symbol")
    @ParameterizedTest(name = "\"{0}\" is a valid roman number")
    @ValueSource(strings = {"I", "V", "X", "L", "C", "D", "M"})
    void when_RomanSymbolIsKnown_expect_SuccessfulValidation(String romanSymbol) {
        boolean result = subject.validateRomanNumber(romanSymbol);

        assertTrue(result, "Wrong validation, roman symbol '" + romanSymbol + "' is a valid roman number");
    }
}