package com.InterviewCompleteJavaSpring.designPattern.FactoryDesignPattern;

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

// Factory for creating shapes
class ShapeFactory {
    Shape createShape(String shapeType) {
        if ("Rectangle".equalsIgnoreCase(shapeType)) {
            return new Rectangle();
        } else if ("Circle".equalsIgnoreCase(shapeType)) {
            return new Circle();
        } else {
            throw new IllegalArgumentException("Invalid shape type: " + shapeType);
        }
    }
}

// Example usage
public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // Creating shapes using Factory
        Shape rectangle = shapeFactory.createShape("Rectangle");
        Shape circle = shapeFactory.createShape("Circle");

        // Drawing shapes
        rectangle.draw();
        circle.draw();
    }
}
