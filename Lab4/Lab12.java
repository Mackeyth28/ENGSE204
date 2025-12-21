import java.util.Scanner;

// 1. Mutable Component: Represents a schedule that can be modified
class Schedule {
    private int hour;

    public Schedule(int hour) { 
        this.hour = hour; 
    }
    
    // Copy Constructor for Schedule to facilitate Deep Copy
    public Schedule(Schedule other) {
        this.hour = other.hour;
    }

    public void setHour(int newHour) { 
        this.hour = newHour; 
    }
    
    public int getHour() { 
        return hour; 
    }
}

// 2. Container Class: Represents an employee with a schedule
class EmployeeSchedule {
    private String name;
    private Schedule schedule; // Mutable object reference

    // Main Constructor
    public EmployeeSchedule(String name, Schedule schedule) {
        this.name = name;
        this.schedule = schedule;
    }

    // Copy Constructor: Implements Deep Copy logic
    public EmployeeSchedule(EmployeeSchedule other) {
        // Shallow Copy for the String (Strings are immutable in Java)
        this.name = other.name;
        
        // Deep Copy for the Schedule: Create a NEW object using the original's value
        // This ensures the clone and the original are separated in memory
        this.schedule = new Schedule(other.schedule.getHour());
    }

    public void displaySchedule() {
        System.out.println(name + ": " + schedule.getHour() + ":00");
    }
}

public class Lab12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept user input for Name, Initial Hour, and Updated Hour
        String empName = sc.nextLine();
        int initialHour = sc.nextInt();
        int updatedHour = sc.nextInt();

        // 1. Create the internal Mutable Component (sch1)
        Schedule sch1 = new Schedule(initialHour);

        // 2. Create the Original Container object (emp1)
        EmployeeSchedule emp1 = new EmployeeSchedule(empName, sch1);

        // 3. Create the Duplicate Container object (emp2) using Deep Copy
        EmployeeSchedule emp2 = new EmployeeSchedule(emp1);

        // 4. Modify the original internal object
        sch1.setHour(updatedHour);

        // 5. Display both to prove emp1 changed but emp2 stayed the same
        emp1.displaySchedule();
        emp2.displaySchedule();

        sc.close();
    
}
}