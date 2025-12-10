package Lab2;

import java.util.Scanner;

class Car {
    private String model;
    private int year;

    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int newYear) {
        this.year = newYear;
    }
}

public class Lab11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String model = sc.nextLine();
        int year = sc.nextInt();
        int newYear = sc.nextInt();

        Car c = new Car(model, year);

        c.setYear(newYear);

        System.out.println("Model: " + c.getModel());
        System.out.println("Year: " + c.getYear());
}
}
