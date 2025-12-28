package Lab5;

import java.util.Scanner;

// Superclass representing a generic shape
class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    // Default method to be overridden by subclasses
    public double calculateArea() {
        return 0.0;
    }
}

// Subclass for Circles
class Circle extends Shape {
    protected double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        // Area calculation using pi = 3.14159 as specified
        return 3.14159 * radius * radius;
    }
}

// Subclass for Rectangles
class Rectangle extends Shape {
    protected double width;
    protected double height;

    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        // Standard area calculation: width * height
        return width * height;
    }
}

public class Lab5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Receive user inputs for radius, width, and height
        double r = sc.nextDouble();
        double w = sc.nextDouble();
        double h = sc.nextDouble();

        // 2. Create objects for Circle and Rectangle
        Circle circle = new Circle("Circle", r);
        Rectangle rect = new Rectangle("Rectangle", w, h);

        // 3. Demonstrate Polymorphism using a Shape array
        Shape[] shapes = {circle, rect};

        // 4. Loop through the array to calculate and display results
        for (Shape s : shapes) {
            System.out.println(s.calculateArea());
        }

        sc.close();
    }
}