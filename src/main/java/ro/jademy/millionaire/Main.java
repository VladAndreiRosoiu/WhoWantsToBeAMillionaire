package ro.jademy.millionaire;

import org.json.simple.parser.ParseException;
import ro.jademy.millionaire.models.Game;
import ro.jademy.millionaire.models.Player;
import ro.jademy.millionaire.services.QuestionsProviderService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ParseException {
        QuestionsProviderService qProvider = new QuestionsProviderService();
        do {
            System.out.println("Please enter your name : ");
            String name = scanner.next();
            System.out.println("Choose difficulty : ");
            System.out.println(" 1 - Easy");
            System.out.println(" 2 - Medium");
            System.out.println(" 3 - Hard");
            int difficulty = scanner.nextInt();
            Game game = new Game(new Player(name), qProvider.getQuestions(difficulty));
            game.playGame();
        }while (playAgain());
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
