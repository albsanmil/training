package com.training.exercise.collections;

import java.util.ArrayList;
import java.util.List;

// 6. Write a Java program to remove the third element from a array list.
public class C_Exercise6 {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        stringList.add(0, "Gregorio");
        stringList.add(1, "Mary Paz");
        stringList.add(2, "Alvaro");
        stringList.add(3, "Maite");
        stringList.add(4, "Alberto");

        System.out.println(stringList);
        System.out.println("________________________________________");
        stringList.remove(2);
        System.out.println(stringList);
    }
}
