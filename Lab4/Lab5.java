import java.util.Scanner;

class Color {
    // Private attributes to ensure encapsulation
    private int red;
    private int green;
    private int blue;

    // Constructor with validation logic
    public Color(int r, int g, int b) {
        this.red = validate(r);
        this.green = validate(g);
        this.blue = validate(b);
    }

    // Helper method to keep values between 0 and 255
    private int validate(int value) {
        if (value < 0) return 0;
        if (value > 255) return 255;
        return value;
    }

    // Getter methods (No Setters are provided to keep the object Immutable)
    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    // Display result in format: R=[red], G=[green], B=[blue]
    public void displayRGB() {
        System.out.println("R=" + red + ", G=" + green + ", B=" + blue);
    }
}

public class Lab5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept R, G, and B inputs from the user
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();

        // Create the Immutable Color object
        Color myColor = new Color(r, g, b);

        // Display the validated RGB values
        myColor.displayRGB();

        sc.close();
}
}