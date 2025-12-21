import java.util.Scanner;

class TimePeriod {
    private int startHour;
    private int endHour;

    // 1. Default Constructor (Chaining)
    public TimePeriod() {
        // Chains to the main constructor with default working hours (9:00 - 17:00)
        this(9, 17);
    }

    // 2. Main Constructor with Validation and Data Integrity
    public TimePeriod(int startHour, int endHour) {
        // Validation 1: Ensure hours are within 0-23 range
        int validatedStart = validateHour(startHour);
        int validatedEnd = validateHour(endHour);

        // Validation 2 (Data Integrity): Ensure start is less than end
        if (validatedStart > validatedEnd) {
            // Swap values if start is greater than end
            this.startHour = validatedEnd;
            this.endHour = validatedStart;
        } else {
            this.startHour = validatedStart;
            this.endHour = validatedEnd;
        }
    }

    // Helper method for range validation
    private int validateHour(int hour) {
        if (hour < 0) return 0;
        if (hour > 23) return 23;
        return hour;
    }

    // Display output in format [start]:00 - [end]:00
    public void displayPeriod() {
        System.out.println(startHour + ":00 - " + endHour + ":00");
    }
}

public class Lab10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Mode (1 or 2)
        if (!sc.hasNextInt()) return;
        int mode = sc.nextInt();

        TimePeriod tp;

        if (mode == 1) {
            // Use Default Constructor
            tp = new TimePeriod();
        } else {
            // mode 2: Accept startHour and endHour from user
            int start = sc.nextInt();
            int end = sc.nextInt();
            tp = new TimePeriod(start, end);
        }

        // Display the final validated time period
        tp.displayPeriod();

        sc.close();
    
}
}