package Lab5;

import java.util.Scanner;

// Superclass (Parent)
class Animal {
    // Attributes use 'protected' so that the Subclass can access them directly
    protected String name;
    protected int age;

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Subclass (Child)
class Dog extends Animal {
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

public class Lab1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept user input for Name and Age
        String inputName = sc.nextLine();
        int inputAge = sc.nextInt();

        // 1. Create a Dog object
        Dog myDog = new Dog();

        // 2. Set attributes inherited from Animal directly
        myDog.name = inputName;
        myDog.age = inputAge;

        // 3. Call method specific to Dog
        myDog.makeSound();

        // 4. Call method inherited from Animal
        myDog.displayInfo();

        sc.close();
    }
}