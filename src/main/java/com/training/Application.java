package com.training;

import com.training.model.Car;
import com.training.model.Motobike;
import com.training.model.Vehicle;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        Vehicle vehicle = new Car("SN2", 4, "yellow");
        Vehicle vehicle1 = new Motobike("SN3", 2, 125, 500);

        System.out.println("Hello world!!!");

        System.out.println("Number of cars " + Car.getNumberOfCars());

        Car ferrari = new Car("SN1", 4, "blue");
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

        int[] integers = new int[10];
        integers[0] = 5;
        integers[3] = 9;
        char[] chars = {'a', 'b', 'c'};
        Vehicle[] cars = new Car[2];
        cars[0] = ferrari;
        cars[1] = fiat;

        for (Vehicle v : cars) {
            System.out.println(v.getNumWheels());
        }

        System.out.println(Arrays.toString(integers));
        System.out.println(Arrays.toString(chars));
        System.out.println(integers[3]);

        System.out.println(Arrays.toString(cars));
    }
}
