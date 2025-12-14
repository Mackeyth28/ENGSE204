package Lab3;

import java.util.Scanner;

public class Lab15 {

    /**
     * Class simulating a User with account locking based on static security policy.
     */
    static class User {
        // 1. Private Instance Attributes
        private String username;
        private int failedAttempts = 0;
        private boolean isLocked = false;

        // 2. Private Static Attribute (Security Policy)
        private static int maxAttempts = 3;

        // 3. Public Static Methods (Policy Management)
        /**
         * Static Setter: Changes the maximum number of login attempts allowed.
         * @param max The new maximum attempts count.
         */
        public static void setPolicy(int max) {
            if (max > 0) {
                User.maxAttempts = max;
                System.out.println("Policy updated.");
            } else {
                System.out.println("Invalid policy.");
            }
        }

        // 4. Public Constructor
        public User(String username) {
            this.username = username;
        }

        // 5. Public Getters (Provided in Pre-code)
        public String getUsername() {
            return this.username;
        }

        public boolean isLocked() {
            return this.isLocked;
        }

        public int getFailedAttempts() {
            return this.failedAttempts;
        }

        // 6. Public Login Method with Logic
        /**
         * Attempts to log in, checking lock status and updating failed attempts.
         * The correct password is hardcoded as "pass123".
         * @param password The password string entered by the user.
         */
        public void login(String password) {
            final String CORRECT_PASSWORD = "pass123";

            // Case 1: Account is locked
            if (this.isLocked) {
                System.out.println("Account is locked.");
                return;
            }

            // Case 2: Successful Login
            if (password.equals(CORRECT_PASSWORD)) {
                this.failedAttempts = 0;
                this.isLocked = false;
                System.out.println("Login successful.");
                return;
            }

            // Case 3: Failed Login
            this.failedAttempts++;

            // Locking Condition
            if (this.failedAttempts >= User.maxAttempts) {
                this.isLocked = true;
                System.out.println("Login failed. Account locked.");
            } else {
                // Failed but Not Locked
                int attemptsLeft = User.maxAttempts - this.failedAttempts;
                System.out.println("Login failed. " + attemptsLeft + " attempts left.");
            }
        }
    }

    /**
     * Main method to handle runtime input and execute N security operations.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- User Security Lockout Test ---");

        // Step 1: Read the three initial input values
        System.out.print("Input (Line 1 - Username): ");
        String username = scanner.nextLine();
        
        // Input for initial password (required by input sequence, but unused for creation)
        System.out.print("Input (Line 2 - Initial Password - Unused for creation): ");
        String initialPassword = scanner.nextLine(); 

        System.out.print("Input (Line 3 - Number of operations N): ");
        if (!scanner.hasNextInt()) {
             System.err.println("Invalid input for N. Exiting.");
             scanner.close();
             return;
        }
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume newline after reading N

        // Create the User object
        User user = new User(username); 

        System.out.println("\n--- Program Output ---");

        // Step 2: Loop N times to read and execute operations
        for (int i = 0; i < N; i++) {
            System.out.print("Input (Command " + (i + 1) + "/" + N + " - SET POLICY/LOGIN): ");
            String command = scanner.nextLine().trim().toUpperCase();

            if (command.equals("SET POLICY")) {
                // Operation SET POLICY: Read max (int)
                System.out.print("Input (Max Attempts): ");
                if (scanner.hasNextInt()) {
                    int max = scanner.nextInt();
                    User.setPolicy(max);
                } else {
                    System.out.println("Error: SET POLICY requires an integer value.");
                }
                scanner.nextLine(); // Consume newline
                
            } else if (command.equals("LOGIN")) {
                // Operation LOGIN: Read password (String)
                System.out.print("Input (Password): ");
                String password = scanner.nextLine();
                user.login(password);
                
            } else {
                System.out.println("Error: Unknown command.");
            }
        }
        
        scanner.close();
}
}