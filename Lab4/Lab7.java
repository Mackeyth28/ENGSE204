import java.util.Scanner;

class Resource {
    // Private attribute for identifying the object
    private String id;

    // Constructor to initialize id and print creation message
    public Resource(String id) {
        this.id = id;
        System.out.println("Resource " + id + " created.");
    }

    // finalize() method called by GC before object destruction
    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Resource " + id + " finalized (destroyed).");
        } finally {
            super.finalize();
        }
    }
}

public class Lab7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept 3 ID values from the user
        String id1 = sc.nextLine();
        String id2 = sc.nextLine();
        String id3 = sc.nextLine();

        // 1. Create 3 Resource objects
        Resource r1 = new Resource(id1);
        Resource r2 = new Resource(id2);
        Resource r3 = new Resource(id3);

        // 2. Set r1 and r2 to null to make them eligible for GC
        r1 = null;
        r2 = null;

        // 3. Request Garbage Collector to run
        System.gc();

        // 4. Set r3 to null to make it eligible for GC
        r3 = null;

        // 5. Request Garbage Collector to run again
        System.gc();

        sc.close();
    }
}
    

