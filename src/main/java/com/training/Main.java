package com.training;

import com.training.model.Car;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!!!");

        System.out.println("Number of cars " + Car.getNumberOfCars());

        Car ferrari = new Car(4, "blue");
//        ferrari.setColour("blue");
        System.out.println("Ferrari - wheels: " + ferrari.getNumWheels() + ", colour: " + ferrari.getColour());

        System.out.println("Number of cars " + Car.getNumberOfCars());

        Car fiat = new Car(4, "yellow");
        System.out.println("Fiat - wheels: " + fiat.getNumWheels() + ", colour: " + fiat.getColour());

        System.out.println("Number of cars " + Car.getNumberOfCars());


    }
}
