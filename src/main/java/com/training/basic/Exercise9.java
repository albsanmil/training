package com.training.basic;

import java.util.Scanner;

public class Exercise9 {

    public static void main(String[] args) {

        Scanner introNumber = new Scanner(System.in);

        int firstInteger;
        int secondInteger;


        System.out.print("Enter a integer number: ");
        firstInteger = introNumber.nextInt();
        System.out.print("Enter other integer number: ");
        secondInteger = introNumber.nextInt();


        System.out.println(".................................................");
        System.out.println("Input first integer: " + firstInteger);
        System.out.println("Input second integer: " + secondInteger);
        System.out.println("Sum of two integers: " + sum(firstInteger, secondInteger));
        System.out.println("Difference of two integers: " + difference(firstInteger, secondInteger));
        System.out.println("Product of two integers: " + product(firstInteger, secondInteger));
        System.out.println("Average of two integers: " + average(firstInteger, secondInteger));
        System.out.println("Distance of two integers: " + distance(firstInteger, secondInteger));
        System.out.println("Max integer: " + maxInteger(firstInteger, secondInteger));
        System.out.println("Min integer: " + minInteger(firstInteger, secondInteger));
        System.out.println(".................................................");
    }

    private  static int sum(int firstInteger, int secondInteger) {

        return firstInteger + secondInteger;
    }

    private  static int difference(int firstInteger, int secondInteger) {

        return firstInteger - secondInteger;
    }

    private  static int product(int firstInteger, int secondInteger) {

        return firstInteger * secondInteger;
    }

    private  static double average(double firstInteger, double secondInteger) {

        return (firstInteger + secondInteger) / 2;
    }

    private  static int distance(int firstInteger, int secondInteger) {

        return firstInteger - secondInteger;
    }

    private  static int maxInteger(int firstInteger, int secondInteger) {

        if(firstInteger > secondInteger) {
            return firstInteger;
        }
        return secondInteger;
    }

    private  static int minInteger(int firstInteger, int secondInteger) {

        if(firstInteger < secondInteger) {
            return firstInteger;
        }
        return secondInteger;
    }
}
