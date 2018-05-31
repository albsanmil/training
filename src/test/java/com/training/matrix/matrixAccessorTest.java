package com.training.matrix;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class matrixAccessorTest {

    private static MatrixAccessor subject;

    @BeforeAll
    static void setUp() {
        subject = new MatrixAccessor();
    }

    @Test
    void when_SizeOfMatrixIsOne_then_CorrectElementIsReturned() {
        long result = subject.access(1, 0, 0);

        assertEquals(1, result, "Element in (0,0) should be 1, not " + result);
    }

    @Test
    void when_SizeOfMatrixTwoAndAccessElementInZeroZero_then_CorrectElementIsReturned() {
        long result = subject.access(2, 0, 0);

        assertEquals(1, result, "Element in (0,0) should be 1, not " + result);
    }

    @Test
    void when_SizeOfMatrixTwoAndAccessElementInZeroOne_then_CorrectElementIsReturned() {
        long result = subject.access(2, 0, 1);

        assertEquals(2, result, "Element in (0,1) should be 2, not " + result);
    }

    @Test
    void when_SizeOfMatrixTwoAndAccessElementInOneZero_then_CorrectElementIsReturned() {
        long result = subject.access(2, 1, 0);

        assertEquals(2, result, "Element in (1,0) should be 2, not " + result);
    }

    @Test
    void when_SizeOfMatrixTwoAndAccessElementInOneOne_then_CorrectElementIsReturned() {
        long result = subject.access(2, 1,1);

        assertEquals(1, result, "Element in (1,1) should be 1, not " + result);
    }


    @Test
    void when_SizeOfMatrixThreeAndAccessElementInZeroZero_then_CorrectElementIsReturned() {
        long result = subject.access(3, 0, 0);

        assertEquals(1, result, "Element in (0,0) should be 1, not " + result);
    }

    @Test
    void when_SizeOfMatrixThreeAndAccessElementInZeroOne_then_CorrectElementIsReturned() {
        long result = subject.access(3, 0, 1);

        assertEquals(2, result, "Element in (0,1) should be 2, not " + result);
    }

    @Test
    void when_SizeOfMatrixThreeAndAccessElementInZeroTwo_then_CorrectElementIsReturned() {
        long result = subject.access(3, 0, 2);

        assertEquals(3, result, "Element in (0,2) should be 3, not " + result);
    }

    @Test
    void when_SizeOfMatrixThreeAndAccessElementInOneZero_then_CorrectElementIsReturned() {
        long result = subject.access(3, 1, 0);

        assertEquals(2, result, "Element in (1,0) should be 2, not " + result);
    }

    @Test
    void when_SizeOfMatrixThreeAndAccessElementInOneOne_then_CorrectElementIsReturned() {
        long result = subject.access(3, 1, 1);

        assertEquals(3, result, "Element in (1,1) should be 3, not " + result);
    }

    @Test
    void when_SizeOfMatrixThreeAndAccessElementInOneTwo_then_CorrectElementIsReturned() {
        long result = subject.access(3, 1, 2);

        assertEquals(1, result, "Element in (1,2) should be 1, not " + result);
    }

    @Test
    void when_SizeOfMatrixThreeAndAccessElementInTwoZero_then_CorrectElementIsReturned() {
        long result = subject.access(3, 2, 0);

        assertEquals(3, result, "Element in (2,0) should be 3, not " + result);
    }

    @Test
    void when_SizeOfMatrixThreeAndAccessElementInTwoOne_then_CorrectElementIsReturned() {
        long result = subject.access(3, 2, 1);

        assertEquals(1, result, "Element in (2,1) should be 1, not " + result);
    }

    @Test
    void when_SizeOfMatrixThreeAndAccessElementInTwoTwo_then_CorrectElementIsReturned() {
        long result = subject.access(3, 2, 2);

        assertEquals(2, result, "Element in (2,2) should be 2, not " + result);
    }
}