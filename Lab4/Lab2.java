import java.util.Scanner;

class Product {
    // Attributes
    private String name;
    private double price;

    // 1. Constructor that accepts only 'name'
    // This constructor uses Chaining to call the second constructor with a default price of 0.0
    public Product(String name) {
        this(name, 0.0); 
    }

    // 2. Main Constructor that accepts both 'name' and 'price'
    // This constructor initializes both attributes
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Method to display product information in the required format
    public void displayInfo() {
        System.out.println("Product: " + this.name + ", Price: " + this.price);
    }
}

public class Lab2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Receive "Mode" (int) from the user: 1 or 2
        if (sc.hasNextInt()) {
            int mode = sc.nextInt();
            sc.nextLine(); // Consume the leftover newline character

            if (mode == 1) {
                // Mode 1: Receive only Product Name (String)
                // Calls the 1st constructor which chains to the 2nd
                String name = sc.nextLine();
                Product product = new Product(name);
                product.displayInfo();
            } 
            else if (mode == 2) {
                // Mode 2: Receive Product Name (String) and Price (double)
                // Calls the main constructor directly
                String name = sc.nextLine();
                if (sc.hasNextDouble()) {
                    double price = sc.nextDouble();
                    Product product = new Product(name, price);
                    product.displayInfo();
                }
            }
        }
        sc.close();
    
}
}