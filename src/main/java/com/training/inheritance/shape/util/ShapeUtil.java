package com.training.inheritance.shape.util;

import com.training.inheritance.shape.model.Shape;

public class ShapeUtil {

//    public static float calculateRectangleArea(Rectangle rectangle) {
//        return rectangle.getHeight() * rectangle.getWidth();
//    }
//
//    public static float calculateSquareArea(Square square) {
//        return square.getSide() * square.getSide();
//    }

    public static void printAreas(Shape[] shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape.displayArea());
        }
    }

    public static void printPerimeter(Shape[] shapes) {
        for (Shape shape : shapes) {
            System.out.println(shape.displayPerimeter());
        }
    }

//    public static Shape[] searchShapesByType(Shape[] shapes) {
//
//    }
}
