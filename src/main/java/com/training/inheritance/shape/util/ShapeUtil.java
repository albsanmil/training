package com.training.inheritance.shape.util;

import com.training.inheritance.shape.model.*;

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
            if ((shape instanceof Square && shapeToSearch instanceof Square)
                    || (shape instanceof Rectangle && shapeToSearch instanceof Rectangle)
                    || (shape instanceof Triangle && shapeToSearch instanceof Triangle)
                    || (shape instanceof Circle && shapeToSearch instanceof Circle)
                    || (shape instanceof Pentagon && shapeToSearch instanceof Pentagon)) {
                result.add(shape);
            }
        }
        return result;
    }
}
