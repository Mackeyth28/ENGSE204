package Lab2;

import java.util.Scanner;

// --- 1. Rectangle Class (Instance Methods) ---
class Rectangle {
    private double width;
    private double height;

    // Constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // getArea() Method: Area = width * height
    public double getArea() {
        return width * height; 
    }

    // getPerimeter() Method: Perimeter = 2 * (width + height)
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

// --- 2. BankAccount Class (Instance Methods) ---
class BankAccount {
    private String ownerName;
    private double balance;

    // Constructor
    public BankAccount(String ownerName, double initialBalance) {
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    // deposit() Method
    public void deposit(double amount) {
        this.balance += amount;
    }
    
    // withdraw() Method (Conditional)
    public void withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    // displayBalance() Method
    public void displayBalance() {
        System.out.println("Balance: " + this.balance);
    }
    
    // displaySummary() Method (For deposit requirement)
    public void displaySummary() {
        System.out.println("Owner: " + this.ownerName);
        System.out.println("Balance: " + this.balance);
    }
}

// --- 3. TempConverter Class (Static Methods - Utility Class) ---
// Note: This class is a utility class and does not need attributes or a constructor.
class TempConverter {
    
    // Method 1: Celsius to Fahrenheit
    // Formula: (Celsius * 9.0 / 5.0) + 32
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    // Method 2: Fahrenheit to Celsius
    // Formula: (Fahrenheit - 32) * 5.0 / 9.0
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }
}

// --- MAIN EXECUTION CLASS (Must match the file name: Lab8) ---
public class Lab8 {
    public static void main(String[] args) {
        
        // --- TEMP CONVERTER PROBLEM EXECUTION (Image 3) ---
        Scanner scanner = new Scanner(System.in);
        
        // Input 1: Mode (C_TO_F or F_TO_C)
        String mode = scanner.nextLine();
        
        // Input 2: Temperature (double)
        double temperature = scanner.nextDouble();
        
        // NOTE: The requirement strictly forbids creating an object (new TempConverter())
        
        double result = 0.0;
        
        if (mode.equals("C_TO_F")) {
            // Call Static Method directly using the Class name
            result = TempConverter.celsiusToFahrenheit(temperature);
        } else if (mode.equals("F_TO_C")) {
            // Call Static Method directly using the Class name
            result = TempConverter.fahrenheitToCelsius(temperature);
        } else {
            // Handle unexpected input
            System.out.println("Invalid conversion mode.");
        }

        // Display the result
        System.out.println(result);
        
        scanner.close(); 
}
}
    

