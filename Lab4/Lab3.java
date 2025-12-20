import java.util.Scanner;

class Player {
    private String username;
    private int level;

    // 1. Default Constructor
    public Player() {
        this.username = "Guest";
        this.level = 1;
    }

    // 2. Parameterized Constructor (Overloading)
    public Player(String username, int level) {
        this.username = username;
        this.level = level;
    }

    public void displayProfile() {
        System.out.println("User: " + username + ", Level: " + level);
    }
}

public class Lab3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input mode: 1 or 2
        int mode = sc.nextInt();
        
        Player player;

        if (mode == 1) {
            // Create object using Default Constructor
            player = new Player();
        } else {
            // mode 2: Create object using Parameterized Constructor
            sc.nextLine(); // Consume newline left over from nextInt()
            String name = sc.nextLine();
            int lvl = sc.nextInt();
            player = new Player(name, lvl);
        }

        // Display the result
        player.displayProfile();
        
        sc.close();

    }
}