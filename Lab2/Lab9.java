package Lab2;

import java.util.Scanner;

// --- 1. Address Class (New Requirement) ---
class Address {
    private String street;
    private String city;
    private String zipCode;

    // Constructor
    public Address(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    // getFullAddress() Method: Formats the address for output
    public String getFullAddress() {
        // Returns the address in the format: [street], [city], [zipCode]
        return this.street + ", " + this.city + ", " + this.zipCode;
    }
}

// --- 2. Student Class (New Requirement - Uses Composition with Address) ---
class Student {
    private String name;
    private Address address; // Composition: Student has an Address object

    // Constructor
    public Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // displayProfile() Method
    public void displayProfile() {
        System.out.println("Name: " + this.name);
        // Calls the getFullAddress() method of the contained Address object
        System.out.println("Address: " + this.address.getFullAddress()); 
    }
}

// --- 3. Rectangle Class (Previous Requirement) ---
class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height; 
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }
}

// --- 4. BankAccount Class (Previous Requirement) ---
class BankAccount {
    private String ownerName;
    private double balance;

    public BankAccount(String ownerName, double initialBalance) {
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
    
    public void withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void displayBalance() {
        System.out.println("Balance: " + this.balance);
    }
    
    public void displaySummary() {
        System.out.println("Owner: " + this.ownerName);
        System.out.println("Balance: " + this.balance);
    }
}

// --- 5. TempConverter Class (Previous Requirement - Static Methods) ---
class TempConverter {
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }
}


// --- MAIN EXECUTION CLASS (Must match the file name: Lab9) ---
public class Lab9 {
    public static void main(String[] args) {
        
        // --- STUDENT/ADDRESS PROBLEM EXECUTION ---
        Scanner scanner = new Scanner(System.in);
        
        // Input 1: Name (String)
        String inputName = scanner.nextLine();
        
        // Input 2: Street (String)
        String inputStreet = scanner.nextLine();
        
        // Input 3: City (String)
        String inputCity = scanner.nextLine();
        
        // Input 4: ZipCode (String)
        String inputZipCode = scanner.nextLine();
        
        scanner.close(); 
        
        // 1. Create the Address object
        Address studentAddress = new Address(inputStreet, inputCity, inputZipCode);

        // 2. Create the Student object, passing the Address object
        Student studentProfile = new Student(inputName, studentAddress);

        // 3. Display the profile
        studentProfile.displayProfile();
}
}
    

