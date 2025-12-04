package Lab1;
import java.util.Scanner;

public class Lab10 {
    public static double calculateArea(double width, double height) {
        // Calculate Area = Width * Height
        double area = width * height;
        return area;
    }

    // ----------------------------------------------------
    // PART 2: Main Method to handle input and output
    // ----------------------------------------------------
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Rectangle Area Calculator (Method Version) ---");

        // 1. Get the width (double) from the user
        System.out.print("Enter the width: ");
        
        // Basic input validation
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a decimal number for width.");
            scanner.close();
            return;
        }
        double width = scanner.nextDouble();

        // 2. Get the height (double) from the user
        System.out.print("Enter the height: ");
        
        if (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a decimal number for height.");
            scanner.close();
            return;
        }
        double height = scanner.nextDouble();

        // 3. Call the calculateArea function and store the returned result
        double resultArea = calculateArea(width, height);

        // 4. Display the result
        System.out.println("----------------------------------------");
        System.out.println("The calculated area is: " + resultArea);
        System.out.println("----------------------------------------");

        // Close the Scanner
        scanner.close();
}
}