import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        // Create a Scanner object to read integer input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Coffee Menu Selector (Enter 1-4) ---");

        // 1. Get the Menu Number input from the user
        System.out.print("Enter a menu number (1, 2, 3, or 4): ");
        
        // Add basic validation to ensure input is an integer
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid Menu: Input must be an integer.");
            scanner.close();
            return;
        }
        
        int menuNumber = scanner.nextInt();
        String drinkName;

        // 2. Use a switch statement to map the number to the drink name
        switch (menuNumber) {
            case 1:
                drinkName = "Americano";
                break;
            case 2:
                drinkName = "Latte";
                break;
            case 3:
                drinkName = "Espresso";
                break;
            case 4:
                drinkName = "Mocha";
                break;
            default:
                // If the number is not 1, 2, 3, or 4
                drinkName = "Invalid Menu";
                break;
        }

        // 3. Display the result
        System.out.println("----------------------------------------");
        System.out.println("Input Menu Number: " + menuNumber);
        System.out.println("Output: " + drinkName);
        System.out.println("----------------------------------------");

        // Close the Scanner
        scanner.close();
}
}