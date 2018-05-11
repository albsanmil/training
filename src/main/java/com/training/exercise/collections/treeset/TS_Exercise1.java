package com.training.exercise.collections.treeset;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

// 1. Write a Java program to create a new tree set, add some colors (string) and print out the tree set.
public class TS_Exercise1 {

    public static void main(String[] args) {
        Set<String> colors = new TreeSet<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("White");
        colors.add("Blue");
        System.out.println(colors);

        SortedSet<Integer> integers = new TreeSet<>();
        integers.add(5);
        integers.add(9);
        integers.add(-5);
        integers.add(3);
        integers.add(7);
        System.out.println(integers);
    }
}
