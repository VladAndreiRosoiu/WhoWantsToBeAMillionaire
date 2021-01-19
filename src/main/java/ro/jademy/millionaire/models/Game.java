package ro.jademy.millionaire.models;


import java.util.*;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private final Player player;
    private final List<Question> questions;
    private Question currentQuestion;
    private int levelNumber = 0;
    private static final List<Level> LEVEL_LIST = Arrays.asList(
            new Level(1, 100, 0),
            new Level(2, 200, 0),
            new Level(3, 500, 0),
            new Level(4, 700, 0),
            new Level(5, 1000, 1000),
            new Level(6, 2000, 0),
            new Level(7, 4000, 0),
            new Level(8, 8000, 0),
            new Level(9, 16000, 0),
            new Level(10, 32000, 32000),
            new Level(11, 64000, 0),
            new Level(12, 125000, 0),
            new Level(13, 250000, 0),
            new Level(14, 500000, 500000),
            new Level(15, 1000000, 1000000),
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
        System.out.println("Ok " + player.getName() + ", let's see if you can beat the game!");
        do {
            currentLevel = LEVEL_LIST.get(levelNumber);
            currentQuestion = questions.get(levelNumber);
            printQuestion();
            printAnsweringOptions();
            String choice = scanner.nextLine();
            String finalAnswer = doAnsweringOptions(choice);
            validateAnswer(finalAnswer);
            if (levelNumber == 4 || levelNumber == 9 || levelNumber == 13) {
                printQuitOption();
                String quitOption = scanner.next();
                doQuitOption(quitOption);
            }
            levelNumber++;
            if (levelNumber == 15 && !player.isWrongGuess()) {
                gameWon();
            }
        } while (!player.isWrongGuess());
    }

    private void printQuestion() {
        System.out.println();
        System.out.println("Question number " + currentLevel.getLevelNumber() + " for " + currentLevel.getReward() + " $!");
        System.out.println("Question category : " + currentQuestion.getCategoryText());
        System.out.println(currentQuestion.getQuestionText());
        for (int i = 0; i < currentQuestion.getAllAnswers().size(); i++) {
            System.out.println(((char) (65 + i)) + "-" + currentQuestion.getAllAnswers().get(i).getText());
        }
    }

    private void printAnsweringOptions() {
        System.out.println();
        System.out.println("Press * to use one of your lifelines or answer directly!");
    }

    private String doAnsweringOptions(String choice) {
        if (choice.equalsIgnoreCase("*")) {
            useLifeLine();
            System.out.println("Please enter you answer : ");
            return scanner.nextLine();
        } else {
            return choice;
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
            System.out.println("Great, " + player.getName() + "! Let's go on!");
        }
    }

    private void gameOver() {
        System.out.println("Game Over, "+player.getName()+"!");
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

