import java.util.Scanner;

class Movie {
    // Private attributes as required
    private String title;
    private String director;
    private double rating;

    // 1. Constructor: Receives only the title
    public Movie(String title) {
        // Chains to the second constructor with director set as "Unknown"
        this(title, "Unknown");
    }

    // 2. Constructor: Receives title and director
    public Movie(String title, String director) {
        // Chains to the main constructor with rating set as 0.0
        this(title, director, 0.0);
    }

    // 3. Main Constructor: Handles all attributes and validation
    public Movie(String title, String director, double rating) {
        this.title = title;
        this.director = director;
        
        // Validation: Rating must be between 0.0 and 10.0
        if (rating > 10.0) {
            this.rating = 10.0;
        } else if (rating < 0.0) {
            this.rating = 0.0;
        } else {
            this.rating = rating;
        }
    }

    // Displays details in the required format
    public void displayDetails() {
        System.out.println("Title: " + title + ", Director: " + director + ", Rating: " + rating);
    }
}

public class Lab8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept the mode (1, 2, or 3) from the user
        if (!sc.hasNextInt()) return;
        int mode = sc.nextInt();
        sc.nextLine(); // Consume newline

        Movie movie = null;

        // Create the Movie object based on the selected mode
        if (mode == 1) {
            String title = sc.nextLine();
            movie = new Movie(title);
        } else if (mode == 2) {
            String title = sc.nextLine();
            String director = sc.nextLine();
            movie = new Movie(title, director);
        } else if (mode == 3) {
            String title = sc.nextLine();
            String director = sc.nextLine();
            double rating = sc.nextDouble();
            movie = new Movie(title, director, rating);
        }

        // Display final result
        if (movie != null) {
            movie.displayDetails();
        }
    
}
}