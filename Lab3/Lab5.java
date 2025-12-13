package Lab3;

import java.util.Scanner;

public class Lab5 {

    /**
     * Class simulating a database connection, managing the connection state.
     */
    static class DatabaseConnection {
        // 1. Private Attributes
        private String connectionString;
        private boolean connected = false; // Initialized to false

        // 2. Constructor: Must have 2 public parameters as requested.
        // The second parameter is a placeholder (publicVal) to meet the requirement.
        public DatabaseConnection(String connectionString, int publicVal) {
            // Set the connection string
            this.connectionString = connectionString;
            // The 'connected' attribute is initialized to false by the class definition
        }

        /**
         * Public Method: Returns the current connection state.
         * @return The value of the private 'connected' attribute.
         */
        public boolean isConnected() {
            return this.connected;
        }

        /**
         * Public Method: Attempts to establish a connection.
         */
        public void connect() {
            if (!this.connected) {
                // If currently disconnected (false), change state to true and print success
                this.connected = true;
                System.out.println("Connected to " + this.connectionString);
            } else {
                // If already connected (true), print status
                System.out.println("Already connected.");
            }
        }

        /**
         * Public Method: Attempts to terminate the connection.
         */
        public void disconnect() {
            if (this.connected) {
                // If currently connected (true), change state to false and print success
                this.connected = false;
                System.out.println("Disconnected.");
            } else {
                // If already disconnected (false), print status
                System.out.println("Already disconnected.");
            }
        }
    }

    /**
     * Main method to handle runtime input and run the required test sequence.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Database Connection Test ---");

        // Step 1: Read the connectionString from the user
        System.out.print("Input (Connection String/Server Name): ");
        String connectionString = scanner.nextLine();
        
        // Create the DatabaseConnection object
        // The second public parameter in the constructor is set to 0 as a placeholder.
        DatabaseConnection db = new DatabaseConnection(connectionString, 0); 

        System.out.println("\n--- Program Output ---");

        // Step 2: Run the required test sequence
        
        // 1. connect()
        db.connect();

        // 2. disconnect()
        db.disconnect();
        
        // 3. disconnect() again (for the 'Already disconnected.' check)
        db.disconnect();
        
        // 4. Final state check: isConnected()
        // The result of this boolean method should be printed
        System.out.println(db.isConnected());

        scanner.close(); // Close the Scanner object
}
}