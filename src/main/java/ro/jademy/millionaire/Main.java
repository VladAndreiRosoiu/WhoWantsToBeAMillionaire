package ro.jademy.millionaire;

import org.json.simple.parser.ParseException;
import ro.jademy.millionaire.models.Game;
import ro.jademy.millionaire.models.Player;
import ro.jademy.millionaire.models.Question;
import ro.jademy.millionaire.services.QuestionsProviderService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;


public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static boolean playGame;

    public static void main(String[] args) {
        QuestionsProviderService qProvider = new QuestionsProviderService();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        printWelcome();
        int difficulty = chooseDifficulty();
        do {
            try {
                startGame(qProvider, executorService, difficulty);
            } catch (ParseException | ExecutionException | InterruptedException exception) {
                System.out.println("Something went wrong..");
                System.out.println("Let's try again!");
                continue;
            }
            playGame = playAgain();
        } while (playGame);
    }

    private static void printWelcome() {
        System.out.println();
        System.out.println("||================================||");
        System.out.println("||Welcome to who wants to be a... ||");
        System.out.println("||         MILLIONAIRE!!!         ||");
        System.out.println("||================================||");
        System.out.println();
    }

    private static int chooseDifficulty() {
        try {
            System.out.println("Choose difficulty : ");
            System.out.println(" 1 - Easy");
            System.out.println(" 2 - Medium");
            System.out.println(" 3 - Hard");
            int choice = scanner.nextInt();
            if (choice == 1 || choice == 2 || choice == 3) {
                return choice;
            } else {
                System.out.println("Please choose only one of the given numbers!");
                chooseDifficulty();
            }
        } catch (InputMismatchException inputMismatchException) {
            scanner = new Scanner(System.in);
            chooseDifficulty();
        }
        return 0;
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
            playAgain();
        }
        return false;
    }

    private static void printRules() {
        System.out.println("First rule : answer correctly to given questions!");
        System.out.println("There will be 15 questions of chosen difficulty!");
        System.out.println("You may quit the game and keep your money only after question 5, 10, or 14!");
        System.out.println("If you reached the upper mentioned checkpoints, you can keep the money earned at checkpoint!");
        System.out.println("You will be able to use 3 lifelines with 50-50 option, after that... you are on your own!");
    }

    private static void startGame(QuestionsProviderService qProvider, ExecutorService executorService, int difficulty)
            throws ParseException, ExecutionException, InterruptedException {
        Callable<String> apiResponseCallable = () -> qProvider.apiResponse(difficulty);
        Future<String> apiResponseFuture = executorService.submit(apiResponseCallable);
        System.out.println("Please enter your name : ");
        String name = scanner.next();
        printRules();
        System.out.println("Are you ready to start?");
        String answer = scanner.next();
        if (answer.equalsIgnoreCase("Y")) {
            String apiResponseString = apiResponseFuture.get();
            if (apiResponseString != null) {
                List<Question> questionList = new ArrayList<>(qProvider.getQuestions(apiResponseFuture.get()));
                Game game = new Game(new Player(name), questionList);
                game.playGame();
            } else {
                System.out.println("Something went wrong..");
                System.out.println("Let's try again!");
            }
        }
    }
}
