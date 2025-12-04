package Lab2;
import java.util.Scanner;

// Class to represent a Rectangle and calculate its properties
class Rectangle {
    // Attributes (fields)
    private double width;
    private double height;

    // Constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // getArea() Method
    public double getArea() {
        return width * height; 
    }

    // getPerimeter() Method
    public double getPerimeter() {
        return 2 * (width + height);
    }
}

// *** เปลี่ยนชื่อคลาสจาก Main เป็น Lab4 ***
public class Lab5 { 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double inputWidth = scanner.nextDouble();
        double inputHeight = scanner.nextDouble();

        scanner.close(); 

        Rectangle myRectangle = new Rectangle(inputWidth, inputHeight);

        // Line 1: Area
        System.out.println(myRectangle.getArea()); 
        
        // Line 2: Perimeter
        System.out.println(myRectangle.getPerimeter());
    }
}


