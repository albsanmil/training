package com.training.arrays;

public class TwoDimensionArraysUtil {

    /**
     * For the given two dimension array, returns the sum of all the integers in the row positioned by the given index.
     *
     * @param integers the two dimension array
     * @param rowIndex the index of the row
     * @return the sum of all the integers in the given row
     * @exception ArrayIndexOutOfBoundsException If the rowIndex is out of range
     */
    public static int rowSum(int[][] integers, int rowIndex) {
        int total = 0;
        int[] row = integers[rowIndex];
        for (int i = 0; i < row.length; i++) {
            total += row[i];
        }
        return total;
    }

    /**
     * For the given two dimension array, returns the highest value of the array.
     *
     * @param integers the two dimension array
     * @return the highest value of the array
     * @exception "Could not find the maximum value in the two dimension array"
     */
    public static int max(int[][] integers) {
        int maxValue = 0;
        for (int i = 0; i < integers.length; i++) {
            int[] row = integers[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] > maxValue) {
                    maxValue = row[j];
                }
            }
        }
        return maxValue;
    }

    /**
     * For the given two dimension array, returns the sum of all the integers in the column positioned by the given index.
     *
     * @param integers the two dimension array
     * @param columnIndex the index of the column
     * @return the sum of all the integers in the given column
     * @exception "Wrong sum of integers in the third column"
     */
    public static int columnSum(int[][] integers, int columnIndex) {
        int total = 0;
        for (int i = 0; i < integers.length; i++) {
            for (int j = 0; j < integers.length; j++) {
                if (j == columnIndex) {
                    total += integers[i][j];
                }
            }
        }
        return total;

    }

    /**
     * For the given two dimension array, return the sum of each row in an array of integers.
     *
     * @param integers the two dimension array
     * @return An array with the sum of each row
     * @exception "The array of the sum of the rows is incorrect"
     */

    public static int[] allRowsSums(int[][] integers) {
        int[] totalRowsResutl = new int[3];
        for (int i = 0; i < totalRowsResutl.length; i++) {
            totalRowsResutl[i] = rowSum(integers, i);
        }
        return totalRowsResutl;
    }

    /**
     * For the given two dimension array, return true if it's rows magic array.
     *
     * @param rowMagic the two dimension array
     * @return true if it's rows magic array
     * @exception "Wrong result because it's not a magic rows array"
     */

    public static boolean isArrayRowMagic(int[][] rowMagic) {
        int[] rowTemp = new int[3];

        for (int i = 0; i < rowMagic.length; i++) {
            rowTemp[i] = rowSum(rowMagic, i);
        }
        if (rowTemp[0] == rowTemp[1] && rowTemp[1] == rowTemp[2]) {
            return true;
        }
        else {
            return false;
        }
    }

}
