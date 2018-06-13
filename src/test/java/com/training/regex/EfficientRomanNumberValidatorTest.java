package com.training.regex;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EfficientRomanNumberValidatorTest {

    private static EfficientRomanNumberValidator subject;

    @BeforeAll
    static void setUp() {
        subject = new EfficientRomanNumberValidator();
    }

    @DisplayName("Testing known roman symbol")
    @ParameterizedTest(name = "\"{0}\" is a valid roman number")
    @ValueSource(strings = {"I", "V", "X", "L", "C", "D", "M"})
    void when_RomanSymbolIsKnown_expect_SuccessfulValidation(String romanSymbol) {
        boolean result = subject.validate(romanSymbol);

        assertTrue(result, "Wrong validation, roman symbol '" + romanSymbol + "' is a valid roman number");
    }

    @DisplayName("Testing unknown symbol")
    @ParameterizedTest(name = "\"{0}\" is not a valid roman number")
    @ValueSource(strings = {"A", "B", "H", "R", "Z"})
    void when_UnknownSymbol_expect_FailedValidation(String unknownSymbol) {
        boolean result = subject.validate(unknownSymbol);

        assertFalse(result, "Wrong validation, unknown symbol '" + unknownSymbol + "' is not a valid roman symbol");
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

    @DisplayName("Testing valid roman number with the same symbol repeated twice")
    @ParameterizedTest(name = "\"{0}\" is a valid roman number")
    @ValueSource(strings = {"II", "XX", "CC", "MM"})
    void when_ValidRomanWithTheSameSymbolRepeatedTwice_expect_SuccessfulValidation(String romanNumber) {
        boolean result = subject.validate(romanNumber);

        assertTrue(result, "Wrong validation, roman number '" + romanNumber + "' is valid");
    }

    @DisplayName("Testing invalid roman number with the same symbol repeated twice")
    @ParameterizedTest(name = "\"{0}\" is not a valid roman number")
    @ValueSource(strings = {"VV", "LL", "DD"})
    void when_InvalidRomanWithTheSameSymbolRepeatedTwice_expect_FailedValidation(String romanNumber) {
        boolean result = subject.validate(romanNumber);

        assertFalse(result, "Wrong validation, roman number '" + romanNumber + "' is not valid");
    }

    @DisplayName("Testing valid roman number with the same symbol repeated three times")
    @ParameterizedTest(name = "\"{0}\" is a valid roman number")
    @ValueSource(strings = {"III", "XXX", "CCC", "MMM"})
    void when_ValidRomanWithTheSameSymbolRepeatedThreeTimes_expect_SuccessfulValidation(String romanNumber) {
        boolean result = subject.validate(romanNumber);

        assertTrue(result, "Wrong validation, roman number '" + romanNumber + "' is valid");
    }

    @DisplayName("Testing invalid roman number with the same symbol repeated four times")
    @ParameterizedTest(name = "\"{0}\" is a valid roman number")
    @ValueSource(strings = {"IIII", "XXXX", "CCCC", "MMMM"})
    void when_ValidRomanWithTheSameSymbolRepeatedFourTimes_expect_FailedValidation(String romanNumber) {
        boolean result = subject.validate(romanNumber);

        assertFalse(result, "Wrong validation, roman number '" + romanNumber + "' is not valid");
    }

    @DisplayName("Testing roman number where 1st symbol is greater or equals than 2nd and 2nd greater or equals than 3rd")
    @ParameterizedTest(name = "\"{0}\" is a valid roman number")
    @ValueSource(strings = {
            "VII", "XII", "XVI", "XXI", "XXV", "LII", "LVI", "LXI", "LXX", "CII", "CVI", "CXI", "CXV", "CXX", "CLI",
            "CLV", "CLX", "CCI", "CCV", "CCX", "CCL", "DII", "DVI", "DXI", "DXV", "DXX", "DLI", "DLV", "DLX", "DCI",
            "DCV", "DCX", "DCL", "DCC", "MII", "MVI", "MXI", "MXV", "MXX", "MLI", "MLV", "MLX", "MCI", "MCV", "MCX",
            "MCL", "MCC", "MDI", "MDV", "MDX", "MDL", "MDC"
    })
    void when_RomanNumberWhereFirstSymbolGreaterOrEqualsThanSecondAndSecondGreaterThanThird_expect_SuccessfulValidation(
            String romanNumber)
    {
        boolean result = subject.validate(romanNumber);

        assertTrue(result, "Wrong validation, roman number '" + romanNumber + "' is valid");
    }

    @DisplayName("Testing pairs of roman symbols that use the subtraction rule")
    @ParameterizedTest(name = "\"{0}\" is a valid roman number")
    @ValueSource(strings = {"IV", "IX", "XL", "XC", "CD", "CM"})
    void when_PairsOfRomanSymbolsThatUseSubtractionRule_expect_SuccessfulValidation(String romanNumber)
    {
        boolean result = subject.validate(romanNumber);

        assertTrue(result, "Wrong validation, roman number '" + romanNumber + "' is valid");
    }

    @DisplayName("Testing the rule of subtraction with more than two Roman symbols")
    @ParameterizedTest(name = "\"{0}\" is a valid roman number")
    @ValueSource(strings = {"MCM", "MMCM", "MMMCM", "CXC", "CCXC", "CCCXC", "XIX", "XXIX", "XXXIX"})
    void when_ThreeRomanSymbolsOrMoreThatUseSubtractionRule_expect_SuccessfulValidation(String romanNumber)
    {
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

    @DisplayName("Testing invalid roman number with two smaller symbols followed by larger symbol")
    @ParameterizedTest(name = "\"{0}\" is not a valid roman number")
    @ValueSource(strings = {"IIV", "IIX", "VIX", "IXL", "XXL", "XXC", "XCD", "CCD", "CCM", "DCM"})
    void when_InvalidRomanWithTheSameSmallerSymbolRepeatedTwiceFollowedByLargerSymbol_expect_FailedValidation(
            String romanNumber)
    {
        boolean result = subject.validate(romanNumber);

        assertFalse(result, "Wrong validation, roman number '" + romanNumber + "' is not valid");
    }

    @DisplayName("Testing invalid roman number with the same symbol repeated twice separated by another smaller symbol")
    @ParameterizedTest(name = "\"{0}\" is not a valid roman number")
    @ValueSource(strings = {"VIV", "LXL", "DCD"})
    void when_InvalidRomanWithTheSameSymbolRepeatedTwiceSeparatedByAnotherSmallerSymbol_expect_FailedValidation(
            String romanNumber)
    {
        boolean result = subject.validate(romanNumber);

        assertFalse(result, "Wrong validation, roman number '" + romanNumber + "' is not valid");
    }

    @DisplayName("Testing roman number greater than 3999")
    @ParameterizedTest(name = "\"{0}\" is a valid roman number")
    @ValueSource(strings = {"IV_", "V_", "VI_", "VII_", "VIII_", "IX_", "X_", "MDLV_X", "MMMCMLXXXVIII_DCXLIX",
           })
    void when_RomanNumberGreaterTran3999_expect_SuccessfulValidation(String romanNumber)
    {
        boolean result = subject.validate(romanNumber);

        assertTrue(result, "Wrong validation, roman number '" + romanNumber + "' is valid");
    }

    @DisplayName("Testing roman number greater than 3999")
    @ParameterizedTest(name = "\"{0}\" is not a valid roman number")
    @ValueSource(strings = { "I_", "III_", "V__", "_V", "A_B", "_"})
    void when_RomanNumberGreaterTran39999_expect_SuccessfulValidation(String romanNumber)
    {
        boolean result = subject.validate(romanNumber);

        assertFalse(result, "Wrong validation, roman number '" + romanNumber + "' is not valid");
    }
}