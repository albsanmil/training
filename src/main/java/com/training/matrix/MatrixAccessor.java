package com.training.matrix;

public class MatrixAccessor {

    /**
     * Access the integer in position given by the row and column indexes.
     *
     * |1|2|3|4|5|
     * |2|3|4|5|1|
     * |3|4|5|1|2|
     * |4|5|1|2|3|
     * |5|1|2|3|4|
     */
    public long access(long matrixSize, long rowIndex, long columnIndex) {
        long value = rowIndex + columnIndex + 1;
        if (value <= matrixSize)
            return value;
        else
            return rowIndex + columnIndex - (matrixSize - 1);
    }

    public static void main(String[] args) {
        MatrixAccessor accessor = new MatrixAccessor();

        for (long i = 4999990; i < 500001; i++) {
            System.out.println(accessor.access(10000000, 5000000, i));
        }

    }
}
