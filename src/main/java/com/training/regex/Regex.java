package com.training.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {
        Pattern subtraction = Pattern.compile("I{1,3}");
        Matcher m = subtraction.matcher("I");
        boolean result = m.matches();
        if (result)
            System.out.println("It is a valid roman number");
        else
            System.out.println("It is not a valid roman number");

//        boolean r = Pattern.matches("X*L", "MMCDXLIV");
//
//        if (r)
//            System.out.println("Contains the pattern");
//        else
//            System.out.println("Does not contain the pattern");
    }
}
