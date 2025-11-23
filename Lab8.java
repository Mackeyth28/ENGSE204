import java.util.Scanner;

public class Lab8 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Maximum Value Finder in an Array ---");

        // 1. Get the count N (the size of the array)
        System.out.print("Enter the count N (number of integers to follow): ");
        
        // Input validation for N
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input for N. Please enter an integer count.");
            scanner.close();
            return;
        }
        
        int N = scanner.nextInt();
        
        // Handle case where N is non-positive
        if (N <= 0) {
            System.out.println("N must be a positive integer.");
            scanner.close();
            return;
        }
        
        // Create an integer array of size N
        int[] numbers = new int[N];
        
        System.out.println("Enter " + N + " integers now:");

        // 2. Read N numbers and store them in the array
        for (int i = 0; i < N; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            
            if (!scanner.hasNextInt()) {
                System.out.println("\nInvalid input. All subsequent inputs must be integers. Stopping.");
                scanner.close();
                return;
            }
            
            numbers[i] = scanner.nextInt(); 
        }

        // 3. Find the Maximum Value (Max Value)
        
        // Initialize max with the first element of the array
        int maxValue = numbers[0];

        // Loop through the rest of the array (starting from the second element at index 1)
        for (int i = 1; i < N; i++) {
            if (numbers[i] > maxValue) {
                // If the current element is greater than the current max, update max
                maxValue = numbers[i];
            }
        }

        // 4. Display the result
        System.out.println("----------------------------------------");
        System.out.println("The Maximum Value in the array is: " + maxValue);
        System.out.println("----------------------------------------");

        // Close the Scanner
        scanner.close();
}
}