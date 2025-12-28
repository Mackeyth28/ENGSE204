package Lab5;

import java.util.Scanner;

// Superclass: Service
class Service {
    protected String name;
    protected double basePrice;

    public Service(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public double calculateFinalPrice() {
        return basePrice;
    }
}

// Subclass: BasicService
class BasicService extends Service {
    public BasicService(String name, double basePrice) {
        // Must use super constructor
        super(name, basePrice);
    }

    @Override
    public double calculateFinalPrice() {
        // Returns basePrice * 1.05 (includes 5% tax)
        return basePrice * 1.05;
    }
}

// Subclass: PremiumService
class PremiumService extends Service {
    protected double premiumRate;

    public PremiumService(String name, double basePrice, double premiumRate) {
        // Must use super constructor
        super(name, basePrice);
        this.premiumRate = premiumRate;
    }

    @Override
    public double calculateFinalPrice() {
        // Returns basePrice * (1 + premiumRate)
        return basePrice * (1 + premiumRate);
    }
}

public class Lab12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for BasicService
        String basicName = sc.nextLine();
        double basicPrice = Double.parseDouble(sc.nextLine());

        // Input for PremiumService
        String premiumName = sc.nextLine();
        double premiumPrice = Double.parseDouble(sc.nextLine());
        double premiumRate = Double.parseDouble(sc.nextLine());

        // 1. Create objects
        BasicService basic = new BasicService(basicName, basicPrice);
        PremiumService premium = new PremiumService(premiumName, premiumPrice, premiumRate);

        // 2. Create Parent Class Array (Service[]) to store both objects
        Service[] services = { basic, premium };

        // 3. Loop through array to call calculateFinalPrice() using Polymorphism
        for (Service s : services) {
            System.out.println(s.calculateFinalPrice());
        }

        sc.close();
    }
}