package com.training.arrays;

import java.util.Scanner;

import static com.training.arrays.MatrixUtil.createMatrix;
import static com.training.arrays.MatrixUtil.printMatrix;

public class MatrixApplication {

    public static void main(String[] args) {
        int size;
        Scanner introSize = new Scanner(System.in);
        System.out.print("Enter a size for the matrix: ");
        size = introSize.nextInt();
        printMatrix(createMatrix(size));
    }
}
