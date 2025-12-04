package Lab2;

import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Student Data Entry and Output ---");

        // 1. Get studentId and name from the user
        
        // Get student ID
        System.out.print("Enter Student ID (e.g., 6501001): ");
        String inputId = scanner.nextLine(); 
        
        // Get full name
        System.out.print("Enter Full Name: ");
        String inputName = scanner.nextLine(); 

        // 2. Create an Instance (Object) of the Student class
        // This calls the Student(String, String) constructor.
        Student student1 = new Student(inputId, inputName);

        // 3. Display the attributes of the created object
        System.out.println("---------------- OUTPUT ----------------");
        System.out.println(student1.getStudentId()); // Using the getter method
        System.out.println(student1.getName());       // Using the getter method
        System.out.println("----------------------------------------");

        // Close the Scanner
        scanner.close();
    }
}

// DEFINITION OF THE REQUIRED CLASS
class Student {
    String studentId;
    String name;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }
    
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
}
}