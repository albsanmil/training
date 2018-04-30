package com.training.basic;

/**
 * Exercise 11 for ....
 *
 *
 *
 */
public class B_Exercise11 {

    private static final float PI = 3.14159F;

    public static void main(String[] args) {
        float radius = 7.5F;
        if (args.length > 0) {
            try {
                radius = Float.valueOf(args[0]);
            }
            catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Radius: " + radius);
        System.out.println("Perimeter: " + perimeter(radius));
        System.out.println("Area: " + area(radius));
    }

    private static float perimeter(float radius) {
        return 2 * PI * radius;
    }

    private static float area(float radius) {
        return PI * radius * radius;
    }

}
