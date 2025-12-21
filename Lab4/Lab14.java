import java.util.Scanner;

class ScoreBoard {
    private final String gameName;
    private final int[] scores;

    // 1. Main Constructor: Uses Shallow Copy for the array
    public ScoreBoard(String gameName, int[] scores) {
        this.gameName = gameName;
        // Assigns the reference directly (Shallow Copy)
        this.scores = scores; 
    }

    // 2. Copy Constructor: Uses Deep Copy for the array
    public ScoreBoard(ScoreBoard other) {
        this.gameName = other.gameName;
        
        // Deep Copy: Create a new array and copy each element individually
        this.scores = new int[other.scores.length];
        for (int i = 0; i < other.scores.length; i++) {
            this.scores[i] = other.scores[i];
        }
    }

    // Displays output in format: [gameName]: [score1], [score2], [score3]
    public void displayScores() {
        System.out.print(gameName + ": ");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i]);
            if (i < scores.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}

public class Lab14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input 1: Game Name
        String game = sc.nextLine();

        // Input 2-4: Initial 3 scores
        int[] originalScores = new int[3];
        for (int i = 0; i < 3; i++) {
            originalScores[i] = sc.nextInt();
        }

        // Input 5: New value to modify the original array
        int newValue = sc.nextInt();

        // 1. Create original object (sb1) using the main constructor
        ScoreBoard sb1 = new ScoreBoard(game, originalScores);

        // 2. Create duplicate object (sb2) using the copy constructor (Deep Copy)
        ScoreBoard sb2 = new ScoreBoard(sb1);

        // 3. Modify the original array outside the objects
        originalScores[0] = newValue;

        // 4. Display results
        // sb1 will show the change because it points to the same array reference
        sb1.displayScores(); 
        // sb2 will remain unchanged because it has its own separate array copy
        sb2.displayScores();

        sc.close();
    
}
}