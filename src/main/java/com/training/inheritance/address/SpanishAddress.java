package com.training.inheritance.address;

public class SpanishAddress extends Address {

    public static String country = "Spain";


    public SpanishAddress(String street, int number) {
        super(street, number);
    }

    public static String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return super.toString() + " " + country;
    }
}
