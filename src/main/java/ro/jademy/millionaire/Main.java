package ro.jademy.millionaire;

import org.json.simple.parser.ParseException;
import ro.jademy.millionaire.models.Game;
import ro.jademy.millionaire.models.Player;
import ro.jademy.millionaire.models.Question;
import ro.jademy.millionaire.services.QuestionsProviderService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.*;


public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static boolean playGame;

    public static void main(String[] args) throws ParseException, IOException, ExecutionException, InterruptedException {


        QuestionsProviderService qProvider = new QuestionsProviderService();


//        long startT1 = System.currentTimeMillis();
//        System.out.println("Starting api call: " + startT1);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        Callable<String> getApiResponse = () -> qProvider.apiResponse(1);
//        Future<String> getApiResponseFuture = executorService.submit(getApiResponse);
//        System.out.println("Finished api call : " + (System.currentTimeMillis()-startT1));
//        if (!executorService.isTerminated()){
//            long startT2 = System.currentTimeMillis();
//            System.out.println("Started getting questions : "+ startT2);
//            qProvider.getQuestions(getApiResponseFuture.get());
//            System.out.println("Finished getting question " + (System.currentTimeMillis()-startT2));
//        }
//        System.exit(0);


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        printWelcome();
        int difficulty =  chooseDifficulty();
        Callable<String> getApiResponseCallable = () -> qProvider.apiResponse(difficulty);
        Future<String> getApiResponseFuture = executorService.submit(getApiResponseCallable);
        System.out.println("Please enter your name : ");
        String name = scanner.next();
        do {
            printRules();
            System.out.println("Ready to start?");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("y")){
                System.out.println("Ok, let's start the game!");
                List<Question> questionList = new ArrayList<>();
                try {
                    questionList= qProvider.getQuestions(getApiResponseFuture.get());
                } catch (IOException ioException) {
                    System.out.println("Please choose only one of the given number..let's try again!");
                } catch (ParseException parseException) {
                    System.out.println("Something went wrong..let's try again!");
                }
                Game game = new Game(new Player(name), questionList);
                game.playGame();
                playGame=playAgain();
            }else {
                playGame=false;
            }
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
            return scanner.nextInt();
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
}
