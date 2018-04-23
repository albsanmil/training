package com.training.model;

public class Vehicle {

    private String serialNumber;

    // Size 32 bits
    private int numWheels = 4;


    public Vehicle(String serialNumber, int numWheels) {
        this.serialNumber = serialNumber;
        this.numWheels = numWheels;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public void setNumWheels(int numWheels) {
        this.numWheels = numWheels;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "serialNumber='" + serialNumber + '\'' +
                ", numWheels=" + numWheels +
                '}';
    }
}
