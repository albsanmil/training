package com.training;

import com.training.enums.Month;

public class Learning {

    private Month month = Month.JANUARY;

    static long l = 354L;

    public static void main(String[] args) {
        long l = 127L;

        System.out.println(l);
        Dog dog = new Dog("Toby");

        printMonth(Month.FEBRUARY);

        System.out.println(dog.getName());
    }

    private static void printMonth(Month month) {
        switch (month) {
            case JANUARY:
                System.out.println(Month.JANUARY);
                break;

            case FEBRUARY:
                System.out.println(Month.FEBRUARY);
//                break;

            case DECEMBER:
                System.out.println(Month.DECEMBER);
                break;

            default:
                throw new IllegalStateException("Wrong state");
        }
    }
}

class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
