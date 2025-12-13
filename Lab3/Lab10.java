package Lab3;
import java.util.Scanner;

public class Lab10 {

    /**
     * Class simulating a System Logger with static methods and a static log level policy.
     */
    static class SystemLogger {
        // 1. Private Static Attribute: Initialized to 1 (INFO)
        private static int currentLogLevel = 1;

        // Log Level Constants for clarity
        private static final int INFO = 1;
        private static final int DEBUG = 2;
        private static final int ERROR = 3;

        // 2. Private Static Helper Method
        /**
         * Converts an integer log level (1, 2, 3) to its corresponding String name.
         * @param level The integer log level.
         * @return The log level name (e.g., "INFO") or "UNKNOWN".
         */
        private static String getLevelName(int level) {
            switch (level) {
                case INFO:
                    return "INFO";
                case DEBUG:
                    return "DEBUG";
                case ERROR:
                    return "ERROR";
                default:
                    return "UNKNOWN";
            }
        }

        // 3. Public Static Setter Method
        /**
         * Changes the system-wide log level. Prints confirmation or error message.
         * @param newLevel The new log level (1-3).
         */
        public static void setLogLevel(int newLevel) {
            if (newLevel >= INFO && newLevel <= ERROR) {
                SystemLogger.currentLogLevel = newLevel;
                // Print the name corresponding to the set level
                System.out.println("Log level set to " + getLevelName(newLevel));
            } else {
                System.out.println("Invalid log level.");
            }
        }

        // 4. Public Static Log Method
        /**
         * Logs a message if the message's level is less than or equal to the current log level.
         * @param messageLevel The level of the message being logged (1, 2, or 3).
         * @param message The content of the log message.
         */
        public static void log(int messageLevel, String message) {
            // Check if messageLevel is visible given the currentLogLevel
            // e.g., if currentLogLevel is DEBUG (2), then INFO(1) and DEBUG(2) messages are visible.
            if (messageLevel <= SystemLogger.currentLogLevel) {
                String levelName = getLevelName(messageLevel);
                System.out.println("[" + levelName + "]: " + message);
            }
            // If the messageLevel > currentLogLevel, do nothing (i.e., hide the message)
        }
    }

    /**
     * Main method to handle runtime input and execute N logging operations.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- System Logger Test ---");

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
            System.out.print("Input (Command " + (i + 1) + "/" + N + " - SET/LOG): ");
            String command = scanner.nextLine().trim().toUpperCase();

            if (command.equals("SET")) {
                // Operation SET: Read newLevel (int)
                System.out.print("Input (Level): ");
                if (scanner.hasNextInt()) {
                    int newLevel = scanner.nextInt();
                    SystemLogger.setLogLevel(newLevel);
                } else {
                    System.out.println("Error: SET requires an integer level.");
                }
                scanner.nextLine(); // Consume newline after reading int/potential error
                
            } else if (command.equals("LOG")) {
                // Operation LOG: Read messageLevel (int) and message (String)
                System.out.print("Input (Level and Message): ");
                if (scanner.hasNextInt()) {
                    int messageLevel = scanner.nextInt();
                    String message = scanner.nextLine().trim(); // Message is read from the rest of the line
                    SystemLogger.log(messageLevel, message);
                } else {
                    System.out.println("Error: LOG requires an integer level.");
                    scanner.nextLine(); // Consume remaining line if non-int input occurred
                }
            } else {
                System.out.println("Error: Unknown command.");
            }
        }
        
        scanner.close();
    
}
}