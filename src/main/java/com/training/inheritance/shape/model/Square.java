package com.training.inheritance.shape.model;

public final class Square extends Shape {

    private final double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public String displayArea() {
        return "Area of square of side " + side + " = " + area();
    }
}
