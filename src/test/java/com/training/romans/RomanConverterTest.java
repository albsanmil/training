package com.training.romans;

import com.google.common.testing.NullPointerTester;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RomanConverterTest {

    private static RomanConverter subject;

    @BeforeAll
    static void setUp() {
        subject = new RomanConverter();
    }

    @Test
    void testNulls() {
        NullPointerTester nullPointerTester = new NullPointerTester();
        nullPointerTester.testAllPublicInstanceMethods(subject);
    }

    @DisplayName("Testing known roman symbol")
    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @CsvSource({"I, 1", "V, 5", "X, 10", "L, 50", "C, 100", "D, 500", "M, 1000"})
    void given_KnownRomanSymbol_when_toNumberIsCalled_then_CorrectValueIsReturned(String roman, int value) {
        int result = subject.toNumber(roman);

        assertEquals(value, result, "Wrong conversion, roman " + roman + " cannot be converted to " + value);
    }

    @DisplayName("Testing good combination of two known roman symbols")
    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @CsvSource({"II, 2", "XX, 20", "CC, 200", "MM, 2000", "IV, 4", "VI, 6", "IX, 9", "XI, 11", "CX, 110", "CI, 101", "CV, 105"})
    void given_TwoKnownRomanSymbols_when_toNumberIsCalled_then_CorrectValueIsReturned(String roman, int value) {
        int result = subject.toNumber(roman);

        assertEquals(value, result, "Wrong conversion, roman " + roman + " cannot be converted to " + value);
    }

    @DisplayName("Testing wrong combination of two known roman symbols")
    @ParameterizedTest(name = "\"{0}\" combination is not allowed")
    @ValueSource(strings = {"VV", "VX", "VL", "VC", "VD", "VM", "LL", "LC", "LD", "LM", "DD", "DM"})
    void given_WrongCombinationOfTwoKnownRomanSymbols_when_toNumberIsCalled_then_IllegalArgumentExceptionIsThrown(String roman) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> subject.toNumber(roman));

        assertEquals("Wrong combination of roman symbols " + roman, exception.getMessage());
    }

    @DisplayName("Testing good combination of three known roman symbols")
    @ParameterizedTest(name = "\"{0}\" should be {1}")
    @CsvSource({"III, 3", "VII, 7", "XIV, 14", "CDX, 410"})
    void given_ThreeKnownRomanSymbols_when_toNumberIsCalled_then_CorrectValueIsReturned(String roman, int value) {
        int result = subject.toNumber(roman);

        assertEquals(value, result, "Wrong conversion, roman " + roman + " cannot be converted to " + value);
    }

    @DisplayName("Testing two or more smaller known roman symbols in front of a larger one")
    @ParameterizedTest(name = "\"{0}\" combination is not allowed")
    @ValueSource(strings = {"IIV", "IIIV", "VVX", "VVVX", "IVVX", "IVX"})
    void given_TwoOrMoreSmallerKnownRomanSymbolsInFrontOfLargerOne_when_toNumberIsCalled_then_IllegalArgumentExceptionIsThrown(String roman) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> subject.toNumber(roman));

        assertEquals("Wrong combination of roman symbols " + roman, exception.getMessage());
    }

    @DisplayName("Testing more than three times the same roman symbol is not allowed")
    @ParameterizedTest(name = "\"{0}\" combination is not allowed")
    @ValueSource(strings = {"IIII", "XXXX", "CCCC"})
    void given_MoreThanThreeTimesTheSameKnownRomanSymbol_when_toNumberIsCalled_then_IllegalArgumentExceptionIsThrown(String roman) {
        Throwable exception = assertThrows(IllegalArgumentException. class, () -> subject.toNumber(roman));

        assertEquals("Wrong combination of roman symbols " + roman, exception.getMessage());
    }









//    @Test
//    void given_RomanNumberOfAChar_when_toNumberIsCalled_then_valueIsReturned() {
//        int result = subject.toNumber("D");
//
//        assertEquals(500, result, "Wrong the value is not correct");
//    }
//
//
//    @Test
//    void given_RomanNumberBiggerOfAChar_when_toNumberIsCalled_then_valueIsReturned() {
//        int result = subject.toNumber("MMMCCXLIV");
//
//        assertEquals(3244, result, "Wrong the value is not correct");
//    }
//
//    @Test
//    void given_WrongRomanNumberWithMoreThanThreeEqualContiguousCharacter_when_toNumberIsCalled_then_zeroIsReturned() {
//        int result = subject.toNumber("CCCCXXVIII");
//
//        assertEquals(0, result, "Wrong the Roman numeral, contains more than three equal characters followed");
//    }
//
//    @Test
//    void given_WrongRomanNumberWithACharacterEqualToItsLeftWhenSubtractingItsValueFromItsRight_when_toNumberIsCalled_then_zeroIsReturned() {
//        int result = subject.toNumber("CDXXXIIX");
//
//        assertEquals(0, result, "When a character is subtracted from the value of the previous character because it has " +
//                "a lower value, it is verified that it does not have the same character on its left.");
//    }
//
//    @Test
//    void given_WrongRomanNumberWithTheVMoreThanOne_when_toNumberIsCalled_then_zeroIsReturned() {
//        int result = subject.toNumber("CXXVIV");
//
//        assertEquals(0, result, "Wrong roman number with the V more than once");
//
//    }
//
//    @Test
//    void given_WrongRomanNumberWithTheLMoreThanOne_when_toNumberIsCalled_then_zeroIsReturned() {
//        int result = subject.toNumber("MMMDCCCLXLV");
//
//        assertEquals(0, result, "Wrong roman number with the L more than once");
//
//    }
//
//    @Test
//    void given_WrongRomanNumberWithTheDMoreThanOne_when_toNumberIsCalled_then_zeroIsReturned() {
//        int result = subject.toNumber("MDCD");
//
//        assertEquals(0, result, "Wrong roman number with the D more than once");
//
//    }
//
//    @Test
//    void given_WrongRomanNumberWithACharacterThatDoesNotExistRomanNumerals_when_toNumberIsCalled_then_zeroInReturned() {
//        int result = subject.toNumber("gclññggggfDs");
//
//        assertEquals(0, result, "Wrong roman number has some character that does not exist in Roman numerals");
//    }
}