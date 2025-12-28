package Lab5;

import java.util.Scanner;

// Superclass representing a general employee
class Employee {
    protected double salary;

    // Calculates a base bonus of 10% of the salary
    public double calculateBonus() {
        return salary * 0.10;
    }
}

// Subclass representing a manager, inheriting from Employee
class Manager extends Employee {

    @Override
    public double calculateBonus() {
        // Uses super to get the base bonus (10%) and adds an extra 5%
        // Total bonus results in 15% of salary
        return super.calculateBonus() + (salary * 0.05);
    }
}

public class Lab3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Create a Manager object
        Manager mgr = new Manager();

        // 2. Receive "salary" (double) from user input
        if (sc.hasNextDouble()) {
            mgr.salary = sc.nextDouble();

            // 3. Call calculateBonus() and display the result
            double totalBonus = mgr.calculateBonus();
            System.out.println(totalBonus);
        }

        sc.close();
    }
}

