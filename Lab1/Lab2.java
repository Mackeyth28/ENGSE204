package Lab1;
import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Rectangle Area Calculator Program ---");

        // 1. Get the Width as a double
        System.out.print("Enter the Width: ");
        // Use nextDouble() to read the decimal value
        double width = scanner.nextDouble();

        // 2. Get the Height as a double
        System.out.print("Enter the Height: ");
        double height = scanner.nextDouble();

        // 3. Calculate the Area
        double area = width * height;

        // 4. Display the results
        System.out.println("----------------------------------------");
        System.out.println("Input Width: " + width);
        System.out.println("Input Height: " + height);
        // Display the calculated area
        System.out.println("The Area of the rectangle is: " + area);
        System.out.println("----------------------------------------");

        // Close the Scanner
        scanner.close();
 }
}

