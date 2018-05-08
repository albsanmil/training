package com.training.arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MatrixUtilTest {

    private static MatrixUtil subject;

    /*
     *    0   1  -2   3
     *    4  -5   6   7
     *    8   9  10  11
     *   -5  -6  -7  -8
     */
    private static int[][] squareMatrix = new int[][]{{0, 1, -2, 3}, {4, -5, 6, 7}, {8, 9, 10, 11}, {-5, -6, -7, -8}};

    private static int[][] rowMagic = new int[][]{{2, 7, 6}, {8, 4, 3}, {0, 6, 9}};

    @BeforeAll
    static void setUp() {
        subject = new MatrixUtil();
    }

    @Test
    void given_SquareMatrixAndRowIndexInRange_when_rowSumIsCalled_then_totalRowSumIsReturned() {
        int rowIndexInRange = 0;
        int result = subject.rowSum(squareMatrix, rowIndexInRange);

        assertEquals(2, result, "Wrong sum of integers in first row");
    }

    @Test
    void given_SquareMatrixAndOutOfRangeRowIndex_when_rowSumIsCalled_then_ExceptionIsThrown() {
        int rowIndexOutOfRange = -1;

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> subject.rowSum(squareMatrix, rowIndexOutOfRange));
    }

    @Test
    void given_EmptySquareMatrix_when_rowSumIsCalled_then_ExceptionIsThrown() {
        int[][] emptyMatrix = new int[][]{};

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> subject.rowSum(emptyMatrix, 0));
    }

    @Test
    void given_SquareMatrix_when_maxIsCalled_then_maxValueIsReturned() {
        int result = subject.max(squareMatrix);

        assertEquals(11, result, "Could not find the maximum integer in the matrix");
    }

    @Test
    void given_SquareMatrixAndColumnIndexInRange_when_columnSumIsCalled_then_totalColumnSumIsReturned() {
        int columnIndexInRange = 2;
        int result = subject.columnSum(squareMatrix, columnIndexInRange);

        assertEquals(7, result, "Wrong sum of integers in the third column");
    }

    @Test
    void given_SquareMatrix_when_allRowsSumsIsCalled_then_totalRowsIsReturnedInArray() {
        int[] totalRowsResult = {2, 22, 38};
        int[] result = subject.allRowsSums(squareMatrix);

        assertEquals(totalRowsResult, result, "The array of the sum of the rows is incorrect");
    }

    @Test
    void given_SquareMatrix_when_isArrayRowMagicIsCalled_then_trueIsReturned() {
        boolean result = subject.isRowMagic(rowMagic);

        assertEquals(true, result, "Wrong result because it's not a magic rows array");
    }
}
