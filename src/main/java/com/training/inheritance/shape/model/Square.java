package com.training.inheritance.shape.model;

import com.google.common.base.Joiner;

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

    @Override
    public double perimeter() {
        return 4 * side;
    }

    @Override
    public String displayPerimeter() {
        return "Perimeter of square of side " + side + " = " + perimeter();
    }

    @Override
    public double height() {
        return side;
    }

    @Override
    public String toString() {
        return Joiner.on(" ").join("Square { side =", side, "| height =", height(), "| area =", area(), '}');
    }
}