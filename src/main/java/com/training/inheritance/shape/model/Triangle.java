package com.training.inheritance.shape.model;

public final class Triangle extends Shape {

    private final double side;

    public Triangle(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double area() {
        return (Math.sqrt(3.0F) / 4) * Math.pow(side, 2);
    }

    @Override
    public String displayArea() {
        return "Area of triangle of side " + side + " = " + area();
    }
}
