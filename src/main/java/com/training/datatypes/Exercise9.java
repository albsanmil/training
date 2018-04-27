package com.training.datatypes;

import java.util.Scanner;

import static com.training.util.IntegersUtil.*;

public class Exercise9 {

    public static void main(String[] args) {
        Scanner introNumber = new Scanner(System.in);

        System.out.print("Enter a integer number: ");
        int firstInteger = introNumber.nextInt();

        System.out.print("Enter other integer number: ");
        int secondsInteger = introNumber.nextInt();

        System.out.println("Input first integer: " + firstInteger);
        System.out.println("Input second integer: " + secondsInteger);
        System.out.println("Sum of two integers: " + add(firstInteger, secondsInteger));
        System.out.println("Difference of two integers: " + subtract(firstInteger, secondsInteger));
        System.out.println("Product of two integers: " + multiply(firstInteger, secondsInteger));
        System.out.println("Average of two integers: " + calculateAverage(firstInteger, secondsInteger));
        System.out.println("Distance of two integers: " + calculateDistance(firstInteger, secondsInteger));
        System.out.println("Max integer: " + getMaximum(firstInteger, secondsInteger));
        System.out.println("Min integer: " + getMinimum(firstInteger, secondsInteger));
    }
}
