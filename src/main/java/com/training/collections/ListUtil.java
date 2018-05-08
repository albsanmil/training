package com.training.collections;

import java.util.List;

public class ListUtil {

    public static int maximum(List<Integer> integers) {
        Integer maximum = Integer.MIN_VALUE;
        for (Integer integer : integers) {
            if (integer > maximum) {
                maximum = integer;
            }
        }
        return maximum;
    }
}
