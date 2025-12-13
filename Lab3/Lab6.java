package Lab3;

import java.util.Scanner;

public class Lab6 {

    /**
     * Class simulating a Bank Account with deposit and withdrawal operations,
     * enforcing business rules for transaction amounts and funds availability.
     */
    static class BankAccount {
        // 1. Private Attribute
        private double balance;

        // 2. Constructor: Must have 3 public parameters as requested.
        // The additional two parameters are placeholders (publicVal1, publicVal2).
        public BankAccount(double initialBalance, int publicVal1, int publicVal2) {
            // Check if initialBalance is negative. If so, initialize balance to 0.
            if (initialBalance < 0) {
                this.balance = 0.0;
            } else {
                this.balance = initialBalance;
            }
        }

        /**
         * Public Method: Returns the current account balance.
         * @return The account balance.
         */
        public double getBalance() {
            return this.balance;
        }

        /**
         * Public Method: Handles depositing money into the account.
         * @param amount The amount to deposit.
         */
        public void deposit(double amount) {
            if (amount > 0) {
                this.balance += amount;
                System.out.println("Deposit successful.");
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        /**
         * Public Method: Handles withdrawing money from the account.
         * @param amount The amount to withdraw.
         */
        public void withdraw(double amount) {
            if (amount <= 0) {
                // Case 3: amount is zero or negative
                System.out.println("Invalid withdrawal amount.");
            } else if (amount > this.balance) {
                // Case 2: amount is positive but exceeds the balance
                System.out.println("Insufficient funds.");
            } else {
                // Case 1: amount is positive and less than or equal to balance
                this.balance -= amount;
                System.out.println("Withdrawal successful.");
            }
        }
    }

    /**
     * Main method to handle runtime input and execute the required transaction sequence.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Bank Account Transaction Test ---");

        // Step 1: Read the three required input values (Initial Balance, Deposit, Withdrawal)
        System.out.print("Input (Line 1 - Initial Balance): ");
        double initialBalance = scanner.nextDouble();
        
        System.out.print("Input (Line 2 - Deposit Amount): ");
        double depositAmount = scanner.nextDouble();

        System.out.print("Input (Line 3 - Withdrawal Amount): ");
        double withdrawalAmount = scanner.nextDouble();
        
        // Create the BankAccount object
        // The second and third parameters in the constructor are set to 0 as placeholders.
        BankAccount account = new BankAccount(initialBalance, 0, 0); 

        System.out.println("\n--- Program Output ---");

        // Step 2: Execute the transaction sequence
        
        // 1. deposit()
        account.deposit(depositAmount);

        // 2. withdraw()
        account.withdraw(withdrawalAmount);
        
        // 3. Final state check: getBalance()
        System.out.printf("Final Balance: %.1f%n", account.getBalance()); // Use printf for clean output

        scanner.close(); // Close the Scanner object
    
}
}