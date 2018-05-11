package com.training.exercise.collections;

import java.util.ArrayList;
import java.util.List;

// 6. Write a Java program to remove the third element from a array list.
public class C_Exercise6 {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("Gregorio");
        names.add("Mary Paz");
        names.add("Alvaro");
        names.add("Maite");
        names.add("Alberto");

        System.out.println(names);
        System.out.println("________________________________________");
        names.remove(2);
        System.out.println(names);
    }
}
