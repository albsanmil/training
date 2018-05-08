package com.training.collections;

import java.util.ArrayList;
import java.util.List;

public class CollectionsApplication {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(10);

        numbers.add(1);
        numbers.add(5);
        numbers.add(8);

        System.out.println(ListUtil.maximum(numbers));
    }
}
