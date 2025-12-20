import java.util.Scanner;

class Point {
    // Attributes are private and final to ensure immutability
    private final int x;
    private final int y;

    // Constructor to initialize x and y
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getter methods for reading values
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Returns a NEW Point object with updated coordinates
    public Point move(int dx, int dy) {
        int newX = this.x + dx;
        int newY = this.y + dy;
        return new Point(newX, newY);
    }

    // Displays the point in the format (x, y)
    public void displayInfo() {
        System.out.println("(" + x + ", " + y + ")");
    }
}

public class Lab6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept initial coordinates x, y and movement values dx, dy
        int x = sc.nextInt();
        int y = sc.nextInt();
        int dx = sc.nextInt();
        int dy = sc.nextInt();

        // 1. Create initial point p1
        Point p1 = new Point(x, y);

        // 2. Create p2 by moving p1
        Point p2 = p1.move(dx, dy);

        // 3. Create p3 by moving p2 again using the same offsets
        Point p3 = p2.move(dx, dy);

        // 4. Display all points sequentially
        p1.displayInfo();
        p2.displayInfo();
        p3.displayInfo();

        sc.close();
    
}
}