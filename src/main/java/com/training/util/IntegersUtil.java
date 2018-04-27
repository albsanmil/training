package com.training.util;

public class IntegersUtil {

    public static int add(int firstInteger, int secondsInteger) {
        return firstInteger + secondsInteger;
    }

    public static int subtract(int firstInteger, int secondsInteger) {
        return firstInteger - secondsInteger;
    }

    public static int multiply(int firstInteger, int secondsInteger) {
        return firstInteger * secondsInteger;
    }

    public static int calculateAverage(int firstInteger, int secondsInteger) {
        return (firstInteger + secondsInteger) / 2;
    }

    public static int calculateDistance(int firstInteger, int secondsInteger) {
        return firstInteger - secondsInteger;
    }

    public static int getMaximum(int firstInteger, int secondsInteger) {
        if(firstInteger > secondsInteger) {
            return firstInteger;
        }
        return secondsInteger;
    }

    public static int getMinimum(int firstInteger, int secondInteger) {
        if(firstInteger < secondInteger) {
            return firstInteger;
        }
        return secondInteger;
    }
}
