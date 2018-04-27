package com.training;

public class Learning {

    public static void main(String[] args) {
        Dog dog = new Dog("Toby");

        System.out.println(dog.getName());
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
