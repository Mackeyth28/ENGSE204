import java.util.Scanner;

public class Lab13 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Server Monitoring Dashboard (Online Count) ---");

        // 1. Get R (rows) and C (columns)
        System.out.print("Enter the number of Rows (R): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input for R. Must be an integer.");
            scanner.close();
            return;
        }
        int R = scanner.nextInt();

        System.out.print("Enter the number of Columns (C): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input for C. Must be an integer.");
            scanner.close();
            return;
        }
        int C = scanner.nextInt();
        
        if (R <= 0 || C <= 0) {
            System.out.println("R and C must be positive integers.");
            scanner.close();
            return;
        }

        // Create the 2D array (Grid)
        int[][] serverGrid = new int[R][C];
        int onlineCount = 0; // Initialize the counter for 'Online' servers

        System.out.println("Enter " + R * C + " server statuses (1 for Online, 0 for Offline), row by row:");

        // 2. Nested loops to read R x C inputs and fill the 2D array
        for (int i = 0; i < R; i++) {
            System.out.println("--- Row " + (i + 1) + " (Enter " + C + " statuses) ---");
            for (int j = 0; j < C; j++) {
                System.out.print("Status for Server [" + i + "][" + j + "]: ");
                
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Status must be 0 or 1. Stopping.");
                    scanner.close();
                    return;
                }
                int status = scanner.nextInt();
                
                // Store the status in the grid
                serverGrid[i][j] = status;

                // 3. Calculate the total Online Count immediately
                if (status == 1) {
                    onlineCount++;
                }
            }
        }

        // 4. Display the final count
        System.out.println("----------------------------------------------");
        System.out.println("Total number of Online Servers: " + onlineCount);
        System.out.println("----------------------------------------------");

        // Close the Scanner
        scanner.close();
}
}