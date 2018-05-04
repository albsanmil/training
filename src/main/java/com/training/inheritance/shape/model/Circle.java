package com.training.inheritance.shape.model;

import com.google.common.base.Joiner;

public final class Circle extends Shape {

    private static final double PI = 3.14159;

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getCircle() {
        return radius;
    }

    @Override
    public double area() {
        return PI * Math.pow(radius, 2);
    }

    @Override
    public String displayArea() {
        return "Area of circle of radius " + radius + " = " + area();
    }

    @Override
    public double perimeter() {
        return 2 * PI * radius;
    }

    @Override
    public String displayPerimeter() {
        return "Perimeter of circle of radius " + radius + " = " + perimeter();
    }

    @Override
    public double height() {
        return 2 * radius;
    }

    @Override
    public String toString() {
        return Joiner.on(" ").join("Circle { radius =", radius, "| height =", height(), "| area =", area(), '}');
    }
}
