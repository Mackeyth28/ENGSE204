package Lab3;

 import java.util.Scanner;

public class Lab8 {

    /**
     * Class simulating an Inventory Item with stock management operations (ADD/SELL).
     */
    static class InventoryItem {
        // 1. Private Attributes
        private String productName;
        private int stock;

        // 2. Constructor: Must have 4 public parameters as requested.
        // The additional two parameters are placeholders (publicVal1, publicVal2).
        public InventoryItem(String productName, int initialStock, int publicVal1, int publicVal2) {
            this.productName = productName;
            
            // Validation: initialStock must be >= 0.
            if (initialStock < 0) {
                this.stock = 0;
            } else {
                this.stock = initialStock;
            }
        }

        /**
         * Public Method: Returns the product name.
         * @return The product name.
         */
        public String getProductName() {
            return this.productName;
        }

        /**
         * Public Method: Returns the current stock level.
         * @return The current stock level.
         */
        public int getStock() {
            return this.stock;
        }

        /**
         * Public Method: Adds stock to the inventory.
         * @param amount The quantity to add.
         */
        public void addStock(int amount) {
            if (amount > 0) {
                this.stock += amount;
                System.out.println("Stock added.");
            } else {
                System.out.println("Invalid amount.");
            }
        }

        /**
         * Public Method: Sells (removes) stock from the inventory.
         * @param amount The quantity to sell.
         */
        public void sellStock(int amount) {
            if (amount <= 0) {
                // Case 1: amount is zero or negative
                System.out.println("Invalid amount.");
            } else if (amount > this.stock) {
                // Case 2: amount is positive but exceeds current stock
                System.out.println("Not enough stock.");
            } else {
                // Case 3: successful sale
                this.stock -= amount;
                System.out.println("Sale successful.");
            }
        }
    }

    /**
     * Main method to handle runtime input and execute N inventory operations.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Inventory Management Test ---");

        // Step 1: Read the three required initial input values
        System.out.print("Input (Line 1 - Product Name): ");
        String productName = scanner.nextLine();
        
        System.out.print("Input (Line 2 - Initial Stock): ");
        int initialStock = scanner.nextInt();
        
        System.out.print("Input (Line 3 - Number of operations N): ");
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline after reading N

        // Create the InventoryItem object
        // The third and fourth parameters in the constructor are set to 0 as placeholders.
        InventoryItem item = new InventoryItem(productName, initialStock, 0, 0); 

        System.out.println("\n--- Program Output ---");

        // Step 2: Loop N times to read operations and amounts
        for (int i = 0; i < N; i++) {
            System.out.print("Input (Operation " + (i + 1) + "/" + N + " - ADD/SELL): ");
            String operation = scanner.nextLine().trim().toUpperCase();
            
            System.out.print("Input (Amount " + (i + 1) + "/" + N + "): ");
            int amount = scanner.nextInt();
            scanner.nextLine(); // Consume the newline after reading amount

            if (operation.equals("ADD")) {
                item.addStock(amount);
            } else if (operation.equals("SELL")) {
                item.sellStock(amount);
            } else {
                System.out.println("Error: Unknown operation command.");
            }
        }
        
        // Step 3: Final state check: getStock()
        System.out.println("Final Stock: " + item.getStock());

        scanner.close(); // Close the Scanner object
    
}
}