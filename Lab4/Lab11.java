import java.util.Scanner;

class Configuration {
    // Attributes are private and final to maintain immutability
    private final String theme;
    private final int fontSize;
    private final boolean darkMode;

    // 1. Main Constructor with validation
    public Configuration(String theme, int fontSize, boolean darkMode) {
        this.theme = theme;
        // Validation: fontSize must be between 10 and 20
        if (fontSize < 10) {
            this.fontSize = 10;
        } else if (fontSize > 20) {
            this.fontSize = 20;
        } else {
            this.fontSize = fontSize;
        }
        this.darkMode = darkMode;
    }

    // 2. Merge Constructor: Combines base and user settings
    public Configuration(Configuration base, Configuration user) {
        // Logic: use theme and darkMode from user, but fontSize from base
        this.theme = user.theme;
        this.darkMode = user.darkMode;
        this.fontSize = base.fontSize;
    }

    // Displays results in the required format
    public void displaySettings() {
        System.out.println("Theme: " + theme + ", Size: " + fontSize + ", Dark: " + darkMode);
    }
}

public class Lab11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input 1-3: Base Configuration
        String baseTheme = sc.next();
        int baseSize = sc.nextInt();
        boolean baseDark = sc.nextBoolean();

        // Input 4-6: User Configuration
        String userTheme = sc.next();
        int userSize = sc.nextInt();
        boolean userDark = sc.nextBoolean();

        // 1. Create baseConfig object
        Configuration baseConfig = new Configuration(baseTheme, baseSize, baseDark);
        
        // 2. Create userConfig object
        Configuration userConfig = new Configuration(userTheme, userSize, userDark);

        // 3. Create finalConfig using the Merge Constructor
        Configuration finalConfig = new Configuration(baseConfig, userConfig);

        // 4. Display final settings
        finalConfig.displaySettings();

        sc.close();
    
}
}