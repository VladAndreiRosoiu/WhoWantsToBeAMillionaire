package ro.jademy.millionaire;

import ro.jademy.millionaire.data.QuestionList;
import ro.jademy.millionaire.model.Game;
import ro.jademy.millionaire.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        do {
            List<Question> difficultyOneQuestions = getRandomQuestions(5, 1);
            List<Question> difficultyTwoQuestions = getRandomQuestions(5, 2);
            List<Question> difficultyThreeQuestions = getRandomQuestions(4, 3);
            List<Question> difficultyFourQuestions = getRandomQuestions(1, 4);

            Game game = new Game(difficultyOneQuestions, difficultyTwoQuestions,
                    difficultyThreeQuestions, difficultyFourQuestions);

            game.playGame();

        } while (playAgain());

    }

    private static List<Question> getRandomQuestions(int nrOfQuestions, int difficultyLevel) {
        List<Question> questionOfGivenDiff = new ArrayList<>();
        List<Question> randomQuestions = new ArrayList<>();

        for (Question question : QuestionList.entireQuestionList) {
            if (question.getDifficultyLevel() == difficultyLevel) {
                questionOfGivenDiff.add(question);
            }
        }
        Random rdm = new Random();
        for (int i = 0; i < nrOfQuestions; i++) {
            int randomIndex = rdm.nextInt(questionOfGivenDiff.size());
            randomQuestions.add(questionOfGivenDiff.remove(randomIndex));
        }
        return randomQuestions;
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
