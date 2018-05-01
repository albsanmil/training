package com.training.inheritance.address;

public class SpanishAddressUsage {

    public static void main(String[] args) {
        String country = SpanishAddress.getCountry();

        System.out.println(SpanishAddress.getCountry());

        Address vanesaAddress = new SpanishAddress("Calle Colon", 1);
        vanesaAddress.setNumber(3);
        System.out.println(vanesaAddress.getNumber());
        System.out.println(vanesaAddress.toString());

        Address albertoAddress = new SpanishAddress("Calle Mieres", 7);
        albertoAddress.setNumber(5);
        System.out.println(albertoAddress.getNumber());
        System.out.println(albertoAddress.toString());

        Address alvaroAddress = new FrenchAddress("Bolo rua", 4);
        System.out.println(alvaroAddress.toString());

        AddressValidator addressValidator = new AddressValidator();
        if (addressValidator.validate(albertoAddress)) {
            System.out.println("True");
        }
    }
}
