package com.training.exercise.collections;

import java.util.ArrayList;
import java.util.List;

// 1. Write a Java program to create a new array list, add some colors (string) and print out the collection.
public class C_Exercise1 {

    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("blue");
        colors.add("green");
        colors.add("yellow");

        System.out.println(colors);
        System.out.println(colors.size());
        System.out.println(colors.get(1));
        System.out.println(colors.remove(3));
        System.out.println(colors.isEmpty());
        System.out.println(colors);

    }
}
