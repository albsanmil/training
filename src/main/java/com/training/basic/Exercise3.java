package com.training.basic;

public class Exercise3 {

    public static void main(String[] args) {
        System.out.println(division(50, 3));
        System.out.println(division(50, 0));
    }

    private static float division(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            return Float.POSITIVE_INFINITY;
        }

        return firstNumber / secondNumber;
    }
}
