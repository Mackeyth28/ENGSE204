package Lab1;
import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        // Create a Scanner object to read integer input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Multiplication Table Generator (1 to 12) ---");

        // 1. Get the integer Multiplier input from the user
        System.out.print("Enter an integer multiplier: ");
        
        // Input validation
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.close();
            return;
        }
        
        int multiplier = scanner.nextInt();

        // 2. Display the header
        System.out.println("----------------------------------------------");
        System.out.println("Multiplication Table for " + multiplier + ":");
        
        // 3. Use a for loop to iterate from 1 to 12
        for (int i = 1; i <= 12; i++) {
            // Calculate the result
            int result = multiplier * i;
            
            // Display the output in the required format: [Multiplier] x [i] = [Result]
            System.out.println(multiplier + " x " + i + " = " + result);
        }

        System.out.println("----------------------------------------------");

        // Close the Scanner
        scanner.close();
}
}