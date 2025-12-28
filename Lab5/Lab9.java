package Lab5;


import java.util.Scanner;

// Superclass: Item
class Item {
    protected String name;

    public Item(String name) {
        this.name = name;
    }

    // Default value is 0.0
    public double getValue() {
        return 0.0;
    }
}

// Subclass: PhysicalProduct
class PhysicalProduct extends Item {
    protected double unitPrice;
    protected int quantity;

    public PhysicalProduct(String name, double unitPrice, int quantity) {
        super(name);
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    @Override
    public double getValue() {
        // Return unitPrice * quantity
        return unitPrice * quantity;
    }
}

// Subclass: DigitalSubscription
class DigitalSubscription extends Item {
    protected double monthlyCost;
    protected int months;

    public DigitalSubscription(String name, double monthlyCost, int months) {
        super(name);
        this.monthlyCost = monthlyCost;
        this.months = months;
    }

    @Override
    public double getValue() {
        // Return monthlyCost * months
        return monthlyCost * months;
    }
}

public class Lab9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for PhysicalProduct
        String physicalName = scanner.nextLine();
        double unitPrice = Double.parseDouble(scanner.nextLine());
        int quantity = Integer.parseInt(scanner.nextLine());

        // Input for DigitalSubscription
        String digitalName = scanner.nextLine();
        double monthlyCost = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());

        // 1. Create objects
        PhysicalProduct product = new PhysicalProduct(physicalName, unitPrice, quantity);
        DigitalSubscription subscription = new DigitalSubscription(digitalName, monthlyCost, months);

        // 2. Create Parent Class Array (Item[])
        Item[] inventory = { product, subscription };

        // 3. Loop through Array to sum the values using Polymorphism
        double totalValue = 0;
        for (Item item : inventory) {
            totalValue += item.getValue();
        }

        // 4. Display total result
        System.out.println(totalValue);

        scanner.close();
    }
}