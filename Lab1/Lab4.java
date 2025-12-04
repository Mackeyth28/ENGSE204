package Lab1;
import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        // Create a Scanner object to read integer input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Exam Grade Calculator (0-100) ---");

        // 1. Get the integer score input from the user
        System.out.print("Enter the score (0-100): ");
        
        // Add basic validation to ensure input is an integer
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer score.");
            scanner.close();
            return;
        }
        
        int score = scanner.nextInt();
        String grade;

        // 2. Determine the grade based on the score using if-else if structure
        
        // First, check for out-of-range scores (optional, but good practice)
        if (score < 0 || score > 100) {
            grade = "Score out of range (Must be 0-100)";
        } 
        // A: 80 - 100
        else if (score >= 80) {
            grade = "A";
        } 
        // B: 70 - 79 (We only need to check >= 70 because the >= 80 condition was handled above)
        else if (score >= 70) {
            grade = "B";
        } 
        // C: 60 - 69
        else if (score >= 60) {
            grade = "C";
        } 
        // D: 50 - 59
        else if (score >= 50) {
            grade = "D";
        } 
        // F: 0 - 49 (The remaining scores between 0 and 49 fall here)
        else {
            grade = "F";
        }

        // 3. Display the result
        System.out.println("----------------------------------------");
        System.out.println("Score: " + score);
        System.out.println("Grade: " + grade);
        System.out.println("----------------------------------------");

        // Close the Scanner
        scanner.close();
}
}