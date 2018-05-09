package com.training.exercise.collections.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 5. Write a Java program to update specific array element by given element.
public class AL_Exercise5 {

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();

        integers.add(9);
        integers.add(10);
        integers.add(11);
        integers.add(12);
        integers.add(13);
        integers.add(14);
        System.out.println(integers);

        Scanner enterIndex = new Scanner(System.in);
        System.out.print("Enter the index of the list where you want to update: ");
        int index = enterIndex.nextInt();

        Scanner givenElement = new Scanner(System.in);
        System.out.print("Enter the item you want to replace the previous one: ");
        int element = givenElement.nextInt();

        System.out.println("________________________________________");

        integers.set(index, element);
        System.out.println(integers);
    }
}
