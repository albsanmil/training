package com.training.matrix;

public class MatrixAccesor {

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
        if (rowIndex + columnIndex + 1 == matrixSize)
            return matrixSize;

        return 0;
    }

    public static void main(String[] args) {
        MatrixAccesor accesor = new MatrixAccesor();
        System.out.println(accesor.access(5, 1, 3));
    }
}
