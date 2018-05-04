package com.training.exercise.arrays;

public class A_Exercise2 {

    public static void main(String[] args) {
        int[] integers = {55, 44, 33, 22, 11};
        System.out.printf("%d", sum(integers));
    }

    private static int sum(int[] integers) {
        int result = 0;
        for(int i = 0; i < integers.length; i++) {
            result += integers[i];
        }
        return result;
    }
}
