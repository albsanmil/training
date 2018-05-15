package com.training.romans;

public class RomansApplication {

    public static void main(String[] args) {
        RomanConverter romanConverter = new RomanConverter();

        int number = romanConverter.toNumber("iic");

        System.out.println(number);


    }
}
