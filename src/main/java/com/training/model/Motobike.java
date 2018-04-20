package com.training.model;

public class Motobike extends Vehicle {

    private int displacement;
    private final int chainSize;


    public Motobike(String serialNumber, int numWheels, int displacement, int chainSize) {
        super(serialNumber, numWheels);
        this.displacement = displacement;
        this.chainSize = chainSize;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public int getChainSize() {
        return chainSize;
    }
}
