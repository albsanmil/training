package com.training.romans;

import java.util.Scanner;

public class RomansApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Give me a roman number: ");
        String entryString = scanner.next().toUpperCase();
        try {
            RomanNumber romanNumber = RomanNumber.valueOf(entryString);
            System.out.println(new RomanNumberConverter().convert(romanNumber));
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
