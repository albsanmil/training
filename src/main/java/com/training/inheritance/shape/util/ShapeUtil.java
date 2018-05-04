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

    // Calculates the total area of all the given shapes which height is
    // less or equal than the given height
    public static double calculateTotalArea(List<Shape> shapes) {
        double sumTotal = 0;
        for (Shape shape : shapes) {
            sumTotal += shape.area();
        }
        return sumTotal;
    }

    public static List<Shape> filterShapesByMaximumHeight(Shape[] shapes, double maximumHeight) {
        List<Shape> filteredShapes = new ArrayList<>();
        for (Shape shape : shapes) {
            if (shape.height() <= maximumHeight) {
                filteredShapes.add(shape);
            }
        }
        return filteredShapes;
    }
}
