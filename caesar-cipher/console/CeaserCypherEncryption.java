/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ceaser.cypher.encryption;

import java.util.Scanner;

/**
 *
 * @author benele
 */
public class CeaserCypherEncryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Caesar Cipher Console App ---");
        
        // 1. Get the Message
        System.out.print("Enter your message: ");
        String message = scanner.nextLine();

        // 2. Get the Key
        System.out.print("Enter the key (number): ");
        int key = scanner.nextInt();

        // 3. Choose Action
        System.out.print("Type 'E' to Encrypt or 'D' to Decrypt: ");
        char choice = scanner.next().toUpperCase().charAt(0);

        String result = "";
        switch (choice) {
            case 'E':
                result = processCipher(message, key);
                System.out.println("\nEncrypted Message: " + result);
                break;
            case 'D':
                // Decryption is just encryption with a negative shift!
                result = processCipher(message, -key);
                System.out.println("\nDecrypted Message: " + result);
                break;
            default:
                System.out.println("Invalid choice. Please restart.");
                break;
        }

        scanner.close();
    }

    /**
     * core logic to shift characters
     */
    public static String processCipher(String text, int shift) {
        StringBuilder output = new StringBuilder();

        // Standardize shift to be within 0-25 to handle large or negative numbers
        int standardizedShift = (shift % 26 + 26) % 26;

        for (char i : text.toCharArray()) {
            if (Character.isLetter(i)) {
                if (Character.isUpperCase(i)) {
                    // Shift within 'A'-'Z'
                    char c = (char) (((i - 'A' + standardizedShift) % 26) + 'A');
                    output.append(c);
                } else {
                    // Shift within 'a'-'z'
                    char c = (char) (((i - 'a' + standardizedShift) % 26) + 'a');
                    output.append(c);
                }
            } else {
                // Keep spaces as they are
                output.append(i);
            }
        }
        return output.toString();
    }
}
        
        