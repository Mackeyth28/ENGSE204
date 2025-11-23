import java.util.Scanner;

public class Lab1 {
public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- 'Salak' Value Calculator (Absolute Sum) ---");

        // 1. Get the first integer
        System.out.print("Enter the first integer: ");
        int number1 = scanner.nextInt();

        // 2. Get the second integer
        System.out.print("Enter the second integer: ");
        int number2 = scanner.nextInt();

        // 3. Calculate the absolute value of each number
        // Use Math.abs() to get the absolute value
        int absNumber1 = Math.abs(number1);
        int absNumber2 = Math.abs(number2);

        // 4. Calculate the "Salak" value (Sum of absolute values)
        int absoluteSum = absNumber1 + absNumber2;

        // 5. Display the result
        System.out.println("----------------------------------------------");
        System.out.println("Absolute value of " + number1 + " is: " + absNumber1);
        System.out.println("Absolute value of " + number2 + " is: " + absNumber2);
        System.out.println("The 'Salak' value (Absolute Sum) is: " + absoluteSum);
        System.out.println("----------------------------------------------");

        // Close the Scanner
        scanner.close();
 }
}