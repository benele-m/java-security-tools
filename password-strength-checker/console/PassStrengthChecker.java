/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package passstrengthchecker;

import java.util.Scanner;

/**
 *
 * @author benele
 */
public class PassStrengthChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.println("#########PASSWORD STRENGTH CHECKER###########");
        char again = 'Y';
        while (again == 'Y') {
            System.out.println("Enter password: ");
            String passW = scanner.nextLine();
            check(passW);
            System.out.println("Check another password?(Y/N): ");
            String response = scanner.nextLine();
            again = response.toUpperCase().charAt(0);
        }
        scanner.close();

    }

    public static void check(String pass) {
        int score = 0;
        if (pass.length() >= 12) {
            score++;
        }
        if (pass.length() >= 8) {
            score++;
        }

        if (pass.matches(".*[A-Z].*")) {
            score++;
        }
        if (pass.matches(".*[a-z].*")) {
            score++;
        }
        if (pass.matches(".*\\d.*")) {
            score++;
        }
        if (pass.matches(".*[^A-Za-z0-9].*")) {
            score++;
        }
        if (score >= 6) {
            System.out.println("Very Strong");
        } else if (score >= 5) {
            System.out.println("Strong");
        } else if (score >= 4) {
            System.out.println("Moderate");
        } else if (score >= 3) {
            System.out.println("Weak");
        } else if (score < 3) {
            System.out.println("Very Weak");
        }

    }

}
