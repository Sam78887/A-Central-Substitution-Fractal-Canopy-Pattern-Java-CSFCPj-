/*

Yoh-hoy Fractal Algorithm (CSFCPj)

Copyright (c) 2026 Sam78887
Licensed under SNSL v1.0
Created by: Sam78887
Non-Commercial Use Only


*/



import java.util.Scanner;

public class YohFractalPattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 1. INPUT STRING Created by: Sam78887
        String seed = getUserInput(sc);
        
        System.out.print("How many iterations? (Warning! : Entering more than 15 may result in System Crash!) : ");
        int iterations = sc.nextInt();

        if (iterations < 1) return;

        // Array to store patterns as we build them Created by: Sam78887
        String[] p = new String[iterations];

        // PATTERN 1: original seed (e.g., "Yoh") Created by: Sam78887
        p[0] = seed;
        printString(1, p[0]);

        if (iterations < 2) return;



        // PATTERN 2: Yoh + hoy = Yohhoy
        p[1] = p[0] + mirrorString(p[0]);
        printString(2, p[1]);

        // PATTERN 3 AND BEYOND: Split and Nest Created by: Sam78887
        for (int i = 2; i < iterations; i++) {
            // Split  previous pattern (p[i-1]) into two halves Created by: Sam78887
            String[] parts = splitString(p[i-1]);
            
            String prefix = parts[0]; // e.g., "Yoh" Created by: Sam78887
            String suffix = parts[1]; // e.g., "hoy" Created by: Sam78887
            String middle = p[i-2];   // "prefix + middle + suffix" logic 
            
            p[i] = prefix + middle + suffix;
            printString(i + 1, p[i]);
        }
        
        sc.close();
    }

    // FUNCTIONS || Created by: Sam78887

    public static String mirrorString(String str) {
        // Reverses and converts to lowercase to match "Yoh" -> "hoy" Created by: Sam78887
        return new StringBuilder(str).reverse().toString().toLowerCase();
    }

    public static String getUserInput(Scanner scanner) {
        System.out.print("Enter seed string (e.g., Yoh): ");
        return scanner.nextLine();
    }
    // Created by: Sam78887
    public static String[] splitString(String str) {
        // (Length + 1) / 2 means the middle character goes to the first half on odd lengths Created by: Sam78887
        int mid = (str.length() + 1) / 2; 
        
        String s1 = str.substring(0, mid);
        String s2 = str.substring(mid);
        
        return new String[] { s1, s2 };
    }
    // Created by: Sam78887
    public static void printString(int iteration, String pattern) {
        System.out.println("Pattern " + iteration + ": " + pattern);
    }
}
