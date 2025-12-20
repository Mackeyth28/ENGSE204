import java.util.Scanner;

class Location {
    private double latitude;
    private double longitude;

    // 1. Main Constructor: Assigns latitude and longitude as received
    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // 2. Copy Constructor: Duplicates values from another Location object
    public Location(Location other) {
        this.latitude = other.latitude;
        this.longitude = other.longitude;
    }

    // Method to change the latitude value
    public void setLatitude(double newLat) {
        this.latitude = newLat;
    }

    // Displays the location in the format: Lat: [lat], Lon: [lon]
    public void displayInfo() {
        System.out.println("Lat: " + latitude + ", Lon: " + longitude);
    }
}

public class Lab4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Initial latitude, initial longitude, and new latitude
        double initialLat = sc.nextDouble();
        double initialLon = sc.nextDouble();
        double updatedLat = sc.nextDouble();

        // 1. Create the original object 'loc1' using the main constructor
        Location loc1 = new Location(initialLat, initialLon);

        // 2. Create the duplicate object 'loc2' using the copy constructor
        Location loc2 = new Location(loc1);

        // 3. Update the latitude of the original object loc1
        loc1.setLatitude(updatedLat);

        // 4. Display both objects to prove loc2 remains unchanged
        loc1.displayInfo();
        loc2.displayInfo();

        sc.close();
    
}
}