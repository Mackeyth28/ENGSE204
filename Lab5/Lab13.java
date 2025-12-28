package Lab5;

import java.util.Scanner;

class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public int getClearanceLevel() {
        // Level 1 for general users
        return 1;
    }
}

class Developer extends User {
    protected int projects;

    public Developer(String name, int projects) {
        super(name);
        this.projects = projects;
    }

    @Override
    public int getClearanceLevel() {
        // Level 2 for developers
        return 2;
    }
}

class Admin extends Developer {
    protected String adminKey;

    public Admin(String name, int projects, String adminKey) {
        super(name, projects);
        this.adminKey = adminKey;
    }

    @Override
    public int getClearanceLevel() {
        // Level 3 for admins
        return 3;
    }

    public String getAdminKey() {
        return adminKey;
    }
}

public class Lab13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Receive user input for Developer and Admin
        // Input for Developer d1
        String devName = sc.nextLine();
        int devProjects = Integer.parseInt(sc.nextLine());

        // Input for Admin a1
        String adminName = sc.nextLine();
        int adminProjects = Integer.parseInt(sc.nextLine());
        String adminKey = sc.nextLine();

        // 2. Create objects
        // User u1: default name "Guest", projects 0
        User u1 = new User("Guest"); 
        Developer d1 = new Developer(devName, devProjects);
        Admin a1 = new Admin(adminName, adminProjects, adminKey);

        // 3. Create Parent Class Array (User[])
        User[] users = { u1, d1, a1 };

        // 4. Loop to sum clearance levels
        int totalClearance = 0;
        for (User u : users) {
            totalClearance += u.getClearanceLevel();
        }

        // 5. Loop to check for Admin and display AdminKey using Downcasting
        for (User u : users) {
            if (u instanceof Admin) {
                // Downcast User to Admin
                Admin adminObj = (Admin) u;
                System.out.println(adminObj.getAdminKey());
            }
        }

        // 6. Display Total Clearance
        System.out.println(totalClearance);

        sc.close();
    }
}