package ro.jademy.millionaire.models;


import java.util.*;

public class Game {
    private Scanner scanner = new Scanner(System.in);
    private final Player player;
    private final List<Question> questions;
    private Question currentQuestion;
    private int levelNumber = 0;
    private static final List<Level> LEVEL_LIST = Arrays.asList(
            new Level(1, 100, 100),
            new Level(2, 200, 100),
            new Level(3, 500, 100),
            new Level(4, 700, 500),
            new Level(5, 1000, 500),
            new Level(6, 2000, 1000),
            new Level(7, 4000, 1000),
            new Level(8, 8000, 5000),
            new Level(9, 16000, 5000),
            new Level(10, 32000, 5000),
            new Level(11, 64000, 32000),
            new Level(12, 125000, 32000),
            new Level(13, 250000, 100000),
            new Level(14, 500000, 100000),
            new Level(15, 1000000, 500000),
            new Level(16, 1000000, 1000000)
    );
    private final List<Lifeline> lifelines = new ArrayList<>();
    private Level currentLevel;


    public Game(Player player, List<Question> questions) {
        this.player = player;
        this.questions = questions;
        lifelines.add(new Lifeline("50%"));
        lifelines.add(new Lifeline("50%"));
        lifelines.add(new Lifeline("50%"));
    }


    public void playGame() {
        for (Question question : questions) {
            System.out.println(question.getCorrectAnswer().getText());
        }

        int choice;
        String answer;
        try{
            do {
                currentLevel = LEVEL_LIST.get(levelNumber);
                currentQuestion = questions.get(levelNumber);
                printQuestion();
                printAnsweringOptions();
                choice=scanner.nextInt();
                doAnsweringOptions(choice);
                scanner.skip("\n");
                answer = scanner.nextLine();
                validateAnswer(answer);
                if (levelNumber == 5 || levelNumber == 10 || levelNumber == 14) {
                    printQuitOption();
                    String quitOption = scanner.next();
                    doQuitOption(quitOption);
                }
                levelNumber++;
                if (levelNumber == 15 && !player.isWrongGuess()) {
                    gameWon();
                }
            } while (!player.isWrongGuess() || levelNumber < 16);
        }catch (InputMismatchException e){
            System.out.println("Incorrect input!");
            scanner=new Scanner(System.in);
        }



    }

    private void printQuestion() {
        System.out.println();
        System.out.println("Question number " + currentLevel.getLevelNumber() + " for " + currentLevel.getReward() + " $!");
        System.out.println(currentQuestion.getCategoryText());
        System.out.println(currentQuestion.getQuestionText());
        for (int i = 0; i < currentQuestion.getAllAnswers().size(); i++) {
            System.out.println(((char) (65 + i)) + "-" + currentQuestion.getAllAnswers().get(i).getText());
        }
    }

    private void printAnsweringOptions() {
        System.out.println("You have 2 choices:");
        System.out.println("Press 1 to use one of your lifelines and to remove 2 of the answers!");
        System.out.println("Press 2 to answer directly!");
    }

    private void doAnsweringOptions(int choice) {
        if (choice == 1) {
            useLifeLine();
            System.out.println("Please enter answer:");
        } else if (choice == 2) {
            System.out.println("Please enter answer:");
        } else {
            System.out.println("Unknown choice!");
        }
    }

    private void useLifeLine() {
        Lifeline life = null;
        for (Lifeline lifeline : lifelines) {
            life = lifeline;
            break;
        }
        if (life != null && life.getName().equalsIgnoreCase("50%")) {
            doFiftyFifty();
            System.out.println("You have now " + lifelines.stream().count() + " lifelines remaining!");
        } else {
            System.out.println("No more lifelines remaining!");
        }
    }

    public void doFiftyFifty() {
        Random rdm = new Random();
        List<Answer> copyTempAllAnswerList = new ArrayList<>(currentQuestion.getAllAnswers());
        copyTempAllAnswerList.remove(currentQuestion.getCorrectAnswer());
        copyTempAllAnswerList.remove(rdm.nextInt(copyTempAllAnswerList.size()));
        copyTempAllAnswerList.remove(rdm.nextInt(copyTempAllAnswerList.size()));
        for (int i = 0; i < currentQuestion.getAllAnswers().size(); i++) {
            Answer answer = currentQuestion.getAllAnswers().get(i);
            if (answer.equals(currentQuestion.getCorrectAnswer()) || copyTempAllAnswerList.contains(answer)) {
                System.out.println(((char) (65 + i)) + "-" + currentQuestion.getAllAnswers().get(i).getText());
            } else {
                System.out.println(((char) (65 + i)) + "-");
            }
        }
        lifelines.remove(0);
    }

    private void validateAnswer(String answer) {
        if (answer.equalsIgnoreCase(currentQuestion.getCorrectAnswer().getText())) {
            System.out.println("Correct Answer!");
        } else {
            gameOver();
        }
    }

    public void printQuitOption() {
        System.out.println("You can quit now and keep your " + currentLevel.getRewardBreakout() + " $!");
        System.out.println("Or...");
        System.out.println("You can keep trying to earn the 1.000.000 $!");
        System.out.println("Please enter \"Q\" to quit or \"C\" to continue! ");
    }

    public void doQuitOption(String choice) {
        if (choice.equalsIgnoreCase("Q")) {
            gameOver();
        } else {
            System.out.println("Great! Let's go on!");
        }
    }

    private void gameOver() {
        System.out.println("Game Over!!!");
        System.out.println("You have won " + currentLevel.getRewardBreakout() + " $!");
        player.setWrongGuess(true);
    }

    private void gameWon() {
        System.out.println();
        System.out.println("***********************************");
        System.out.println("**      Congratulations !!!      **");
        System.out.println("***********************************");
        System.out.println("**        You have won !!!       **");
        System.out.println("**  You have won 1.000.000 $!!!  **");
        System.out.println("***********************************");
        player.setWrongGuess(true);
    }
}

