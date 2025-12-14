package Lab3;

import java.util.Scanner;

public class Lab14 {

    /**
     * Class simulating a Bank Account, managing instance balance and static transaction count.
     */
    static class BankAccount {
        // 1. Private Instance Attribute
        private double balance;

        // 2. Private Static Attribute (Shared across all accounts/program)
        private static int totalTransactionCount = 0;

        // 3. Public Constructor
        public BankAccount(double initialDeposit) {
            // Validation: balance >= 0
            if (initialDeposit < 0) {
                this.balance = 0.0;
            } else {
                this.balance = initialDeposit;
            }
            System.out.println("Account created.");
            // NOTE: Constructor does NOT increment totalTransactionCount.
        }

        // 4. Public Getters
        public double getBalance() {
            return this.balance;
        }

        public static int getTotalTransactionCount() {
            return totalTransactionCount;
        }

        // 5. Public Mutator Methods
        public void deposit(double amount) {
            if (amount > 0) {
                this.balance += amount;
                BankAccount.totalTransactionCount++;
                System.out.println("Deposit successful.");
            } else {
                System.out.println("Invalid amount.");
            }
        }

        public void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid amount.");
            } else if (amount > this.balance) {
                System.out.println("Insufficient funds.");
            } else {
                this.balance -= amount;
                BankAccount.totalTransactionCount++;
                System.out.println("Withdrawal successful.");
            }
        }
    }

    /**
     * Main method to handle runtime input and execute N banking operations.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount myAccount = null; // Single account reference

        System.out.println("--- Bank Account Manager Test ---");

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
            System.out.print("Input (Command " + (i + 1) + "/" + N + " - CREATE/DEPOSIT/WITHDRAW/STATUS/GLOBAL_STATUS): ");
            String command = scanner.nextLine().trim().toUpperCase();

            switch (command) {
                case "CREATE":
                    System.out.print("Input (Initial Deposit): ");
                    if (scanner.hasNextDouble()) {
                        double initialDeposit = scanner.nextDouble();
                        if (myAccount == null) {
                            myAccount = new BankAccount(initialDeposit);
                        } else {
                            // Implied by Test Case 4: if account exists, it's not created again.
                            System.out.println("Account already exists.");
                        }
                    } else {
                        System.out.println("Error: CREATE requires a double value.");
                    }
                    scanner.nextLine();
                    break;

                case "DEPOSIT":
                case "WITHDRAW":
                    System.out.print("Input (Amount): ");
                    if (myAccount == null) {
                        System.out.println("No account exists.");
                        // Still need to consume the next input (amount) if it's there
                        if (scanner.hasNextDouble()) {
                            scanner.nextDouble();
                        }
                    } else if (scanner.hasNextDouble()) {
                        double amount = scanner.nextDouble();
                        if (command.equals("DEPOSIT")) {
                            myAccount.deposit(amount);
                        } else { // WITHDRAW
                            myAccount.withdraw(amount);
                        }
                    } else {
                        System.out.println("Error: " + command + " requires a double value.");
                    }
                    scanner.nextLine();
                    break;

                case "STATUS":
                    if (myAccount != null) {
                        System.out.printf("Balance: %.1f%n", myAccount.getBalance());
                    } else {
                        System.out.println("No account exists.");
                    }
                    break;

                case "GLOBAL_STATUS":
                    System.out.println("Total Transactions: " + BankAccount.getTotalTransactionCount());
                    break;

                default:
                    System.out.println("Error: Unknown command.");
                    break;
            }
        }

        scanner.close();
    
}
}