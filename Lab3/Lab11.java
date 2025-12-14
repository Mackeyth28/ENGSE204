package Lab3;
import java.util.Scanner;

public class Lab11 {

    /**
     * Class implementing the Singleton pattern for shared system configuration.
     */
    static class SystemConfig {
        // 1. Private Static Attribute: Holds the single instance
        private static SystemConfig instance;

        // 2. Private Instance Attributes (Configuration data)
        private String serverUrl;
        private int maxConnections;

        // 3. Private Constructor (Enforces Singleton)
        /**
         * Initializes default configuration values.
         */
        private SystemConfig() {
            this.serverUrl = "default.server.com";
            this.maxConnections = 10;
        }

        // 4. Public Static Getter (Singleton Access Point)
        /**
         * Returns the single instance of SystemConfig, creating it if necessary.
         * @return The singleton instance.
         */
        public static SystemConfig getInstance() {
            if (instance == null) {
                instance = new SystemConfig();
            }
            return instance;
        }

        // 5. Instance Methods: Getters and Setters

        public String getServerUrl() {
            return this.serverUrl;
        }

        public void setServerUrl(String url) {
            this.serverUrl = url;
        }

        public int getMaxConnections() {
            return this.maxConnections;
        }

        /**
         * Setter for maxConnections with validation (must be > 0).
         * @param count The new maximum connection count.
         */
        public void setMaxConnections(int count) {
            if (count > 0) {
                this.maxConnections = count;
                System.out.println("Max connections set.");
            } else {
                System.out.println("Invalid count.");
            }
        }
    }

    /**
     * Main method to handle runtime input and execute N configuration operations.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- System Config Manager Test (Singleton) ---");

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
            System.out.print("Input (Command " + (i + 1) + "/" + N + " - SET_URL/SET_MAX/SHOW): ");
            String command = scanner.nextLine().trim().toUpperCase();

            // Crucial: Get the single instance for every operation
            SystemConfig config = SystemConfig.getInstance();

            if (command.equals("SET_URL")) {
                // Read URL (String)
                System.out.print("Input (URL): ");
                String url = scanner.nextLine().trim();
                config.setServerUrl(url);
                
            } else if (command.equals("SET_MAX")) {
                // Read Max Count (int)
                System.out.print("Input (Max Count): ");
                if (scanner.hasNextInt()) {
                    int count = scanner.nextInt();
                    config.setMaxConnections(count);
                } else {
                    System.out.println("Error: SET_MAX requires an integer count.");
                }
                scanner.nextLine(); // Consume newline after reading int/potential error
                
            } else if (command.equals("SHOW")) {
                // Display current configuration
                System.out.println("URL: " + config.getServerUrl());
                System.out.println("MAX: " + config.getMaxConnections());
            } else {
                System.out.println("Error: Unknown command.");
            }
        }
        
        scanner.close();
    
}
}