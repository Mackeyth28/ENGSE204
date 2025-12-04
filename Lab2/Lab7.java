package Lab2;
import java.util.Scanner;

// --- PROBLEM 1: Rectangle Class ---
// (Class definition is included for completeness, but the error is not here)
class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height; 
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }
}

// --- PROBLEM 2 & 3: BankAccount Class (Fixes NoSuchMethodError) ---
class BankAccount {
    private String ownerName;
    private double balance;

    public BankAccount(String ownerName, double initialBalance) {
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

   
    public void deposit(double amount) {
        this.balance += amount;
         
    }
    
   
    public void withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

   
    public void displayBalance() {
        System.out.println("Balance: " + this.balance);
    }
    
    
    public void displaySummary() {
        System.out.println("Owner: " + this.ownerName);
        System.out.println("Balance: " + this.balance);
    }
}

// --- MAIN EXECUTION CLASS (Lab7) ---
public class Lab7 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        // Input 1: Owner's Name (String)
        String inputOwnerName = scanner.nextLine();
        
        // Input 2: Initial Balance (double)
        double inputInitialBalance = scanner.nextDouble();
        
        // Input 3: Withdrawal Amount 1 (double)
        double inputWithdrawal1 = scanner.nextDouble();

        // Input 4: Withdrawal Amount 2 (double)
        double inputWithdrawal2 = scanner.nextDouble();
        
        scanner.nextLine(); // Consume newline

        // Create the BankAccount object
        BankAccount account = new BankAccount(inputOwnerName, inputInitialBalance);

        // Perform Withdrawal 1
        account.withdraw(inputWithdrawal1); 

        // Perform Withdrawal 2
        account.withdraw(inputWithdrawal2);

        // Display the final balance
        account.displayBalance();
        
        scanner.close(); 
    

}
}
    

