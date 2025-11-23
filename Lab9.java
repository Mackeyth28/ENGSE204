import java.util.Scanner;

public class Lab9 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Average Value Calculator for N Integers ---");

        // 1. Get the count N (the size of the array)
        System.out.print("Enter the count N (number of integers to follow): ");
        
        // Input validation for N
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input for N. Please enter an integer count.");
            scanner.close();
            return;
        }
        
        int N = scanner.nextInt();
        
        if (N <= 0) {
            System.out.println("N must be a positive integer.");
            scanner.close();
            return;
        }
        
        // Create an integer array of size N and initialize sum
        int[] numbers = new int[N];
        // Use 'long' for the sum to safely handle large inputs before division
        long sum = 0; 
        
        System.out.println("Enter " + N + " integers now:");

        // 2. Read N numbers and store them in the array while calculating the sum
        for (int i = 0; i < N; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("\nInvalid input. All subsequent inputs must be integers. Stopping.");
                scanner.close();
                return;
            }
            
            int currentNumber = scanner.nextInt();
            numbers[i] = currentNumber; 
            
            // Add the current number to the running total
            sum += currentNumber; 
        }

        // 3. Calculate the Average (Average)
        // Crucial Step: Cast the sum (long) to a double before dividing by N 
        // to ensure floating-point division and get a decimal result.
        double average = (double) sum / N;

        // 4. Display the result
        System.out.println("----------------------------------------------");
        System.out.println("The total Sum of the " + N + " numbers is: " + sum);
        System.out.println("The Average of the numbers is: " + average);
        System.out.println("----------------------------------------------");

        // Close the Scanner
        scanner.close();
}
}