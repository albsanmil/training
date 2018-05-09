package com.training.exercise.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 5. Write a Java program to update specific array element by given element.
public class C_Exercise5 {

    public static void main(String[] args) {
        List<Integer> integersList = new ArrayList<>();

        integersList.add(0, 9);
        integersList.add(1, 10);
        integersList.add(2, 11);
        integersList.add(3, 12);
        integersList.add(4, 13);
        integersList.add(5, 14);
        System.out.println(integersList);

        Scanner enterIndex = new Scanner(System.in);
        System.out.print("Enter the index of the list where you want to update: ");
        int index = enterIndex.nextInt();

        Scanner givenElement = new Scanner(System.in);
        System.out.print("Enter the item you want to replace the previous one: ");
        int element = givenElement.nextInt();

        System.out.println("________________________________________");

        integersList.add(index, element);
        integersList.remove(index + 1);
        System.out.println(integersList);
    }
}
