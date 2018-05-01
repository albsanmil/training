package com.training.inheritance.address;

public class FrenchAddress extends Address implements Navigable, Searchable {

    public final static String country = "France";

    private final String city = "Paris";


    public FrenchAddress(String street, int number) {
        super(street, number);
    }
    
    public static String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return super.toString() + " " + country;
    }

    @Override
    public void navigate() {
        System.out.println("Navigate to French address");
    }

    @Override
    public Address searchByStreet(Address[] addresses, String street) {
        return null;
    }

    @Override
    public Address searchByNumber(Address[] addresses, int number) {
        return null;
    }
}
