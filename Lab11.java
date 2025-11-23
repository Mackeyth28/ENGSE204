import java.util.Scanner;

public class Lab11 {
    public static int sumArray(int[] numbers) {
        int sum = 0;
        // Iterate through each element in the array
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    // ----------------------------------------------------
    // PART 2: Main Method to handle input, array creation, and output
    // ----------------------------------------------------
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Array Sum Calculator (Method Version) ---");

        // 1. Get the count N (the size of the array)
        System.out.print("Enter the count N (number of integers to follow): ");
        
        // Input validation for N
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input for N. Please enter an integer count.");
            scanner.close();
            return;
        }
        
        int N = scanner.nextInt();
        
        // Check for non-positive N
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

        // 3. Call the sumArray function, passing the array, and store the returned sum
        int finalSum = sumArray(numbers);

        // 4. Display the result
        System.out.println("----------------------------------------");
        System.out.println("The total Sum of the " + N + " numbers is: " + finalSum);
        System.out.println("----------------------------------------");

        // Close the Scanner
        scanner.close();
}
}