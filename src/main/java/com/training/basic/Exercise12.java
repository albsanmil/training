package com.training.basic;

import java.util.Scanner;

public class Exercise12 {

    public static void main(String[] args) {

        Scanner introNumber = new Scanner(System.in);

        int firstNumber, secondNumber, thirdNumber;

        System.out.print("Enter the first number: ");
        firstNumber = introNumber.nextInt();
        System.out.print("Enter the second number: ");
        secondNumber = introNumber.nextInt();
        System.out.print("Enter the third number: ");
        thirdNumber = introNumber.nextInt();
        System.out.println("____________________________________________");
        System.out.println("The average of the three numbers is: " + average(firstNumber, secondNumber, thirdNumber));

    }

    private static int average(int firstNumber, int secondNumber, int thirdNumber) {

        return (firstNumber + secondNumber + thirdNumber) / 3;
    }
}
