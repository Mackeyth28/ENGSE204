import java.util.Scanner;

class ImmutableAccount {
    // Attributes are private and final to ensure immutability
    private final String accountId;
    private final double balance;

    // 1. Main Constructor with validation
    public ImmutableAccount(String accountId, double balance) {
        this.accountId = accountId;
        // Validation: If balance is negative, set it to 0.0
        this.balance = (balance < 0) ? 0.0 : balance;
    }

    // 2. Copy Constructor
    public ImmutableAccount(ImmutableAccount other) {
        this.accountId = other.accountId;
        this.balance = other.balance;
    }

    // Getter Methods
    public String getAccountId() { return accountId; }
    public double getBalance() { return balance; }

    // Business Method: Deposit
    public ImmutableAccount deposit(double amount) {
        if (amount > 0) {
            // Return a NEW object with the increased balance
            return new ImmutableAccount(this.accountId, this.balance + amount);
        } else {
            System.out.println("Invalid deposit amount.");
            return this; // Return the current object unchanged
        }
    }

    // Business Method: Withdraw
    public ImmutableAccount withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return this;
        } else if (amount > this.balance) {
            System.out.println("Insufficient funds.");
            return this;
        } else {
            // Return a NEW object with the decreased balance
            return new ImmutableAccount(this.accountId, this.balance - amount);
        }
    }

    // Display info in format: ID: [id], Balance: [balance]
    public void displayInfo() {
        System.out.println("ID: " + accountId + ", Balance: " + balance);
    }
}

public class Lab9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: ID, Initial Balance, Deposit Amount, and Withdrawal Amount
        String id = sc.nextLine();
        double initialBalance = sc.nextDouble();
        double depositAmt = sc.nextDouble();
        double withdrawAmt = sc.nextDouble();

        // 1. Create initial account
        ImmutableAccount acc1 = new ImmutableAccount(id, initialBalance);

        // 2. Perform deposit and store in new reference acc2
        ImmutableAccount acc2 = acc1.deposit(depositAmt);

        // 3. Perform withdrawal and store in new reference acc3
        ImmutableAccount acc3 = acc2.withdraw(withdrawAmt);

        // 4. Display original and final status to prove immutability
        acc1.displayInfo();
        acc3.displayInfo();

        sc.close();
    
}
}