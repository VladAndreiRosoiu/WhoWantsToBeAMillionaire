package ro.jademy.millionaire;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

    }

    private static boolean playAgain() {
        System.out.println("Do you want to play another game?");
        System.out.println("Enter \"Y\" to play again or \"N\" not to!");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("Y")) {
            return true;
        } else if (choice.equalsIgnoreCase("N")) {
            System.out.println("Thank you for playing!");
        } else {
            System.out.println("Unknown choice!");
        }
        return false;
    }
}
