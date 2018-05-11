package com.training.exercise.collections.linkedlist;

import java.util.Deque;
import java.util.LinkedList;


//  1. Write a Java program to append the specified element to the end of a linked list.
public class LL_Exercise1 {

    public static void main(String[] args) {
        Deque<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Black");
        System.out.println(colors);
        colors.add("Brown");
        System.out.println(colors);
        colors.addFirst("Yellow");
        System.out.println(colors);
    }
}
