package ro.jademy.millionaire;

import ro.jademy.millionaire.data.QuestionList;
import ro.jademy.millionaire.model.DifficultyLevel;
import ro.jademy.millionaire.model.Game;
import ro.jademy.millionaire.model.Question;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        do {
            Map<DifficultyLevel, List<Question>> questionsMap = new HashMap<>();
            questionsMap.put(DifficultyLevel.ONE, QuestionList.getDiffOneList());
            questionsMap.put(DifficultyLevel.TWO, QuestionList.getDiffTwoList());
            questionsMap.put(DifficultyLevel.THREE, QuestionList.getDiffThreeList());
            questionsMap.put(DifficultyLevel.FOUR, QuestionList.getDiffFourList());
            Game game = new Game(questionsMap);
            game.playGame();
        } while (playAgain());
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
