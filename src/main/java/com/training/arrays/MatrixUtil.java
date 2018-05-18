package com.training.arrays;

import static com.google.common.base.Preconditions.checkArgument;

public class MatrixUtil {

    /**
     * For the given matrix, returns the sum of all the integers in the row positioned by the given index.
     *
     * @param integerMatrix the matrix of integers
     * @param rowIndex the index of the row
     * @return the sum of all the integers in the given row
     * @exception ArrayIndexOutOfBoundsException If the rowIndex is out of range
     */
    public static int rowSum(int[][] integerMatrix, int rowIndex) {
        int total = 0;
        if (integerMatrix.length > 0) {
            int[] row = integerMatrix[rowIndex];
            for (int i = 0; i < row.length; i++) {
                total += row[i];
            }
        }
        return total;
    }

    /**
     * For the given matrix, returns the sum of all the integers in the column positioned by the given index.
     *
     * @param integerMatrix the matrix of integers
     * @param columnIndex the index of the column
     * @return the sum of all the integers in the given column
     */
    public static int columnSum(int[][] integerMatrix, int columnIndex) {
        checkArgument(columnIndex >= 0, "Column index should be greater or equals than zero");

        int total = 0;
        if (integerMatrix.length > 0) {
            for (int i = 0; i < integerMatrix.length; i++) {
                for (int j = 0; j < integerMatrix.length; j++) {
                    if (j == columnIndex) {
                        try {
                            total += integerMatrix[i][j];
                        }
                        catch (ArrayIndexOutOfBoundsException e) {
                            // For the current row, the element in the given column does not exist
                        }
                    }
                }
            }
        }
        return total;
    }

    /**
     * For the given matrix, returns the highest integer.
     *
     * @param integerMatrix the matrix of integers
     * @return the highest integer
     */
    public static int max(int[][] integerMatrix) {
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < integerMatrix.length; i++) {
            int[] row = integerMatrix[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] > maxValue) {
                    maxValue = row[j];
                }
            }
        }
        return maxValue;
    }

    /**
     * For the given matrix, return the sum of each row in an array of integers.
     *
     * @param integerMatrix the matrix of integers
     * @return an array with the sum of each row
     */
    public static int[] allRowsSums(int[][] integerMatrix) {
        if (integerMatrix.length == 0) {
            return new int[0];
        }

        int[] totalRowsResult = new int[integerMatrix.length];
        for (int i = 0; i < totalRowsResult.length; i++) {
            totalRowsResult[i] = rowSum(integerMatrix, i);
        }
        return totalRowsResult;
    }

    /**
     * Determine if the given matrix is row magic
     *
     * @param integerMatrix the matrix of integers
     * @return true if the matrix is row magic, false otherwise
     */
    public static boolean isRowMagic(int[][] integerMatrix) {
        if (integerMatrix.length == 0) {
            return false;
        }

        int firstRowSum = rowSum(integerMatrix, 0);
        for (int i = 1; i < integerMatrix.length; i++) {
            int currentRowSum = rowSum(integerMatrix, i);
            if (firstRowSum != currentRowSum) {
                return false;
            }
        }
        return true;
    }


    /**
     * Print this matrix if 5 is given
     * |1|2|3|4|5|
     * |2|3|4|5|1|
     * |3|4|5|1|2|
     * |4|5|1|2|3|
     * |5|1|2|3|4|
     *
     * @param size the matrix of integer
     * @return the matrix with the previous format presented, depending on the size parameter
     */
    public int[][] createAndPrintMatrix(int size) {
        checkArgument(size > 0, "Wrong cannot create a matrix of " + size + " * " + size);
        checkArgument(size < 6, "Wrong cannot create a matrix of " + size + " * " + size);

        int[][] matrixResult = new int[size][size];
        int value;
        for (int i = 0; i < matrixResult.length; i++) {
            value = i + 1;
            for (int j = 0; j <matrixResult[i].length; j++) {
                matrixResult[i][j] = value;
                System.out.print("|" + matrixResult[i][j]);
                value += 1;
                if (value >= 6) {
                    value = 1;
                }
            }
            System.out.println("|");
        }
        System.out.println("..............................................................");
        return matrixResult;

    }
}
