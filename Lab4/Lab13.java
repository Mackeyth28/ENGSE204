import java.util.Scanner;

class Subscription {
    // Instance Attributes (Private and Immutable)
    private final String planName;
    private final int durationDays;

    // Static Attribute (Private Policy)
    private static int maxDuration = 365;

    // 1. Main Constructor with Validation
    public Subscription(String planName, int durationDays) {
        this.planName = planName;
        // Validation: Ensure duration is between 0 and maxDuration
        if (durationDays > maxDuration) {
            this.durationDays = maxDuration;
        } else if (durationDays < 0) {
            this.durationDays = 0;
        } else {
            this.durationDays = durationDays;
        }
    }

    // 2. Copy Constructor
    public Subscription(Subscription other) {
        this.planName = other.planName;
        this.durationDays = other.durationDays;
    }

    // Static Setter for Policy Management
    public static void setMaxDuration(int max) {
        if (max > 0) {
            maxDuration = max;
            System.out.println("Max duration set to " + max);
        } else {
            System.out.println("Invalid max policy.");
        }
    }

    // Immutable Action: Extends subscription by returning a NEW object
    public Subscription extend(int days) {
        // Validation 1: Check for positive extension days
        if (days <= 0) {
            System.out.println("Invalid extension days.");
            return this;
        }

        // Validation 2: Policy Check (Current + New <= Max)
        int newDays = this.durationDays + days;
        if (newDays > maxDuration) {
            System.out.println("Extension failed: Exceeds max policy.");
            return this;
        }

        System.out.println("Extension successful.");
        return new Subscription(this.planName, newDays);
    }

    public void displayInfo() {
        System.out.println("Plan: " + planName + ", Days: " + durationDays);
    }
}

public class Lab13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input 1: System Policy
        int policyMax = sc.nextInt();
        Subscription.setMaxDuration(policyMax);
        sc.nextLine(); // Consume newline

        // Input 2: Plan Details
        String name = sc.nextLine();
        int initialDays = sc.nextInt();

        // Input 3: Two Extension Attempts
        int ext1 = sc.nextInt();
        int ext2 = sc.nextInt();

        // 1. Create initial subscription
        Subscription sub = new Subscription(name, initialDays);

        // 2. First Extension Attempt
        sub = sub.extend(ext1);

        // 3. Second Extension Attempt
        sub = sub.extend(ext2);

        // 4. Final Display
        sub.displayInfo();

        sc.close();
    
}
}