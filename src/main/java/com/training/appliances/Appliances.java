package com.training.appliances;

public class Appliances {

    private static int total;

    private String kind;
    private String brand;
    private String model;
    private float price;
    private String color;

    public Appliances(String kind, String brand, String model, float price, String color) {
        this.kind = kind;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        ++total;
    }

    public void printKind() {
        System.out.println(kind);
    }

    public static float discount(String kind) {
        if (kind.equals("Fridge"))
            return 10.0F / 100;
        else if (kind.equals("Dishwasher"))
            return 12.5F / 100;
        else if (kind.equals("Washing machine"))
            return 15.0F / 100;
        else
            return 0.0F;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static int getTotal() {
        return total;
    }
}
