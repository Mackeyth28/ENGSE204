package Lab2;

import java.util.Scanner;

// --- PROBLEM 1: BankAccount Class ---
class BankAccount {
    // 1. Attributes (fields)
    private String ownerName;
    private double balance;

    // 2. Constructor
    public BankAccount(String ownerName, double initialBalance) {
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    // 3. deposit() Method (No return value)
    public void deposit(double amount) {
        this.balance = this.balance + amount;
    }

    // 4. displaySummary() Method (Prints results)
    public void displaySummary() {
        System.out.println("Owner: " + this.ownerName);
        System.out.println("Balance: " + this.balance);
    }
}

// --- PROBLEM 2: Rectangle Class ---
class Rectangle {
    // Attributes (fields)
    private double width;
    private double height;

    // Constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // getArea() Method
    public double getArea() {
        // Area = width * height
        return width * height; 
    }

    // getPerimeter() Method
    public double getPerimeter() {
        // Perimeter = 2 * (width + height)
        return 2 * (width + height);
    }
}

// --- MAIN EXECUTION CLASS (Must match the file name: Lab6) ---
public class Lab6 {
    public static void main(String[] args) {
        
        // --- BANK ACCOUNT PROBLEM EXECUTION ---
        Scanner scanner = new Scanner(System.in);

        // Input 1: Owner's Name (String)
        String inputOwnerName = scanner.nextLine();
        
        // Input 2: Initial Balance (double)
        double inputInitialBalance = scanner.nextDouble();
        
        // Input 3: Deposit Amount (double)
        double inputDepositAmount = scanner.nextDouble();

        // Consume the rest of the line to prepare for next input if needed
        scanner.nextLine(); 

        // Create the BankAccount object
        BankAccount account = new BankAccount(inputOwnerName, inputInitialBalance);

        // Perform the deposit
        account.deposit(inputDepositAmount);

        // Display the final summary
        account.displaySummary();
        
        // --- END OF BANK ACCOUNT EXECUTION ---

        scanner.close(); 
    }
    
    // Optional: A separate method to test the Rectangle class if needed
    public static void testRectangle() {
         System.out.println("\n--- Testing Rectangle Class ---");
         // Example test case 1:
         Rectangle r1 = new Rectangle(10.0, 5.0);
         System.out.println("Area: " + r1.getArea());      // Expected: 50.0
         System.out.println("Perimeter: " + r1.getPerimeter()); // Expected: 30.0
}
}    

