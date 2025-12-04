package Lab2;

import java.util.Scanner;

/**
 * Represents a student, tracking their ID and name, and providing a method
 * to display their information.
 */
class Student {
    // Instance Attributes
    private String studentId;
    private String name;

    // Static Attribute (Carried over from the previous problem, keeping it optional here)
    // private static int studentCount = 0; 
    // Since the display method is the focus, we can omit studentCount unless needed.

    /**
     * Constructor for the Student class.
     * Initializes the instance attributes.
     *
     * @param studentId The unique ID of the student.
     * @param name The name of the student.
     */
    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        // If studentCount was needed: Student.studentCount++;
    }

    /**
     * Instance Method: Displays the student's ID and name to the console.
     * This method fulfills the requirement to add a "displayInfo()" method.
     */
    public void displayInfo() {
        System.out.println(this.studentId);
        System.out.println(this.name);
    }
    
    // Optional Getters (for completeness, though not explicitly used in the Main loop)
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}

/**
 * Main class (Lab2) to read input, create a Student object, and call the displayInfo() method.
 */
public class Lab2 { // The main public class is named Lab2
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // --- Input Reading ---
        
        // Read Student ID
        if (!scanner.hasNextLine()) {
            System.err.println("Input error: Missing student ID.");
            scanner.close();
            return;
        }
        String studentId = scanner.nextLine();

        // Read Student Name
        if (!scanner.hasNextLine()) {
            System.err.println("Input error: Missing student name.");
            scanner.close();
            return;
        }
        String name = scanner.nextLine();

        scanner.close();
        
        // --- Object Creation and Method Call ---

        // 1. Create a Student object, assigning the attributes
        Student student = new Student(studentId, name);
        
        // 2. Call the displayInfo() method on the created object
        student.displayInfo();
}
}