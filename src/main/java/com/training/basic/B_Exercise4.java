package com.training.basic;

public class B_Exercise4 {

    public static void main(String[] args) {
        System.out.println(calculoA(-5, 8, 6));
        System.out.println(calculoB(55, 9, 9));
        System.out.println(calculoC(20, -3, 5, 8));
        System.out.println(calculoD(5, 15, 3, 2, 8, 3));
    }

    private static int calculoA(int firstNumber, int secondNumber, int thirdNumber) {
        return firstNumber + (secondNumber * thirdNumber);
    }

    private static int calculoB(int firstNumber, int secondNumber, int thirdNumber) {
        return (firstNumber + secondNumber) % thirdNumber;
    }

    private static int calculoC(int firstNumber, int secondNumber, int thirdNumber, int fourthNumber) {
        return firstNumber + (secondNumber * thirdNumber / fourthNumber);
    }

    private static  int calculoD(int firstNumber, int secondNumber, int thirdNumber, int fourthNumber, int fifthNuumber, int sixthNumber) {
        return  (firstNumber + (secondNumber / thirdNumber * fourthNumber)) - (fifthNuumber % sixthNumber);
    }
}
