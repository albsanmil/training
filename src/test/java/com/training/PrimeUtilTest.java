package com.training;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimeUtilTest {

    private static final int ZERO = 0;
    private static final int ONE = 1;

    private static final int POSITIVE_NUMBER_MULTIPLE_OF_TWO = 4;
    private static final int POSITIVE_NUMBER_MULTIPLE_OF_THREE = 9;
    private static final int POSITIVE_NUMBER_MULTIPLE_OF_FIVE = 25;

    private static final int POSITIVE_NUMBER_WITH_EXACT_SQUARE_ROOT = 49;
    private static final int POSITIVE_PRIME_NUMBER_WITH_NON_EXACT_SQUARE_ROOT = 457;
    private static final int POSITIVE_NON_PRIME_NUMBER_WITH_NON_EXACT_SQUARE_ROOT = 459;


    private static PrimeUtil subject;


    @BeforeAll
    static void setup() {
        subject = new PrimeUtil();
    }

    @DisplayName("Positive numbers multiple of 2, 3 or 5 are not prime")
    @ParameterizedTest(name = "\"{0}\" is not a prime number")
    @ValueSource(ints = {POSITIVE_NUMBER_MULTIPLE_OF_TWO, POSITIVE_NUMBER_MULTIPLE_OF_THREE, POSITIVE_NUMBER_MULTIPLE_OF_FIVE})
    void given_PositiveNumbersMultipleOfTwoThreeOrFive_when_isPrimeIsCalled_then_numberIsNotPrime(int number) {
        boolean result = subject.isPrime(number);

        assertFalse(result, number + " is not a prime number");
    }

//    @Test
//    void given_PositiveNumberMultipleOfTwo_when_isPrimeIsCalled_then_numberIsCompound() {
//        boolean result = subject.isPrime(POSITIVE_NUMBER_MULTIPLE_OF_TWO);
//
//        assertFalse(result, POSITIVE_NUMBER_MULTIPLE_OF_TWO + " is not a prime number");
//    }
//
//    @Test
//    void given_PositiveNumberMultipleOfThree_when_isPrimeIsCalled_then_numberIsCompound() {
//        boolean result = subject.isPrime(POSITIVE_NUMBER_MULTIPLE_OF_THREE);
//
//        assertFalse(result, POSITIVE_NUMBER_MULTIPLE_OF_THREE + " is not a prime number");
//    }
//
//    @Test
//    void given_PositiveNumberMultipleOfFive_when_isPrimeIsCalled_then_numberIsCompound() {
//        boolean result = subject.isPrime(POSITIVE_NUMBER_MULTIPLE_OF_FIVE);
//
//        assertFalse(result, POSITIVE_NUMBER_MULTIPLE_OF_FIVE + " is not a prime number");
//    }

    @Test
    void given_PositiveNumberWithExactSquareRoot_when_isPrimeIsCalled_then_numberIsCompound() {
        boolean result = subject.isPrime(POSITIVE_NUMBER_WITH_EXACT_SQUARE_ROOT);

        assertFalse(result, POSITIVE_NUMBER_WITH_EXACT_SQUARE_ROOT + " is not a prime number");
    }

    @Test
    void given_PositivePrimeNumberWithNonExactSquareRoot_when_isPrimeIsCalled_then_numberIsPrime() {
        boolean result = subject.isPrime(POSITIVE_PRIME_NUMBER_WITH_NON_EXACT_SQUARE_ROOT);

        assertTrue(result, POSITIVE_PRIME_NUMBER_WITH_NON_EXACT_SQUARE_ROOT + " is a prime number");
    }

    @Test
    void given_PositiveNonPrimeNumberWithNonExactSquareRoot_when_isPrimeIsCalled_then_numberIsCompound() {
        boolean result = subject.isPrime(POSITIVE_NON_PRIME_NUMBER_WITH_NON_EXACT_SQUARE_ROOT);

        assertFalse(result, POSITIVE_NON_PRIME_NUMBER_WITH_NON_EXACT_SQUARE_ROOT + " is not a prime number");
    }

    @Test
    void given_Zero_when_isPrimeisCalled_then_numberIsNotPrime() {
        boolean result = subject.isPrime(ZERO);

        assertFalse(result, "Zero is not prime");
    }

    @Test
    void given_One_when_isPrimeisCalled_then_numberIsNotPrime() {
        boolean result = subject.isPrime(ONE);

        assertFalse(result, "One is not prime");
    }
}
