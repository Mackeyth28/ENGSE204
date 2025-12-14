package Lab3;

import java.util.Scanner;

public class Lab12 {

    /**
     * Class representing an Employee with salary, raise, and tax calculation logic.
     */
    static class Employee {
        // 1. Private Attributes
        private String name;
        private double monthlySalary;

        // 2. Public Constructor
        public Employee(String name, double monthlySalary) {
            this.name = name;
            
            // Validation: monthlySalary must be >= 0.
            if (monthlySalary < 0) {
                this.monthlySalary = 0.0;
            } else {
                this.monthlySalary = monthlySalary;
            }
        }

        // 3. Public Getter Method
        public String getName() {
            return this.name;
        }

        // 4. Public Setter Method with Logic
        /**
         * Gives a raise by increasing the monthly salary.
         * @param amount The positive amount of the raise.
         */
        public void giveRaise(double amount) {
            if (amount > 0) {
                this.monthlySalary += amount;
                System.out.println("Raise applied.");
            } else {
                System.out.println("Invalid amount.");
            }
        }

        // 5. Private Helper Method
        /**
         * Calculates the annual salary (internal calculation).
         * @return The annual salary (monthlySalary * 12).
         */
        private double getAnnualSalary() {
            // Annual salary is 12 times the monthly salary
            return this.monthlySalary * 12;
        }

        // 6. Public Interface Method
        /**
         * Calculates the tax owed based on the current annual salary and the provided tax rate.
         * @param taxRate The tax rate (e.g., 0.10 for 10%).
         * @return The calculated tax amount.
         */
        public double calculateTax(double taxRate) {
            double annualSalary = getAnnualSalary();
            // Tax = Annual Salary * Tax Rate
            return annualSalary * taxRate;
        }
    }

    /**
     * Main method to handle runtime input and execute the required test sequence.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Employee Tax and Raise Test ---");

        // Step 1: Read the four required input values
        System.out.print("Input (Line 1 - Name): ");
        String name = scanner.nextLine();
        
        System.out.print("Input (Line 2 - Monthly Salary): ");
        double monthlySalary = scanner.nextDouble();

        System.out.print("Input (Line 3 - Tax Rate): ");
        double taxRate = scanner.nextDouble();

        System.out.print("Input (Line 4 - Raise Amount): ");
        double raiseAmount = scanner.nextDouble();
        
        // Create the Employee object
        Employee employee = new Employee(name, monthlySalary); 

        System.out.println("\n--- Program Output ---");

        // Step 2: Display Tax (Before)
        double taxBefore = employee.calculateTax(taxRate);
        System.out.printf("Tax (Before): %.1f%n", taxBefore);

        // Step 3: Apply Raise
        employee.giveRaise(raiseAmount);

        // Step 4: Display Tax (After)
        double taxAfter = employee.calculateTax(taxRate);
        System.out.printf("Tax (After): %.1f%n", taxAfter);

        scanner.close();
    
}
}