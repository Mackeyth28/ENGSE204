package Lab5;

import java.util.Scanner;

class Animal {
    protected String name;
    protected int age;

    public void makeSound() {
        System.out.println("I am an animal.");
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Cat extends Animal {
    // Overriding the makeSound method from Animal class
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }
}

public class Lab2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Receive input from user
        String inputName = sc.nextLine();
        int inputAge = sc.nextInt();

        // 2. Create Cat object
        Cat myCat = new Cat();

        // 3. Assign values to inherited attributes
        myCat.name = inputName;
        myCat.age = inputAge;

        // 4. Call inherited displayInfo method
        myCat.displayInfo();

        // 5. Call overridden makeSound method
        myCat.makeSound();

        sc.close();
    }
}