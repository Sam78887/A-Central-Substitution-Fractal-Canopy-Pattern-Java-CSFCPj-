import java.util.Scanner;

public class YohFractalPattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. INPUT STRING
        String seed = getUserInput(sc);
        
        System.out.print("How many iterations? ");
        int iterations = sc.nextInt();

        if (iterations < 1) return;

        // Array to store patterns as we build them
        String[] p = new String[iterations];

        // PATTERN 1: original seed (e.g., "Yoh")
        p[0] = seed;
        printString(1, p[0]);

        if (iterations < 2) return;

        // PATTERN 2: Yoh + hoy = Yohhoy
        p[1] = p[0] + mirrorString(p[0]);
        printString(2, p[1]);

        // PATTERN 3 AND BEYOND: Split and Nest
        for (int i = 2; i < iterations; i++) {
            // Split  previous pattern (p[i-1]) into two halves
            String[] parts = splitString(p[i-1]);
            
            String prefix = parts[0]; // e.g., "Yoh"
            String suffix = parts[1]; // e.g., "hoy"
            String middle = p[i-2];   // "prefix + middle + suffix" logic
            
            p[i] = prefix + middle + suffix;
            printString(i + 1, p[i]);
        }
        
        sc.close();
    }

    // FUNCTIONS

    public static String mirrorString(String str) {
        // Reverses and converts to lowercase to match "Yoh" -> "hoy"
        return new StringBuilder(str).reverse().toString().toLowerCase();
    }

    public static String getUserInput(Scanner scanner) {
        System.out.print("Enter seed string (e.g., Yoh): ");
        return scanner.nextLine();
    }

    public static String[] splitString(String str) {
        // (Length + 1) / 2 means the middle character goes to the first half on odd lengths
        int mid = (str.length() + 1) / 2; 
        
        String s1 = str.substring(0, mid);
        String s2 = str.substring(mid);
        
        return new String[] { s1, s2 };
    }

    public static void printString(int iteration, String pattern) {
        System.out.println("Pattern " + iteration + ": " + pattern);
    }
}
