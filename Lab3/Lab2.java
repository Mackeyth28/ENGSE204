package Lab3;
import java.util.Scanner;

public class Lab2 {

    /**
     * Inner class representing a Player with a score attribute.
     */
    static class Player {
        // 1. Private Attribute
        private int score;

        // 2. Constructor: Accepts initialScore and a public placeholder (publicVal)
        // The first input line should be used for initialScore.
        public Player(int initialScore, int publicVal) {
            this.score = initialScore;
        }

        /**
         * Public Method: Returns the current score.
         * @return The player's current score.
         */
        public int getScore() {
            return this.score;
        }

        /**
         * Public Method: Updates the score with a new value.
         * The second input line should be used for newScore.
         * @param newScore The new score value to set.
         */
        public void setScore(int newScore) {
            this.score = newScore;
        }
    }

    /**
     * Main method to handle runtime input and demonstrate the Player class.
     */
    public static void main(String[] args) {
        // Use Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Player Score Input ---");

        // Step 1: Read the first line of input (Initial Score)
        System.out.print("Input (Line 1 - Initial Score): ");
        int initialScore;
        if (scanner.hasNextInt()) {
            initialScore = scanner.nextInt();
        } else {
            System.err.println("Invalid input for initial score. Exiting.");
            scanner.close();
            return;
        }

        // Create the Player object using the initial score and a placeholder for the second public constructor parameter (0)
        Player player = new Player(initialScore, 0); 
        
        // Step 2: Read the second line of input (Update Score)
        System.out.print("Input (Line 2 - Update Score): ");
        int updateScore;
        if (scanner.hasNextInt()) {
            updateScore = scanner.nextInt();
        } else {
            System.err.println("Invalid input for update score. Keeping the initial score.");
            updateScore = player.getScore(); // If input is invalid, keep the current score
        }

        // Update the score using the setScore() method
        player.setScore(updateScore);

        // Step 3: Display the final result (Output)
        System.out.println("\n--- Program Output ---");
        // The output should be the score retrieved after the update.
        System.out.println("Output: " + player.getScore());
        
        scanner.close();
}
}