package com.training.inheritance.shape.model;

public final class Pentagon extends Shape {

    private final int side;

    public Pentagon(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    public double area() {
        return (((double) 1) / 4) * (Math.sqrt(5 * (5 + 2 * Math.sqrt(5)))) * Math.pow(side, 2);
    }

    @Override
    public String displayArea() {
        return "Area of pentagon of side " + side + " = " + area();
    }

    @Override
    public double perimeter() {
        return 5 * side;
    }

    @Override
    public String displayPerimeter() {
        return "Perimeter of pentagon of side " + side  + " = " + perimeter();
    }
}
