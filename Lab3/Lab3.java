package Lab3;
import java.util.Scanner;

public class Lab3 {

    /**
     * Inner class representing a User that manages a private password.
     */
    static class User {
        // 1. Private Attribute: password
        private String password;

        // 2. Constructor: Initializes the password.
        // Accepts initialPassword and a public placeholder (publicVal)
        public User(String initialPassword, int publicVal) {
            this.password = initialPassword;
        }

        /**
         * Public Method: Returns the current password.
         * The problem description implies this is used to show the "Current" password status
         * after a failed update attempt.
         * @return The user's current password.
         */
        public String getPassword() {
            return this.password;
        }

        /**
         * Public Method: Attempts to set a new password, performing length validation.
         * * Logic:
         * - If newPassword is 8 characters or more (>= 8), update the password 
         * and print "Password updated.".
         * - If newPassword is less than 8 characters (e.g., 7), do not update 
         * the password and print "Password is too short.".
         * * @param newPassword The password string to attempt to set.
         */
        public void setNewPassword(String newPassword) {
            if (newPassword.length() >= 8) {
                // If length >= 8, update the password
                this.password = newPassword;
                System.out.println("Password updated.");
            } else {
                // If length < 8, do not update the password
                System.out.println("Password is too short.");
            }
        }
    }

    /**
     * Main method to handle runtime input and demonstrate the User class.
     */
    public static void main(String[] args) {
        // Use Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- User Password Manager ---");

        // Step 1: Read the first line of input (Initial Password - 'รหัสผ่านเดิม')
        System.out.print("Input (Line 1 - Initial Password): ");
        String initialPassword = scanner.nextLine();
        
        // Create the User object using the initial password
        // The second public parameter in the constructor is set to 0 as a placeholder.
        User user = new User(initialPassword, 0); 
        
        System.out.println("Initial password set: " + user.getPassword());

        // Step 2: Read the second line of input (New Password - 'รหัสผ่านใหม่')
        System.out.print("Input (Line 2 - New Password): ");
        String newPassword = scanner.nextLine();

        System.out.println("\n--- Program Output ---");

        // Attempt to update the password using the validation method
        user.setNewPassword(newPassword);

        // Check the final status of the password as required by the Test Cases.
        // If the update succeeded (Test Case 1 & 3), output the new password.
        // If the update failed (Test Case 2), output the old (current) password 
        // using getPassword().
        
        // The output of the problem is the final state/result.
        System.out.println(user.getPassword());

        scanner.close(); // Close the Scanner object

    }
}