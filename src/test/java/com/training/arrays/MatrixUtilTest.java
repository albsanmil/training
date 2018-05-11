package com.training.arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixUtilTest {

    /*
     *    0   1  -2   3
     *    4  -5   6   7
     *    8   9  10  11
     *   -5  -6  -7  -8
     */
    private static int[][] squareMatrix = new int[][]{{0, 1, -2, 3}, {4, -5, 6, 7}, {8, 9, 10, 11}, {-5, -6, -7, -8}};

    /*
     *   -8  -7  -9  -5
     *   -7  -5  -6  -7
     *   -8  -9 -10 -11
     *   -5  -6  -7  -8
     */
    private static int[][] squareMatrixNegative = new int[][]{{-8, -7, -9, -5}, {-7, -5, -6, -7}, {-8, -9, -10, -11}, {-5, -6, -7, -8}};
    /*
     *    0   1  -2   3
     *    4  -5
     *    8   9  10  11
     *   -5  -6  -7
     */
    private static int[][] irregularMatrix = new int[][]{{0, 1, -2, 3}, {4, -5}, {8, 9, 10, 11}, {-5, -6, -7}};

    private static int[][] rowMagic = new int[][]{{2, 7, 6}, {8, 4, 3}, {12, -6, 9}};

    private static int[][] emptyMatrix = new int[][]{};

    private static MatrixUtil subject;

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

        int result = subject.rowSum(emptyMatrix, 0);

        assertEquals(0, result, "The sum of integers in any row of an empty matrix should be zero");
    }

    @Test
    void given_SquareMatrixAndColumnIndexInRange_when_columnSumIsCalled_then_totalColumnSumIsReturned() {
        int columnIndexInRange = 2;

        int result = subject.columnSum(squareMatrix, columnIndexInRange);

        assertEquals(7, result, "Wrong sum of integers in the third column");
    }

    @Test
    void given_SquareMatrixAndOutOfRangeColumnIndex_when_columnSumIsCalled_then_ExceptionIsThrown() {
        int columnIndexOutOfRange = -1;

        assertThrows(IllegalArgumentException.class, () -> subject.columnSum(squareMatrix, columnIndexOutOfRange));
    }

    @Test
    void given_EmptySquareMatrix_when_columnSumIsCalled_then_ZeroIsReturned() {
        int[][] emptyMatrix = new int[][]{};

        int result = subject.columnSum(emptyMatrix, 0);

        assertEquals(0, result, "The sum of integers in any column of an empty matrix should be zero");
    }

    @Test
    void given_IrregularMatrixAndColumnIndexInRangeOfSomeRows_when_columnSumIsCalled_then_totalColumnSumIsReturned() {
        int columnIndexInRange = 2;
        int result = subject.columnSum(irregularMatrix, columnIndexInRange);

        assertEquals(1, result, "Wrong sum of integers in the third column");
    }

    @Test
    void given_SquareMatrix_when_maxIsCalled_then_maxValueIsReturned() {
        int result = subject.max(squareMatrix);

        assertEquals(11, result, "Could not find the maximum integer in the matrix");
    }

    @Test
    void given_SquareMatrixWithAllNegative_when_maxIsCalled_then_maxValueIsReturned() {
        int result = subject.max(squareMatrixNegative);

        assertEquals(-5, result, "Could not find the maximum integer in the matrix");
    }

    @Test
    void given_SquareMatrix_when_allRowsSumsIsCalled_then_sumOfRowsIsReturned() {
        int[] result = subject.allRowsSums(squareMatrix);

        int EXPECTED_SUM_FIRST_ROW = 2;
        int EXPECTED_SUM_SECOND_ROW = 12;
        int EXPECTED_SUM_THIRD_ROW = 38;
        int EXPECTED_SUM_FOURTH_ROW = -26;

        assertEquals(EXPECTED_SUM_FIRST_ROW, result[0], "The sum of the integers in the first row is incorrect");
        assertEquals(EXPECTED_SUM_SECOND_ROW, result[1], "The sum of the integers in second row is incorrect");
        assertEquals(EXPECTED_SUM_THIRD_ROW, result[2], "The sum of the integers in third row is incorrect");
        assertEquals(EXPECTED_SUM_FOURTH_ROW, result[3], "The sum of the integers in forrth row is incorrect");
    }

    @Test
    void given_IrregularMatrix_when_allRowsSumsIsCalled_then_sumOfRowsIsReturned() {
        int[] result = subject.allRowsSums(irregularMatrix);

        int EXPECTED_SUM_FIRST_ROW = 2;
        int EXPECTED_SUM_SECOND_ROW = -1;
        int EXPECTED_SUM_THIRD_ROW = 38;
        int EXPECTED_SUM_FOURTH_ROW = -18;

        assertEquals(EXPECTED_SUM_FIRST_ROW, result[0], "The sum of the integers in the first row is incorrect");
        assertEquals(EXPECTED_SUM_SECOND_ROW, result[1], "The sum of the integers in second row is incorrect");
        assertEquals(EXPECTED_SUM_THIRD_ROW, result[2], "The sum of the integers in third row is incorrect");
        assertEquals(EXPECTED_SUM_FOURTH_ROW, result[3], "The sum of the integers in fourth row is incorrect");
    }

    @Test
    void given_EmptyMatrix_when_allRowsSumsIsCalled_then_noSumIsReturned() {
        //int[][] emptyMatrix = new int[][]{};

        int[] result = subject.allRowsSums(emptyMatrix);

        assertTrue(result.length == 0, "No sum of any row should be returned from an empty matrix");
    }

    @Test
    void given_RowMagicMatrix_when_isRowMagicIsCalled_then_trueIsReturned() {
        boolean result = subject.isRowMagic(rowMagic);

        assertTrue(result, "Should return true for a row magic matrix");
    }

    @Test
    void given_NonRowMagicMatrix_when_isRowMagicIsCalled_then_falseIsReturned() {
        boolean result = subject.isRowMagic(squareMatrix);

        assertFalse(result, "Should return false for a non row magic matrix");
    }

    @Test
    void given_EmptyMatrix_when_isRowMagicIsCalled_then_falseIsReturned() {
        boolean result = subject.isRowMagic(emptyMatrix);

        assertFalse(result, "An empty matrix is not row magic");
    }
}
