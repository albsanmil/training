package com.training.romans;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanSymbolTest {

    @DisplayName("Testing known roman symbol")
    @ParameterizedTest(name = "\"{0}\" is a valid roman number")
    @CsvSource({"I, I", "V, V", "X, X", "L, L", "C, C", "D, D", "M, M"})
    void when_RomanSymbolIsKnown_expect_SuccessfulConversion(char character, RomanSymbol romanSymbol) {
        RomanSymbol result = RomanSymbol.fromCharacter(character);

        assertEquals(romanSymbol, result, "Wrong conversion, roman symbol '" + character + "' is a valid roman number");
    }

    @DisplayName("Testing unknown symbol")
    @ParameterizedTest(name = "\"{0}\" is not a valid roman number")
    @ValueSource(strings = {"A", "B", "H", "R", "Z"})
    void when_UnknownSymbol_expect_FailedConversion(char character) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> RomanSymbol.fromCharacter(character));

        assertEquals("'" + character + "' is not a valid roman symbol", exception.getMessage());
    }
}