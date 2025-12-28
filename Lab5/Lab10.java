package Lab5;

import java.util.Scanner;

class ProjectTask {
    protected String description;
    protected int baseHours;

    public ProjectTask(String desc, int hours) {
        this.description = desc;
        this.baseHours = hours;
    }

    public double calculateCost() {
        // Base rate is 50.0 per hour
        return baseHours * 50.0;
    }
}

class ComplexTask extends ProjectTask {
    protected double setupFee;

    public ComplexTask(String description, int baseHours, double setupFee) {
        super(description, baseHours);
        this.setupFee = setupFee;
    }

    @Override
    public double calculateCost() {
        // formula: (baseCost * 1.10) + setupFee
        return (super.calculateCost() * 1.10) + setupFee;
    }
}

class SimpleTask extends ProjectTask {
    public SimpleTask(String description, int baseHours) {
        super(description, baseHours);
    }

    @Override
    public double calculateCost() {
        // Return base cost with no additional charges
        return super.calculateCost();
    }
}

public class Lab10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for ComplexTask
        String complexDesc = sc.nextLine();
        int complexHours = Integer.parseInt(sc.nextLine());
        double setupFee = Double.parseDouble(sc.nextLine());

        // Input for SimpleTask
        String simpleDesc = sc.nextLine();
        int simpleHours = Integer.parseInt(sc.nextLine());

        // 1. Create objects
        ComplexTask complexTask = new ComplexTask(complexDesc, complexHours, setupFee);
        SimpleTask simpleTask = new SimpleTask(simpleDesc, simpleHours);

        // 2. Create Parent Class Array (ProjectTask[])
        ProjectTask[] tasks = { complexTask, simpleTask };

        // 3. Loop through array to call calculateCost() using Polymorphism
        for (ProjectTask task : tasks) {
            System.out.println(task.calculateCost());
        }

        sc.close();
    }
}