package Lab1;
import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        // Create a Scanner object to read integer input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Even/Odd Number Checker ---");

        // 1. Get an integer input from the user
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        // 2. Check if the number is Even or Odd using the modulo operator (%)
        String result;
        
        if (number % 2 == 0) {
            // If the remainder when divided by 2 is 0, it's Even.
            result = "Even";
        } else {
            // Otherwise, it's Odd.
            result = "Odd";
        }

        // 3. Display the result
        System.out.println("-------------------------------");
        System.out.println("The number " + number + " is: " + result);
        System.out.println("-------------------------------");

        // Close the Scannergit 
        scanner.close();
}
}