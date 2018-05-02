package com.training.inheritance.shape.model;

public final class Rectangle extends Shape {

    private final double height;
    private final double width;


    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public double area() {
        return height * width;
    }

    @Override
    public String displayArea() {
        return "Area of rectangle of height " + height + " and width " + width + " = " + area();
    }
}
