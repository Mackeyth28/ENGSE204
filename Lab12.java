import java.util.Scanner;

public class Lab12 {

    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Basic Inventory Management System ---");

        // 1. Get the count N (number of product types)
        System.out.print("Enter the number of product types (N): ");
        
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input for N. Please enter an integer.");
            scanner.close();
            return;
        }
        
        int N = scanner.nextInt();
        
        if (N <= 0) {
            System.out.println("N must be a positive integer.");
            scanner.close();
            return;
        }
        
        // Create two arrays of size N: one for Product IDs and one for Stock Quantities
        int[] productIDs = new int[N];
        int[] stockQuantities = new int[N];
        
        System.out.println("Enter Product ID and Stock Quantity for " + N + " products:");

        // 2. Loop N times to fill the arrays
        for (int i = 0; i < N; i++) {
            System.out.println("-- Product " + (i + 1) + " --");
            
            // Get Product ID
            System.out.print("  Enter ID: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. ID must be an integer. Stopping.");
                scanner.close();
                return;
            }
            productIDs[i] = scanner.nextInt();
            
            // Get Stock Quantity
            System.out.print("  Enter Stock: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Stock must be an integer. Stopping.");
                scanner.close();
                return;
            }
            stockQuantities[i] = scanner.nextInt();
        }

        // 3. Get the Search ID
        System.out.println("-------------------------------------------");
        System.out.print("Enter the Product ID to search for: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input for Search ID. Stopping.");
            scanner.close();
            return;
        }
        int searchID = scanner.nextInt();
        
        // 4. Search for the ID and determine the output
        
        int foundStock = -1; // Use -1 as a flag to indicate 'not found'
        
        // Loop through the productIDs array to find a match
        for (int i = 0; i < N; i++) {
            if (productIDs[i] == searchID) {
                // Match found! Get the corresponding stock quantity from the second array
                foundStock = stockQuantities[i];
                break; // Stop searching once the product is found
            }
        }

        // 5. Display the result
        System.out.println("---------------- OUTPUT -------------------");
        if (foundStock != -1) {
            // Case 1: ID was found
            System.out.println(foundStock);
        } else {
            // Case 2: ID was NOT found
            System.out.println("Product " + searchID + " not found");
        }
        System.out.println("-------------------------------------------");

        // Close the Scanner
        scanner.close();
}
}