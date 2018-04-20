package com.training;

import com.training.model.Car;
import com.training.model.Motobike;
import com.training.model.Vehicle;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!!!");

        System.out.println("Number of cars " + Car.getNumberOfCars());

        Car ferrari = new Car("SN1", 4, "blue");
//        ferrari.setColour("blue");
        System.out.println("Ferrari - wheels: " + ferrari.getNumWheels() + ", colour: " + ferrari.getColour());

        System.out.println("Number of cars " + Car.getNumberOfCars());

        Car fiat = new Car("SN2", 4, "yellow");
        System.out.println("Fiat - wheels: " + fiat.getNumWheels() + ", colour: " + fiat.getColour());

        System.out.println("Number of cars " + Car.getNumberOfCars());

        Motobike suzuki = new Motobike("SN3", 2, 125, 500);
        System.out.println("Suzuki - wheels: "
                + suzuki.getNumWheels()
                + ", displacement: "
                + suzuki.getDisplacement()
                + ", chain size: "
                + suzuki.getChainSize());
    }
}
