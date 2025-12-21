import java.util.Scanner;

class AuditRecord {
    // Instance Attributes (Private and Immutable)
    private final String user;
    private final String[] logMessages;

    // Static Attribute (System-wide Policy)
    private static int maxMessages = 3;

    // 1. Simple Constructor (Chaining)
    public AuditRecord(String user) {
        // Chains to Main Constructor with an empty String array
        this(user, new String[0]);
    }

    // 2. Main Constructor with Deep Copy and Validation
    public AuditRecord(String user, String[] logs) {
        this.user = user;

        // Validation 1: If provided logs exceed maxMessages, take only the 'latest' ones (end of array)
        int countToCopy = Math.min(logs.length, maxMessages);
        this.logMessages = new String[countToCopy];

        // Deep Copying elements from the source array
        int sourceStart = logs.length - countToCopy;
        for (int i = 0; i < countToCopy; i++) {
            this.logMessages[i] = logs[sourceStart + i];
        }
    }

    // Static Setter for Policy Management
    public static void setMaxMessages(int max) {
        if (max > 0) {
            maxMessages = max;
            System.out.println("Policy set to " + max);
        } else {
            System.out.println("Invalid policy.");
        }
    }

    // Immutable Action: Adds a message by returning a NEW object
    public AuditRecord addMessage(String message) {
        if (logMessages.length < maxMessages) {
            // Create a larger array to accommodate the new message
            String[] newLogs = new String[logMessages.length + 1];
            
            // Copy existing messages
            for (int i = 0; i < logMessages.length; i++) {
                newLogs[i] = logMessages[i];
            }
            // Add the new one at the end
            newLogs[newLogs.length - 1] = message;
            
            System.out.println(message + " added.");
            return new AuditRecord(this.user, newLogs);
        } else {
            System.out.println("Log is full.");
            return this; // Return current object unchanged
        }
    }

    // Display output in format User: [user], Logs: [count] [m1, m2, ...]
    public void displayLog() {
        System.out.print("User: " + user + ", Logs: " + logMessages.length + " [");
        for (int i = 0; i < logMessages.length; i++) {
            System.out.print(logMessages[i]);
            if (i < logMessages.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

public class Lab15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Policy max, Username, and Number of commands
        int policyMax = sc.nextInt();
        AuditRecord.setMaxMessages(policyMax);
        
        sc.nextLine(); // Consume newline
        String username = sc.nextLine();
        
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        // Start with a simple record (0 logs)
        AuditRecord record = new AuditRecord(username);

        // Process N log messages
        for (int i = 0; i < n; i++) {
            String msg = sc.nextLine();
            // In a real scenario, special commands like SET_POLICY could be handled here
            if (msg.equals("SET_POLICY")) {
                int newPolicy = sc.nextInt();
                AuditRecord.setMaxMessages(newPolicy);
                if(sc.hasNextLine()) sc.nextLine();
            } else {
                record = record.addMessage(msg);
            }
        }

        // Final display
        record.displayLog();
        sc.close();
}
}