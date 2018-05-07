package com.training.arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TwoDimensionArraysUtilTest {

    private static TwoDimensionArraysUtil subject;

    /*
     *    0  1 -2  3
     *    4  5  6  7
     *    8  9 10 11
     */
    private static int[][] integers = new int[][]{{0, 1, -2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};

    private static int[][] negativeIntegers = new int[][]{{-1, -1, -2, -3}, {-4, -5, -6, -7}, {-8, -9, -10, -11}};

    @BeforeAll
    static void setUp() {
        subject = new TwoDimensionArraysUtil();
    }

    @Test
    void given_TwoDimensionArrayAndRowIndexInRange_when_rowSumIsCalled_then_totalRowSumIsReturned() {
        int rowIndexInRange = 0;
        int result = subject.rowSum(integers, rowIndexInRange);

        assertEquals(2, result, "Wrong sum of integers in first row");
    }

    @Test
    void given_TwoDimensionArrayAndOutOfRangeRowIndex_when_rowSumIsCalled_then_ExceptionIsThrown() {
        int rowIndexOutOfRange = -1;

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> subject.rowSum(integers, rowIndexOutOfRange));
    }

    @Test
    void given_EmptyTwoDimensionArray_when_rowSumIsCalled_then_ExceptionIsThrown() {
        int[][] emptyTwoDimensionArray = new int[][]{};

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> subject.rowSum(emptyTwoDimensionArray, 0));
    }

    @Test
    void given_TwoDimensionArray_when_maxIsCalled_then_maxValueIsReturned() {
        int result = subject.max(integers);

        assertEquals(11, result, "Could not find the maximum value in the two dimension array");
    }

    @Test
    void given_TwoDimensionArrayAndColumnIndexInRange_when_columnSumIsCalled_then_totalColumnSumIsReturned() {
        int columnIndexInRange = 2;
        int result = subject.columnSum(integers, columnIndexInRange);

        assertEquals(14, result, "Wrong sum of integers in the third column");
    }
}
