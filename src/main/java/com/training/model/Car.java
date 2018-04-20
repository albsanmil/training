package com.training.model;

public class Car extends Vehicle {

    private static int numberOfCars = 0;

    // Size 8 bits
    private byte numSeats = 5;
    // Size 16 bits
    private short numCarpets = 4;
    // Size 64 bits
    private long numScrews = 1432897423L;

    // Use '' for characters
    private char model = 'U';

    /* Use "" for Strings */
    private String colour = "red";

    // Size 32 bits
    private float price = 1000.50f;
    // Size 64 bits
    private double temperatureEngine = 90.45;


    public Car(String serialNumber, int numWheels, String colour) {
        super(serialNumber, numWheels);
        this.colour = colour;
        ++numberOfCars;
    }

    public byte getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(byte numSeats) {
        this.numSeats = numSeats;
    }

    public short getNumCarpets() {
        return numCarpets;
    }

    public void setNumCarpets(short numCarpets) {
        this.numCarpets = numCarpets;
    }

    public long getNumScrews() {
        return numScrews;
    }

    public void setNumScrews(long numScrews) {
        this.numScrews = numScrews;
    }

    public char getModel() {
        return model;
    }

    public void setModel(char model) {
        this.model = model;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public double getTemperatureEngine() {
        return temperatureEngine;
    }

    public void setTemperatureEngine(double temperatureEngine) {
        this.temperatureEngine = temperatureEngine;
    }

    public static int getNumberOfCars() {
        return numberOfCars;
    }
}
