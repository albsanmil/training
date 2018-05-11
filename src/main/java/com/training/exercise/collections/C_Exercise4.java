package com.training.exercise.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 4. Write a Java program to retrieve an element (at a specified index) from a given array list.
public class C_Exercise4 {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();

        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        System.out.println(integers);

        Scanner enterIndex = new Scanner(System.in);
        System.out.print("Enter the position of the item you want to recover: ");
        int index = enterIndex.nextInt();

        System.out.println("________________________________________");

        try {
            System.out.println("The element in position " + index + " is " + integers.get(index));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong index " + index + ", possible value between 0 and 5");
        }

        System.out.println(integers);

    }
}
