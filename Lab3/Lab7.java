package Lab3;

import java.util.Scanner;

public class Lab7 {

    /**
     * Class representing an Employee, demonstrating read-only (ID) and writable (Department) attributes.
     */
    static class Employee {
        // 1. Private Attributes
        private String employeeId; // Read-Only (no setter)
        private String department; // Writable (has a setter)

        // 2. Constructor: Must have 3 public parameters as requested.
        // The third parameter is a placeholder (publicVal) to meet the requirement.
        public Employee(String employeeId, String department, int publicVal) {
            // Initialize both private attributes
            this.employeeId = employeeId;
            this.department = department;
        }

        /**
         * Public Method: Returns the employee ID (Read-Only access).
         * @return The employee's ID.
         */
        public String getEmployeeId() {
            return this.employeeId;
        }

        /**
         * Public Method: Returns the employee's current department.
         * @return The department name.
         */
        public String getDepartment() {
            return this.department;
        }

        /**
         * Public Method: Updates the employee's department (Writable access).
         * @param newDepartment The new department name.
         */
        public void setDepartment(String newDepartment) {
            this.department = newDepartment;
        }
        
        // NOTE: setEmployeeId() is intentionally omitted to enforce the read-only requirement.
    }

    /**
     * Main method to handle runtime input and execute the required update sequence.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- Employee Data Management Test ---");

        // Step 1: Read the three required input values
        System.out.print("Input (Line 1 - Employee ID): ");
        String employeeId = scanner.nextLine();
        
        System.out.print("Input (Line 2 - Initial Department): ");
        String initialDepartment = scanner.nextLine();

        System.out.print("Input (Line 3 - New Department): ");
        String newDepartment = scanner.nextLine();
        
        // Create the Employee object using the ID and Initial Department
        // The third parameter in the constructor is set to 0 as a placeholder.
        Employee employee = new Employee(employeeId, initialDepartment, 0); 

        // Step 2: Update the department using the third input
        employee.setDepartment(newDepartment);

        System.out.println("\n--- Program Output ---");

        // Step 3: Print the final state using getEmployeeId() and getDepartment()
        
        // Output Line 1: Employee ID (unchanged)
        System.out.println(employee.getEmployeeId());
        
        // Output Line 2: Final Department (updated)
        System.out.println(employee.getDepartment());

        scanner.close(); // Close the Scanner object
    
}
}