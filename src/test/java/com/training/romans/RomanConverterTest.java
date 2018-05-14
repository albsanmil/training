package com.training.romans;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RomanConverterTest {

    private static RomanConverter subject;

    @BeforeAll
    static void setUp() { subject = new RomanConverter();
    }

    @Test
    void given_EmplyRomanNumber_when_toNumberIsCalled_then_zeroIsRetuned() {
        int result = subject.toNumber("");

        assertEquals(0, result, "Wrong the method can not return a value if it is passed an empty string");
    }

    @Test
    void given_RomanNumberOfAChar_when_toNumberIsCalled_then_valueIsReturned() {
        int result = subject.toNumber("D");

        assertEquals(500, result, "Wrong the value is not correct");
    }

    @Test
    void given_RomanNumberBiggerOfAChar_when_toNumberIsCalled_then_valueIsReturned() {
        int result = subject.toNumber("MMMCCXLIV");

        assertEquals(3244, result, "Wrong the value is not correct");
    }

    @Test
    void given_WrongRomanNumberWithMoreThanThreeEqualContiguousCharacter_when_toNumberIsCalled_then_zeroIsReturned() {
        int result = subject.toNumber("CCCCXXVIII");

        assertEquals(0, result, "Wrong the Roman numeral, contains more than three equal characters followed");
    }

    @Test
    void given_WrongRomanNumberWithACharacterEqualToItsLeftWhenSubtractingItsValueFromItsRight_when_toNumberIsCalled_then_zeroIsReturned() {
        int result = subject.toNumber("CDXXXIIX");

        assertEquals(0, result, "When a character is subtracted from the value of the previous character because it has " +
                "a lower value, it is verified that it does not have the same character on its left.");
    }

    @Test
    void given_WrongRomanNumberWithTheVMoreThanOne_when_toNumberIsCalled_then_zeroIsReturned() {
        int result = subject.toNumber("CXXVIV");

        assertEquals(0, result, "Wrong roman number with the V more than once");

    }

    @Test
    void given_WrongRomanNumberWithTheLMoreThanOne_when_toNumberIsCalled_then_zeroIsReturned() {
        int result = subject.toNumber("MMMDCCCLXLV");

        assertEquals(0, result, "Wrong roman number with the L more than once");

    }

    @Test
    void given_WrongRomanNumberWithTheDMoreThanOne_when_toNumberIsCalled_then_zeroIsReturned() {
        int result = subject.toNumber("MDCD");

        assertEquals(0, result, "Wrong roman number with the D more than once");

    }

//    @Test
//    void given_WrongRomanNumberWithACharacterThatDoesNotExistRomanNumerals_when_toNumberIsCalled_then_zeroInReturned() {
//        int result = subject.toNumber("sCDs");
//
//        assertEquals(0, result, "Wrong roman number has some character that does not exist in Roman numerals");
//    }
}