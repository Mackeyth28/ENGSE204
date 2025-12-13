package Lab3;

class User {
    
    // 1. Private Attribute (Data Hiding - Encapsulation)
    private String username;

    /**
     * 2. Constructor
     * Initializes a new User object with a specified username.
     * @param username The initial username string.
     */
    public User(String username) {
        // 'this.username' refers to the private instance variable.
        this.username = username;
    }

    /**
     * 3. Public Getter Method (Accessor)
     * Allows external code to safely read the private 'username' attribute.
     * @return The username as a String.
     */
    public String getUsername() {
        return username;
    }
}

// ------------------------------------------
// Part 2: The Main Class (Execution)
// ------------------------------------------
public class Lab1 {
    public static void main(String[] args) {
        
        // --- Test Case 1 ---
        System.out.println("--- Test Case 1 ---");
        // Create User object 1 (Input: somsak_jaidee)
        User user1 = new User("somsak_jaidee");
        // Retrieve and display (Output: somsak_jaidee)
        System.out.println("Output: " + user1.getUsername()); 

        // --- Test Case 2 ---
        System.out.println("\n--- Test Case 2 ---");
        // Create User object 2 (Input: admin01)
        User user2 = new User("admin01");
        // Retrieve and display (Output: admin01)
        System.out.println("Output: " + user2.getUsername()); 
        
        // --- Test Case 3 ---
        System.out.println("\n--- Test Case 3 ---");
        // Create User object 3 (Input: piti 999)
        User user3 = new User("piti 999");
        // Retrieve and display (Output: piti 999)
        System.out.println("Output: " + user3.getUsername());
    
}
}