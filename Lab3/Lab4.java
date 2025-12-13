package Lab3;
import java.util.Scanner;

public class Lab4 {

    /**
     * Class representing a Product, demonstrating Encapsulation and using a Static attribute
     * to track the total number of products created.
     */
    static class Product {
        // 1. Instance Attribute (Encapsulation: private)
        private String name;

        // 2. Class/Static Attribute (Encapsulation: private)
        // Tracks the total number of Product objects created.
        private static int productCount = 0;

        // 3. Constructor: Must have 2 public parameters as requested.
        // The second parameter is a placeholder (publicVal) to meet the requirement.
        public Product(String name, int publicVal) {
            // Set the instance attribute
            this.name = name;
            
            // Increment the static product counter every time a new object is created
            Product.productCount++;
        }

        /**
         * Public Method: Returns the instance product name.
         * @return The product name.
         */
        public String getName() {
            return this.name;
        }

        /**
         * Public Static Method: Returns the total count of products created.
         * @return The static productCount.
         */
        public static int getProductCount() {
            return Product.productCount;
        }
    }

    /**
     * Main method to handle runtime input, create N products, and display the final count.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Product Counter Program ---");

        // Step 1: Read N (the number of products to create)
        System.out.print("Input (Line 1 - Number of products N): ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input. Must be an integer for N. Exiting.");
            scanner.close();
            return;
        }
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left after reading the integer N

        // Step 2: Loop N times to read product names and create Product objects
        for (int i = 0; i < N; i++) {
            System.out.print("Input (Product Name " + (i + 1) + "/" + N + "): ");
            String productName = scanner.nextLine();
            
            // Create a new Product object. This automatically increments the static counter.
            // Using a placeholder (0) for the second public constructor parameter.
            new Product(productName, 0);
        }

        // Step 3: Display the final result (Output)
        System.out.println("\n--- Program Output ---");
        // Access the static count directly via the class name
        System.out.println(Product.getProductCount());

        scanner.close(); // Close the Scanner object
    }
}