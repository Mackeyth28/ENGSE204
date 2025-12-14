package Lab3;

import java.util.Scanner;

public class Lab13 {

    /**
     * Class implementing a static utility for managing software licenses (LicenseManager).
     */
    static class LicenseManager {
        // 1. Private Static Attributes
        private static int maxLicenses = 10;
        private static int usedLicenses = 0;

        // 2. Public Static Methods

        /**
         * Sets the maximum number of licenses, with validation against current usage.
         * @param max The new maximum license count.
         */
        public static void setMax(int max) {
            if (max <= 0) {
                System.out.println("Invalid max value.");
                return;
            }
            
            // Additional Validation based on Test Case 3 logic
            if (max < usedLicenses) {
                System.out.println("Cannot set max lower than current usage.");
                return;
            }

            // If validation passes
            LicenseManager.maxLicenses = max;
            System.out.println("Max licenses set to " + max);
        }

        /**
         * Attempts to check out a license.
         * @return true if successful, false otherwise.
         */
        public static boolean checkOut() {
            if (usedLicenses < maxLicenses) {
                // Available licenses exist
                LicenseManager.usedLicenses++;
                System.out.println("Checkout successful.");
                return true;
            } else {
                // No licenses available
                System.out.println("Checkout failed: No licenses available.");
                return false;
            }
        }

        /**
         * Attempts to check in a license.
         */
        public static void checkIn() {
            if (usedLicenses > 0) {
                // Licenses are currently in use
                LicenseManager.usedLicenses--;
                System.out.println("Check-in successful.");
            } else {
                // No licenses to check in
                System.out.println("Nothing to check-in.");
            }
        }

        /**
         * Displays the current usage and availability status.
         */
        public static void displayStatus() {
            int available = maxLicenses - usedLicenses;
            System.out.println("Used: " + usedLicenses);
            System.out.println("Available: " + available);
        }
    }

    /**
     * Main method to handle runtime input and execute N license management operations.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- License Manager Test ---");

        // Step 1: Read N (the number of operations)
        System.out.print("Input (Line 1 - Number of operations N): ");
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input for N. Exiting.");
            scanner.close();
            return;
        }
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume newline after reading N

        System.out.println("\n--- Program Output ---");

        // Step 2: Loop N times to read and execute operations
        for (int i = 0; i < N; i++) {
            System.out.print("Input (Command " + (i + 1) + "/" + N + " - SET/CHECKOUT/CHECKIN/STATUS): ");
            String command = scanner.nextLine().trim().toUpperCase();

            switch (command) {
                case "SET":
                    // Operation SET: Read max (int) and call setMax()
                    System.out.print("Input (Max Licenses): ");
                    if (scanner.hasNextInt()) {
                        int max = scanner.nextInt();
                        LicenseManager.setMax(max);
                    } else {
                        System.out.println("Error: SET requires an integer value.");
                    }
                    scanner.nextLine(); // Consume newline
                    break;
                case "CHECKOUT":
                    LicenseManager.checkOut(); // Does not require reading additional input
                    break;
                case "CHECKIN":
                    LicenseManager.checkIn(); // Does not require reading additional input
                    break;
                case "STATUS":
                    LicenseManager.displayStatus(); // Does not require reading additional input
                    break;
                default:
                    System.out.println("Error: Unknown command.");
                    break;
            }
        }
        
        scanner.close();
    
}
}