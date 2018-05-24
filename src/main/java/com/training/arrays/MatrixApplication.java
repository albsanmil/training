package com.training.arrays;

import java.util.Scanner;

public class MatrixApplication {

    public static void main(String[] args) {

        int size;
        Scanner introSize = new Scanner(System.in);
        System.out.print("Enter a size for the matrix: ");
        size = introSize.nextInt();
        MatrixUtil.printMatrix(MatrixUtil.createMatrix(size));
    }
}
