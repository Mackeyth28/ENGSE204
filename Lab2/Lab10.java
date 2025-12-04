package Lab2;
import java.util.Scanner;
import java.text.DecimalFormat; 

// --- 1. Product Class (ShoppingCart Requirement) ---
class Product {
    private String name;
    private double price;

    // Constructor
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        // The IDE warning about 'name' not being used is harmless, 
        // as only 'price' is needed for the total calculation.
    }
    
    // Getter for price, needed for ShoppingCart calculation
    public double getPrice() {
        return price;
    }
}

// --- 2. ShoppingCart Class (Newest Requirement) ---
class ShoppingCart {
    private Product[] items;
    private int itemCount;

    // Constructor (Initializes Array to size 10, sets itemCount to 0)
    public ShoppingCart() {
        this.items = new Product[10];
        this.itemCount = 0;
    }

    // addProduct(p) Method
    public void addProduct(Product p) {
        if (this.itemCount < this.items.length) {
            this.items[this.itemCount] = p;
            this.itemCount++;
        }
    }

    // calculateTotalPrice() Method
    public double calculateTotalPrice() {
        double total = 0.0;
        // Sums the price of all added items
        for (int i = 0; i < this.itemCount; i++) {
            total += this.items[i].getPrice();
        }
        return total;
    }
}

// --- 3. Rectangle Class (Area/Perimeter Requirement) ---
class Rectangle {
    private double width;
    private double height;
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    public double getArea() { return width * height; }
    public double getPerimeter() { return 2 * (width + height); }
}

// --- 4. BankAccount Class (Deposit/Withdrawal Requirement) ---
class BankAccount {
    private String ownerName;
    private double balance;
    public BankAccount(String ownerName, double initialBalance) {
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }
    public void deposit(double amount) { this.balance += amount; }
    public void withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }
    public void displayBalance() { System.out.println("Balance: " + this.balance); }
    public void displaySummary() {
        System.out.println("Owner: " + this.ownerName);
        System.out.println("Balance: " + this.balance);
    }
}

// --- 5. Address Class (Student Profile Requirement) ---
class Address {
    private String street;
    private String city;
    private String zipCode;
    public Address(String street, String city, String zipCode) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }
    public String getFullAddress() {
        return this.street + ", " + this.city + ", " + this.zipCode;
    }
}

// --- 6. Student Class (Student Profile Requirement) ---
class Student {
    private String name;
    private Address address; 
    public Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }
    public void displayProfile() {
        System.out.println("Name: " + this.name);
        System.out.println("Address: " + this.address.getFullAddress()); 
    }
}

// --- 7. TempConverter Class (Static Methods Requirement) ---
class TempConverter {
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9.0 / 5.0) + 32;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5.0 / 9.0;
    }
}


// --- MAIN EXECUTION CLASS (Lab10) ---
public class Lab10 {
    public static void main(String[] args) {
        
        // --- SHOPPING CART PROBLEM EXECUTION ---
        Scanner scanner = new Scanner(System.in);
        
        // Input 1: N (Number of items to process)
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume newline after reading int

        ShoppingCart cart = new ShoppingCart();
        
        // Loop N times to read product details
        for (int i = 0; i < N; i++) {
            // Input: Product Name (String)
            String name = scanner.nextLine();
            
            // Input: Product Price (double)
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline after reading double

            Product p = new Product(name, price);
            cart.addProduct(p);
        }
        
        double total = cart.calculateTotalPrice();

        // Format the output to two decimal places (e.g., 77.50)
        DecimalFormat df = new DecimalFormat("0.00");
        
        // Display the total price
        System.out.println(df.format(total));
        
        scanner.close(); 
    }
}

    

