package ro.jademy.millionaire;

import ro.jademy.millionaire.model.DifficultyLevel;
import ro.jademy.millionaire.model.Game;
import ro.jademy.millionaire.model.Question;
import ro.jademy.millionaire.services.IOService;
import ro.jademy.millionaire.services.RandomizeQuestions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final String diffOneQFile = "diffOneQuestions.csv";
    private static final String diffTwoQFile = "diffTwoQuestions.csv";
    private static final String diffThreeQFile = "diffThreeQuestions.csv";
    private static final String diffFourQFIle = "diffFourQuestions.csv";

    public static void main(String[] args) {
        try {
            do {
                Map<DifficultyLevel, List<Question>> questionsMap = new HashMap<>();
                questionsMap.put(DifficultyLevel.ONE, RandomizeQuestions.getRandomQuestions(5,
                        IOService.readFile(diffOneQFile)));
                questionsMap.put(DifficultyLevel.TWO, RandomizeQuestions.getRandomQuestions(5,
                        IOService.readFile(diffTwoQFile)));
                questionsMap.put(DifficultyLevel.THREE, RandomizeQuestions.getRandomQuestions(4,
                        IOService.readFile(diffThreeQFile)));
                questionsMap.put(DifficultyLevel.FOUR, RandomizeQuestions.getRandomQuestions(1,
                        IOService.readFile(diffFourQFIle)));
                Game game = new Game(questionsMap);
                game.playGame();
            } while (playAgain());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean playAgain() {
        System.out.println("Do you want to play another game?");
        System.out.println("Enter \"Y\" to play again or \"N\" not to!");
        String choice = sc.next();
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
