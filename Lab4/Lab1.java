import java.util.Scanner;

class Book {
    // Attributes as private to follow encapsulation
    private String title;
    private String author;

    // 1st Constructor: Accepts only title, sets author to "Unknown"
    public Book(String title) {
        this.title = title;
        this.author = "Unknown";
    }

    // 2nd Constructor (Overloading): Accepts both title and author
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Method to display info in the required format
    public void displayInfo() {
        System.out.println("Title: " + this.title + ", Author: " + this.author);
    }
}

public class Lab1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input "Mode" (int)
        if (sc.hasNextInt()) {
            int mode = sc.nextInt();
            sc.nextLine(); // Consume the remaining newline

            if (mode == 1) {
                // Mode 1: Receive title and use the first constructor
                String title = sc.nextLine();
                Book book = new Book(title);
                book.displayInfo();
            } else if (mode == 2) {
                // Mode 2: Receive title and author, then use the second constructor
                String title = sc.nextLine();
                String author = sc.nextLine();
                Book book = new Book(title, author);
                book.displayInfo();
            }
        }
        sc.close();
    }
}