package com.training.basic;

public class B_Exercise10 {

    public static void main(String[] args) {

        int[] array = new int[12];
        for(int j = 0; j < array.length; j++) {
            array[j] = (int) (Math.random()*99999) + 1;
            System.out.print(array[j] + ", ");
        }


        //int[] array = {25, 15, 2, 88, 41, 198, 77, 35, 11, 5, 19, 62};
        System.out.println("");
        System.out.println("_______________________________________________________________");
//        System.out.println("The maximum number of the array is: " + findNumberMaxInArray(array));
//        System.out.println("The minimum number of the array is: " + findNumberMinInArray(array));

        ExtractedData extractedData = extractDataFromArray(array);
        if (extractedData != null) {
            System.out.println("The maximum number of the array is: " + extractedData.getMaximum());
            System.out.println("The minimum number of the array is: " + extractedData.getMinimum());
        }

    }

//    private static int findNumberMaxInArray(int[] array) {
//        int numberMax = 0;
//        for(int i = 0; i < array.length; i++) {
//            if(array[i] > numberMax) {
//                numberMax = array[i];
//            }
//        }
//        return numberMax;
//    }
//
//    private static int findNumberMinInArray(int[] array) {
//        int numberMin = 9999;
//        for(int i = 0; i < array.length; i++) {
//            if(array[i] < numberMin) {
//                numberMin = array[i];
//            }
//        }
//        return numberMin;
//    }

    private static ExtractedData extractDataFromArray(int[] integers) {
        int maximum = 0;
        int minimum = 9999999;

        for (int i = 0; i < integers.length; i++) {
            int currentValue = integers[i];
            if (currentValue > maximum) {
                maximum = currentValue;
            }
            else if (currentValue < minimum) {
                minimum = currentValue;
            }
        }

        if (maximum != 0 && minimum != 9999999) {
            return new ExtractedData(minimum, maximum);
        }

        return null;
    }
}

class ExtractedData {

    private int minimum;
    private int maximum;

    public ExtractedData(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public int getMinimum() {
        return minimum;
    }

    public int getMaximum() {
        return maximum;
    }
}
