package Lab5;

import java.util.Scanner;

class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public String getStatus() {
        return "Person: " + name;
    }
}

class Student extends Person {
    protected int studentId;

    public Student(String name, int studentId) {
        super(name);
        this.studentId = studentId;
    }

    @Override
    public String getStatus() {
        return "Student: " + name + ", ID: " + studentId;
    }
}

class Employee extends Person {
    protected double salary;

    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public void applyBonus(double bonus) {
        this.salary += bonus;
    }

    @Override
    public String getStatus() {
        return "Employee: " + name + ", Salary: " + salary;
    }
}

public class Lab8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for Student
        String studentName = sc.nextLine();
        int studentId = Integer.parseInt(sc.nextLine());

        // Input for Employee
        String employeeName = sc.nextLine();
        double employeeSalary = Double.parseDouble(sc.nextLine());

        // 1. Create objects
        Student student = new Student(studentName, studentId);
        Employee employee = new Employee(employeeName, employeeSalary);

        // 2. Create Parent Class Array (Polymorphism)
        Person[] people = { student, employee };

        // 3. Loop to check for Employee and Downcast
        for (Person p : people) {
            if (p instanceof Employee) {
                // Downcasting Person to Employee to access applyBonus
                Employee emp = (Employee) p;
                emp.applyBonus(1000.0);
            }
        }

        // 4. Loop to display status
        for (Person p : people) {
            System.out.println(p.getStatus());
        }

        sc.close();
    }
}
