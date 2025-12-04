package Lab2; // Changed the package name to Lab2

import java.util.Scanner;

/**
 * Represents a student with a unique ID and name.
 * Tracks the total number of Student objects created.
 */
class Student {
    // Instance Attributes
    private String studentId;
    private String name;

    // Static Attribute (Initial value is 0)
    private static int studentCount = 0;

    /**
     * Constructor for the Student class.
     * Initializes the instance attributes and increments the static studentCount.
     *
     * @param studentId The unique ID of the student.
     * @param name The name of the student.
     */
    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        // The most important step: increment the static counter
        Student.studentCount++;
    }

    /**
     * Getter for the static studentCount attribute.
     *
     * @return The total number of Student objects created so far.
     */
    public static int getStudentCount() {
        return Student.studentCount;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}

/**
 * Main class (Lab3) to read input, create Student objects, and display the total count.
 */
public class Lab3 { // Changed the public class name to Lab3
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Read 'N', the number of students to register
        if (!scanner.hasNextInt()) {
            System.err.println("Invalid input: Expected an integer for the number of students (N).");
            scanner.close();
            return;
        }
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // 2. Loop N times to read student data and create Student objects
        for (int i = 0; i < N; i++) {
            // Read student ID
            if (!scanner.hasNextLine()) {
                System.err.println("Unexpected end of input while reading student ID.");
                break;
            }
            String studentId = scanner.nextLine();

            // Read student name
            if (!scanner.hasNextLine()) {
                System.err.println("Unexpected end of input while reading student name.");
                break;
            }
            String name = scanner.nextLine();

            // Create a new Student object, which automatically increments studentCount
            new Student(studentId, name);
        }

        // 3. After the loop, display the final value of Student.studentCount
        System.out.println(Student.getStudentCount());

        scanner.close();
    }
}