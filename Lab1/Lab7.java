package Lab1;
import java.util.Scanner;

public class Lab7 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Sum Calculator for N Integers ---");

        // 1. Get the count N (how many numbers to sum)
        System.out.print("Enter the count N (how many numbers to sum): ");
        
        // Input validation for N
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input for N. Please enter an integer count.");
            scanner.close();
            return;
        }
        
        int N = scanner.nextInt();
        
        // Initialize the sum variable to 0
        long sum = 0; // Use 'long' for safety in case the sum exceeds the range of 'int'

        System.out.println("Enter " + N + " integers now:");

        // 2. Use a for loop to read N numbers and calculate the sum
        for (int i = 0; i < N; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            
            // Input validation for the numbers
            if (!scanner.hasNextInt()) {
                System.out.println("\nInvalid input. The subsequent inputs must be integers. Stopping calculation.");
                scanner.close();
                return;
            }
            
            int currentNumber = scanner.nextInt();
            
            // Add the current number to the running total
            sum += currentNumber; 
        }

        // 3. Display the final sum
        System.out.println("----------------------------------------------");
        System.out.println("The total Sum of the " + N + " numbers is: " + sum);
        System.out.println("----------------------------------------------");

        // Close the Scanner
        scanner.close();
}
}