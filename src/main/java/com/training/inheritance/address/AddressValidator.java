package com.training.inheritance.address;

public class AddressValidator {

    public boolean validate(Address address) {
        return doValidation(address.getStreet());
    }

    private boolean doValidation(String street) {
        if ("Calle Mieres".equals(street)) {
            return true;
        }

        return false;
    }
}
