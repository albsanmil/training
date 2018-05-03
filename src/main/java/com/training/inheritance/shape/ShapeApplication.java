package com.training.inheritance.shape;

import com.training.inheritance.shape.model.*;
import com.training.inheritance.shape.util.ShapeUtil;

import java.util.List;

public class ShapeApplication {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[11];

        Rectangle firstRectangle = new Rectangle(12, 18);
        Square firstSquare = new Square(5);
        Circle firstCircle = new Circle(19);
        Triangle firstTriangle = new Triangle(41);

//        System.out.println(ShapeUtil.calculateSquareArea(firstSquare));
        System.out.println(firstSquare.area());

        Rectangle secondRectangle = new Rectangle(10, 2);
        Square secondSquare = new Square(6);
        Circle secondCircle = new Circle(10);

        Rectangle thirdRectangle = new Rectangle(7, 6);
        Square thirdSquare = new Square(3);

        Rectangle fourthRectangle = new Rectangle(8, 9);

        shapes[0] = firstRectangle;
        shapes[1] = firstSquare;
        shapes[2] = firstCircle;
        shapes[3] = firstTriangle;

        shapes[4] = secondRectangle;
        shapes[5] = secondSquare;
        shapes[6] = secondCircle;

        shapes[7] = thirdRectangle;
        shapes[8] = thirdSquare;

        shapes[9] = fourthRectangle;

        Pentagon firstPentagon = new Pentagon(5);
        shapes[10] = firstPentagon;

        ShapeUtil.printAreas(shapes);
        System.out.println("________________________________________________________\n");
        ShapeUtil.printPerimeter(shapes);

        System.out.println("________________________________________________________\n");
        List<Shape> searchResult = ShapeUtil.searchShapesByType(shapes, firstRectangle);
        for (Shape shape : searchResult) {
            System.out.println(shape.displayArea());
            System.out.println(shape.displayPerimeter());
        }

        System.out.println("________________________________________________________\n");
        searchResult = ShapeUtil.searchShapesByType(shapes, firstTriangle);
        for (Shape shape : searchResult) {
            System.out.println(shape.displayArea());
            System.out.println(shape.displayPerimeter());
        }

    }


}
