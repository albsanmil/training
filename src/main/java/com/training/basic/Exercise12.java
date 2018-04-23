package com.training.basic;

import java.util.Scanner;

public class Exercise12 {

    public static void main(String[] args) {

        Scanner introNumber = new Scanner(System.in);

        int firstNumber = 5;
        int secondNumber = 5;
        int thirdNumber = 5;

//        System.out.print("Enter the first number: ");
//        firstNumber = introNumber.nextInt();
//        System.out.print("Enter the second number: ");
//        secondNumber = introNumber.nextInt();
//        System.out.print("Enter the third number: ");
//        thirdNumber = introNumber.nextInt();
        System.out.println("____________________________________________");
        System.out.println(firstNumber);
        System.out.println("The average of the three numbers is: " + average(firstNumber, secondNumber, thirdNumber));
        System.out.println(firstNumber);



    }

    private static int average(int a, int secondNumber, int thirdNumber) {

        a = 6;

        return (a + secondNumber + thirdNumber) / 3;
    }
}
