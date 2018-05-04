package com.training.inheritance.shape.model;

import com.google.common.base.Joiner;

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

    @Override
    public double perimeter() {
        return side + side + side;
    }

    @Override
    public String displayPerimeter() {
        return "Perimeter of triangle of side " + side + " = " + perimeter();
    }

    @Override
    public double height() {
        return ((Math.sqrt(3.0F) * side) / 2);
    }

    @Override
    public String toString() {
        return Joiner.on(" ").join("Triangle { side =", side, "| height =", height(), "| area =", area(), '}');
    }
}
