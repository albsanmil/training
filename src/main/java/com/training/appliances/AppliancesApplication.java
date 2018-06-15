package com.training.appliances;

public class AppliancesApplication {

    public static void main(String[] args) {
        Appliances fridge001 = new Appliances("Fridge", "Zanussi", "ZA001", 480, "Steel");
        Appliances dishwasher001 = new Appliances("Dishwasher", "Fagor", "A001", 280, "White");
        Appliances washingMachine001 = new Appliances("Washing machine", "B", "B001", 380, "Steel");
        Appliances fridge002 = new Appliances("Frige", "Fagor", "FA001", 580, "Steel");

        System.out.println(fridge001.getBrand());
        System.out.println(dishwasher001.getBrand());
        System.out.println(washingMachine001.getBrand());

        System.out.println(Appliances.getTotal());

        System.out.println(fridge001.getPrice() - (fridge001.getPrice() * Appliances.discount(fridge001.getKind())));
        System.out.println(fridge002.getPrice() - (fridge002.getPrice() * Appliances.discount(fridge002.getKind())));
    }
}
