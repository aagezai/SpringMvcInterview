package com.InterviewCompleteJavaSpring.designPattern.AbstractFactoryDesignPattern;

// Shape abstract class
abstract class Shape {
    abstract void draw();
}

// Concrete implementations of Shape
class Rectangle extends Shape {
    void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class Circle extends Shape {
    void draw() {
        System.out.println("Drawing Circle");
    }
}

// Abstract factory for creating shapes
abstract class ShapeFactory {
    abstract Shape createShape();
}

// Concrete factories implementing ShapeFactory
class RectangleFactory extends ShapeFactory {
    Shape createShape() {
        return new Rectangle();
    }
}

class CircleFactory extends ShapeFactory {
    Shape createShape() {
        return new Circle();
    }
}

// Example usage
public class AbstractFactoryPatternExample {
    public static void main(String[] args) {
        ShapeFactory rectangleFactory = new RectangleFactory();
        ShapeFactory circleFactory = new CircleFactory();

        // Creating shapes using Abstract Factory
        Shape rectangle = rectangleFactory.createShape();
        Shape circle = circleFactory.createShape();

        // Drawing shapes
        rectangle.draw();
        circle.draw();
    }
}
