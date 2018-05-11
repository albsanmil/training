package com.training.exercise.collections.linkedlist;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

//  4. Write a Java program to iterate a linked list in reverse order.
public class LL_Exercise4 {

    public static void main(String[] args) {
        Deque<String> carBrands = new LinkedList<>();

        carBrands.add("Mazda");
        carBrands.add("Aston Martin");
        carBrands.add("Audi");
        carBrands.add("BMW");
        carBrands.add("Citroen");
        carBrands.add("Ford");
        carBrands.add("Porche");
        carBrands.add("Lexus");
        carBrands.add("Honda");
        carBrands.add("Ferrari");
        carBrands.add("Hyundai");
        carBrands.add("Infiniti");
        carBrands.add("Mazda");
        carBrands.add("Jaguar");
        carBrands.add("Kia");
        carBrands.add("Lotus");
        carBrands.add("Nissan");
        carBrands.add("Mercedes-Benz");
        carBrands.add("Lamborghini");
        carBrands.add("Renault");
        carBrands.add("Volkswagen");
        carBrands.add("Tesla Motors");
        carBrands.add("Volvo");

        System.out.println(carBrands);

//        for (int i = carBrands.size() - 1; i >= 0; i--) {
//            System.out.println(carBrands.get(i));
//        }

        for (Iterator<String> iterator = carBrands.descendingIterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }

    }
}
