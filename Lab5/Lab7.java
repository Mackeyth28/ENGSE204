package Lab5;

import java.util.Scanner;

// 1. Superclass: Employee
class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculatePay() {
        // Default returns base salary
        return baseSalary; 
    }
}

// 2. Subclass: SalesEmployee
class SalesEmployee extends Employee {
    protected double commissionRate;

    public SalesEmployee(String name, double baseSalary, double commissionRate) {
        // Constructor must use super(name, baseSalary)
        super(name, baseSalary); 
        this.commissionRate = commissionRate;
    }

    @Override
    public double calculatePay() {
        // Formula: baseSalary + (baseSalary * commissionRate)
        return baseSalary + (baseSalary * commissionRate);
    }
}

// 3. Subclass: Manager
class Manager extends Employee {
    protected double fixedBonus;

    public Manager(String name, double baseSalary, double fixedBonus) {
        // Constructor must use super(name, baseSalary)
        super(name, baseSalary); 
        this.fixedBonus = fixedBonus;
    }

    @Override
    public double calculatePay() {
        // Formula: baseSalary + fixedBonus
        return baseSalary + fixedBonus;
    }
}

// Utility Class: PayrollProcessor
class PayrollProcessor {
    public static void process(Employee e) {
        // Displays "[name] total pay: [value]" using polymorphism
        System.out.println(e.name + " total pay: " + e.calculatePay());
    }
}

// Main Class
public class Lab7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for SalesEmployee (name, salary, rate)
        String sName = sc.nextLine();
        double sSalary = sc.nextDouble();
        double sRate = sc.nextDouble();
        sc.nextLine(); // Clear buffer

        // Input for Manager (name, salary, bonus)
        String mName = sc.nextLine();
        double mSalary = sc.nextDouble();
        double mBonus = sc.nextDouble();

        // 1. Create objects
        SalesEmployee sales = new SalesEmployee(sName, sSalary, sRate);
        Manager manager = new Manager(mName, mSalary, mBonus);

        // 2. Process SalesEmployee
        PayrollProcessor.process(sales);

        // 3. Process Manager
        PayrollProcessor.process(manager);

        sc.close();
    }
}