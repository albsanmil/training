package com.training.basic;

public class Exercise10 {

    public static void main(String[] args) {

        /*int[] array = new int[999];
        for(int j = 0; j < array.length; j++) {
            array[j] = (int) (Math.random()*999) + 1;
            System.out.print(array[j + ", ");
        }*/


        int[] array = {25, 15, 2, 88, 41, 198, 77, 35, 11, 5, 19, 62};

        System.out.println("_______________________________________________________________");
        System.out.println("The maximum number of the array is: " + findNumberMaxInArray(array));
        System.out.println("The minimum number of the array is: " + findNumberMinInArray(array));
    }

    private static int findNumberMaxInArray(int[] array) {
        int numberMax = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] > numberMax) {
                numberMax = array[i];
            }
        }
        return numberMax;
    }

    private static int findNumberMinInArray(int[] array) {
        int numberMin = 9999;
        for(int i = 0; i < array.length; i++) {
            if(array[i] < numberMin) {
                numberMin = array[i];
            }
        }
        return numberMin;

    }
}
