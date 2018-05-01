package com.training.inheritance.address;

public interface Searchable {

    Address searchByStreet(Address[] addresses, String street);
    Address searchByNumber(Address[] addresses, int number);
}
