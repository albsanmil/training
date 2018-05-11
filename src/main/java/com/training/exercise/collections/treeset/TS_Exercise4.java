package com.training.exercise.collections.treeset;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

// 4. Write a Java program to create a reverse order view of the elements contained in a given tree set.
public class TS_Exercise4 {

    public static void main(String[] args) {
        NavigableSet<String> mammals = new TreeSet<>();

        mammals.add("Bat");
        mammals.add("Rabbit");
        mammals.add("Kangaroo");
        mammals.add("Cat");
        mammals.add("Tiger");
        mammals.add("Horse");
        mammals.add("Elephant");
        mammals.add("Dolphin");
        mammals.add("Cow");

        System.out.println(mammals);

        for (Iterator<String> iterator = mammals.descendingIterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }

    }
}
