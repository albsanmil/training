package com.training.romans;

import com.google.common.testing.NullPointerTester;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanNumberConverterTest {

    private static RomanNumberConverter subject;

    @BeforeEach
    void setUp() {
        subject = new RomanNumberConverter();
    }

    @DisplayName("Testing null argument")
    @Test
    void testNulls() {
        NullPointerTester nullPointerTester = new NullPointerTester();
        nullPointerTester.testAllPublicConstructors(RomanNumberConverter.class);
        nullPointerTester.testAllPublicInstanceMethods(subject);
    }



    @DisplayName("Testing known roman symbol")
    @ParameterizedTest(name = "\"{0}\" is converted to {1}")
    @CsvSource({"I, 1", "V, 5", "X, 10", "L, 50", "C, 100", "D, 500", "M, 1000"})
    void when_KnownRomanSymbol_expect_SuccessfulConversion(String romanSymbol, int convertedValue) {
        int result = subject.convert(RomanNumber.valueOf(romanSymbol));

        assertEquals(convertedValue, result, "Wrong conversion, roman number '" + romanSymbol
                + "' cannot be converted to " + convertedValue);
    }

    @DisplayName("Testing pairs of roman symbols that use the subtraction rule")
    @ParameterizedTest(name = "\"{0}\" is converted to {1}")
    @CsvSource({"IV, 4", "IX, 9", "XL, 40", "XC, 90", "CD, 400", "CM, 900"})
    void when_PairsOfRomanSymbolsThatUseSubtractionRule_expect_SuccessfulConversion(
            String romanNumber, int convertedValue)
    {
        int result = subject.convert(RomanNumber.valueOf(romanNumber));

        assertEquals(convertedValue, result, "Wrong conversion, roman number '" + romanNumber
                + "' cannot be converted to " + convertedValue);
    }

    @DisplayName("Testing roman number which symbols can be combined together")
    @ParameterizedTest(name = "\"{0}\" is converted to {1}")
    @CsvSource({
            "II, 2", "III, 3", "VI, 6", "VII, 7", "XI, 11", "XII, 12", "XV, 15", "XVI, 16", "XX, 20", "XXI, 21",
            "XXV, 25", "XXX, 30", "LI, 51", "LII, 52", "LV, 55", "LVI, 56", "LX, 60", "LXI, 61", "LXV, 65", "LXX, 70",
            "CI, 101", "CII, 102", "CV, 105", "CVI, 106", "CX, 110", "CXI, 111", "CXV, 115", "CXX, 120", "CL, 150",
            "CLI, 151", "CLV, 155", "CLX, 160", "CC, 200", "CCI, 201", "CCV, 205", "CCX, 210", "CCL, 250", "CCC, 300",
            "DI, 501", "DII, 502", "DV, 505", "DVI, 506", "DX, 510", "DXI, 511", "DXX, 520", "DL, 550", "DLI, 551",
            "DLV, 555", "DLX, 560", "DC, 600", "DCI, 601", "DCV, 605", "DCX, 610", "DCL, 650", "DCC, 700", "MI, 1001",
            "MII, 1002", "MV, 1005", "MVI, 1006", "MX, 1010", "MXI, 1011", "MXV, 1015", "MXX, 1020", "ML, 1050",
            "MLI, 1051", "MLV, 1055", "MLX, 1060", "MC, 1100", "MCI, 1101", "MCV, 1105", "MCX, 1110", "MCL, 1150",
            "MCC, 1200", "MD, 1500", "MDI, 1501", "MDV, 1505", "MDX, 1510", "MDL, 1550", "MDC, 1600", "MM, 2000",
            "MMM, 3000"
    })
    void when_RomanNumberWhichSymbolsCanBeCombinedTogether_expect_SuccessfulConversion(
            String romanNumber, int convertedValue)
    {
        int result = subject.convert(RomanNumber.valueOf(romanNumber));

        assertEquals(convertedValue, result, "Wrong conversion, roman number '" + romanNumber
                + "' cannot be converted to " + convertedValue);
    }

    @DisplayName("Testing numbers greater than 4000")
    @ParameterizedTest(name = "\"{0}\" is converted to {1}")
    @CsvSource({"IV_, 4000", "IV_VI, 4006", "VIII_XLIV, 8044", "MMMCMLVIII_CMXLIV, 3958944",
            "MMCMXLIX_DCLVIII, 2949658"})
    void when_RomanNumberTooLarge_expect_SuccessfulConversion(String romanNumber, int convertedValue) {
        int result = subject.convert(RomanNumber.valueOf(romanNumber));

        assertEquals(convertedValue, result, "Wrong conversion, roman number '" + romanNumber
                + "' cannot be converted to " + convertedValue);
    }
}
