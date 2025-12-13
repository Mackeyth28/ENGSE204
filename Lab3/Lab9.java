package Lab3;

import java.util.Scanner;

public class Lab9 {

    static class User {
        private String username;
        private String password;
        private static int minPasswordLength = 8;

        public static void setMinLength(int length) {
            if (length >= 4) {
                User.minPasswordLength = length;
                System.out.println("New min length set to " + length);
            } else {
                System.out.println("Invalid length.");
            }
        }

        public static int getMinLength() {
            return User.minPasswordLength;
        }

        public User(String username, String password) {
            this.username = username;
            
            if (password.length() >= User.minPasswordLength) {
                this.password = password;
                System.out.println("Creation successful.");
            } else {
                this.password = "invalid";
                System.out.println("Creation failed.");
            }
        }

        public String getPassword() {
            return this.password;
        }

        public void setPassword(String newPassword) {
            if (newPassword.length() >= User.minPasswordLength) {
                this.password = newPassword;
                System.out.println("Update successful.");
            } else {
                System.out.println("Update failed.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- User Security Policy Test ---");

        // Input 1: minLength1 (int)
        System.out.print("Input (Line 1 - minLength1): ");
        int minLength1 = scanner.nextInt();
        scanner.nextLine(); // FIX: Consume the newline character

        // Input 2: user1_name (String)
        System.out.print("Input (Line 2 - user1_name): ");
        String user1_name = scanner.nextLine();

        // Input 3: user1_pass (String)
        System.out.print("Input (Line 3 - user1_pass): ");
        String user1_pass = scanner.nextLine();

        // Input 4: user2_name (String)
        System.out.print("Input (Line 4 - user2_name): ");
        String user2_name = scanner.nextLine();

        // Input 5: user2_pass (String)
        System.out.print("Input (Line 5 - user2_pass): ");
        String user2_pass = scanner.nextLine();

        // Input 6: minLength2 (int)
        System.out.print("Input (Line 6 - minLength2): ");
        int minLength2 = scanner.nextInt();
        scanner.nextLine(); // FIX: Consume the newline character
        
        // Input 7: user2_newPass (String)
        System.out.print("Input (Line 7 - user2_newPass): ");
        String user2_newPass = scanner.nextLine();
        
        System.out.println("\n--- Program Output ---");
        
        // Execution sequence
        User.setMinLength(minLength1);
        User user1 = new User(user1_name, user1_pass);
        User user2 = new User(user2_name, user2_pass);
        User.setMinLength(minLength2);
        user2.setPassword(user2_newPass);

        // Final Output
        System.out.println(user1.getPassword());
        System.out.println(user2.getPassword());

        scanner.close();
    }
}