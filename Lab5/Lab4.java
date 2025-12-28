package Lab5;

import java.util.Scanner;

// Superclass/Parent: Vehicle
class Vehicle {
    protected String color;

    // Constructor to set the color attribute
    public Vehicle(String color) {
        this.color = color;
    }
}

// Subclass/Child: Car inherits from Vehicle
class Car extends Vehicle {
    protected int wheels;

    // Constructor that receives 2 values
    public Car(String color, int wheels) {
        // Use super(color) to call the Parent constructor
        super(color);
        // Set its own attribute
        this.wheels = wheels;
    }

    // Method to display information in specific format
    public void displayDetails() {
        System.out.println("Color: " + color + ", Wheels: " + wheels);
    }
}

public class Lab4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Receive "color" (String) and "wheels" (int) from user
        String inputColor = sc.nextLine();
        int inputWheels = sc.nextInt();

        // 2. Create Car object using the 2-parameter constructor
        Car myCar = new Car(inputColor, inputWheels);

        // 3. Call displayDetails()
        myCar.displayDetails();

        sc.close();
    }
}