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
        else if (value > matrixSize)
            return ((rowIndex + columnIndex) - (matrixSize - 1));

        return 0;
    }

    public static void main(String[] args) {
        MatrixAccessor accessor = new MatrixAccessor();
        System.out.println(accessor.access(5, 2, 4));
    }
}
