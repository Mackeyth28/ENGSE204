package Lab1;
import java.util.Scanner;

public class Lab14 {
    public static boolean isValid(int R, int C, int r, int c) {
        return (r >= 0 && r < R && c >= 0 && c < C);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Minesweeper Logic Simulator ---");

        // 1. Get R (rows) and C (columns)
        System.out.print("Enter R (rows) and C (columns), separated by space: ");
        if (!scanner.hasNextInt()) { scanner.close(); return; }
        int R = scanner.nextInt();
        if (!scanner.hasNextInt()) { scanner.close(); return; }
        int C = scanner.nextInt();

        // Initialize the 2D map array (char type)
        char[][] map = new char[R][C];
        
        System.out.println("Enter the " + R * C + " map contents (* for Mine, . for Empty), row by row:");
        
        // 2. Loop to read R x C characters and fill the map
        for (int i = 0; i < R; i++) {
            // Read the entire row as a string (assuming no spaces between characters in the input)
            System.out.print("Enter Row " + (i + 1) + " (length " + C + "): ");
            String rowInput = scanner.next();
            
            if (rowInput.length() != C) {
                 System.out.println("Error: Row length must be " + C);
                 scanner.close();
                 return;
            }
            
            // Fill the array column by column
            for (int j = 0; j < C; j++) {
                map[i][j] = rowInput.charAt(j);
            }
        }

        // 3. Get the Target coordinates
        System.out.println("----------------------------------------");
        System.out.print("Enter target R (row) and C (column) to click (e.g., 1 1): ");
        if (!scanner.hasNextInt()) { scanner.close(); return; }
        int targetR = scanner.nextInt();
        if (!scanner.hasNextInt()) { scanner.close(); return; }
        int targetC = scanner.nextInt();

        String output;

        // --- Core Minesweeper Logic ---

        // Case 1: Clicked on a Mine (*)
        if (map[targetR][targetC] == '*') {
            output = "Mine";
        } 
        
        // Case 2: Clicked on an Empty spot (.)
        else {
            int mineCount = 0;
            
            // Define the 8 directions relative to the target cell (dr = delta row, dc = delta column)
            // This includes up, down, left, right, and the four diagonals.
            int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
            
            // Iterate through the 8 surrounding cells
            for (int i = 0; i < 8; i++) {
                int neighborR = targetR + dr[i];
                int neighborC = targetC + dc[i];

                // Boundary check: Ensure the neighbor cell is within the map limits
                if (isValid(R, C, neighborR, neighborC)) {
                    // Check if the neighbor cell contains a mine
                    if (map[neighborR][neighborC] == '*') {
                        mineCount++;
                    }
                }
            }
            
            // The output is the count of adjacent mines
            output = String.valueOf(mineCount);
        }

        // 4. Display the result
        System.out.println("---------------- OUTPUT ----------------");
        System.out.println(output);
        System.out.println("----------------------------------------");

        scanner.close();
}
}