package com.training.exercise.collections;

import java.util.ArrayList;
import java.util.List;

// 3. Write a Java program to insert an element into the array list at the first position.
public class C_Exercise3 {

    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        animals.add("Cat");
        animals.add("Dog");
        animals.add("Bull");
        animals.add("Horse");
        animals.add("Dolphin");

        System.out.println(animals);
        System.out.println("________________________________________________");
        animals.add(0,"Antelope");
        System.out.println(animals);
    }
}
