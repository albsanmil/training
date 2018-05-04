package com.training.inheritance.shape.util;

import com.training.inheritance.shape.model.Shape;

import java.util.ArrayList;
import java.util.List;

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

    public static List<Shape> searchShapesByType(Shape[] shapes, Shape shapeToSearch) {
        List<Shape> result = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape.getClass().equals(shapeToSearch.getClass())) {
                result.add(shape);
            }
        }
        return result;
    }

    public static double sumTotalArae(Shape[] shapes, double height) {
        double sumTotal = 0;
        for (Shape shape : shapes) {
            if (shape.height() <= height) {
                System.out.println(shape.getClass() + "    " + " Area: " + shape.area()
                        + "    " + " Altura: " + shape.height());
                sumTotal += shape.area();
            }
        }
        return sumTotal;
    }
}
