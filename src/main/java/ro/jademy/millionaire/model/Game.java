package ro.jademy.millionaire.model;


import java.util.*;

public class Game {

    private final Scanner scanner = new Scanner(System.in);
    private List<Answer> tempAllAnswersList = new ArrayList<>();
    private Question currentQuestion;
    private int levelNumber = 0;

    private static final List<Level> LEVEL_LIST = Arrays.asList(
            new Level(1, DifficultyLevel.ONE, 100, 0),
            new Level(2, DifficultyLevel.ONE, 200, 0),
            new Level(3, DifficultyLevel.ONE, 500, 0),
            new Level(4, DifficultyLevel.ONE, 700, 0),
            new Level(5, DifficultyLevel.ONE, 1000, 0),
            new Level(6, DifficultyLevel.TWO, 2000, 1000),
            new Level(7, DifficultyLevel.TWO, 4000, 1000),
            new Level(8, DifficultyLevel.TWO, 8000, 1000),
            new Level(9, DifficultyLevel.TWO, 16000, 1000),
            new Level(10, DifficultyLevel.TWO, 32000, 1000),
            new Level(11, DifficultyLevel.THREE, 64000, 32000),
            new Level(12, DifficultyLevel.THREE, 125000, 32000),
            new Level(13, DifficultyLevel.THREE, 250000, 32000),
            new Level(14, DifficultyLevel.THREE, 500000, 32000),
            new Level(15, DifficultyLevel.FOUR, 1000000, 500000),
            new Level(16, DifficultyLevel.FOUR, 1000000, 1000000)
    );

    private Map<DifficultyLevel, List<Question>> questionMap;
    private Player player = new Player();
    private List<Lifeline> lifelines = new ArrayList<>();
    private Level currentLevel = LEVEL_LIST.get(levelNumber);


    public Game(Map<DifficultyLevel, List<Question>> questionMap) {
        this.questionMap = questionMap;
        lifelines.add(new Lifeline("50%"));
        lifelines.add(new Lifeline("50%"));
        lifelines.add(new Lifeline("50%"));
    }


    public void playGame() {

        String choice;
        String answer;
        printWelcome();
        printRules();

        do {
            showQuestion();
            printAnsweringOptions();
            choice = scanner.next();
            doAnsweringOptions(choice);
            scanner.skip("\n");
            answer = scanner.nextLine();
            validateAnswer(answer);
            currentLevel = LEVEL_LIST.get(++levelNumber);
            if (currentLevel.getLevelNumber() == 6 || currentLevel.getLevelNumber() == 11 || currentLevel.getLevelNumber() == 15) {
                printQuitOption();
                choice = scanner.next();
                doQuitOption(choice);
            }
            if (currentLevel.getLevelNumber() == 16) {
                gameWon();
            }
        } while (!player.isWrongGuess());
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("||================================||");
        System.out.println("||Welcome to who wants to be a... ||");
        System.out.println("||         MILLIONAIRE!!!         ||");
        System.out.println("||================================||");
        System.out.println();
    }

    private void printRules() {
        System.out.println("First rule : answer correctly to given questions!");
        System.out.println("There will be 15 questions, difficulty will be increased with each level!");
        System.out.println("You may quit the game and keep your money only after question 5, 10, or 14!");
        System.out.println("If you reached the upper mentioned checkpoints, you can keep the money earned at checkpoint!");
        System.out.println("You will be able to use " + lifelines.size() + " 50-50 option, after that... you are on your own!");
    }

    private void showQuestion() {

        switch (currentLevel.getDifficultyLevel()) {
            case ONE:
                doCurrentQuestionAndAnswer(DifficultyLevel.ONE);
                break;
            case TWO:
                doCurrentQuestionAndAnswer(DifficultyLevel.TWO);
                break;
            case THREE:
                doCurrentQuestionAndAnswer(DifficultyLevel.THREE);
                break;
            case FOUR:
                doCurrentQuestionAndAnswer(DifficultyLevel.FOUR);
                break;
            default:
                System.out.println("Error!");
                break;
        }
        tempAllAnswersList = printAnswers(currentQuestion);
    }

    private void doCurrentQuestionAndAnswer(DifficultyLevel difficultyLevel) {
        List<Question> questions;
        questions = questionMap.get(difficultyLevel);
        currentQuestion = questions.get(0);
        printQuestion();
        questions.remove(0);
    }

    private void printQuestion() {
        System.out.println();
        System.out.println("Next question for " + currentLevel.getReward() + " $!");
        System.out.println(currentQuestion.getText());
    }

    private List<Answer> printAnswers(Question question) {
        List<Answer> allAnswers = new ArrayList<>(question.getWrongAnswerList());
        allAnswers.add(question.getCorrectAnswer());
        Collections.shuffle(allAnswers);
        for (int i = 0; i < allAnswers.size(); i++) {
            System.out.println(((char) (65 + i)) + "-" + allAnswers.get(i).getText());
        }
        return allAnswers;
    }

    private void printAnsweringOptions() {
        System.out.println("You have 2 choices:");
        System.out.println("Press 1 to use one of your lifelines and to remove 2 of the answers!");
        System.out.println("Press 2 to answer directly!");
    }

    private void doAnsweringOptions(String choice) {
        if (choice.equalsIgnoreCase("1")) {
            useLifeLine();
            System.out.println("Please enter answer:");
        } else if (choice.equalsIgnoreCase("2")) {
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
            System.out.println("You have now " + lifelines.size() + " lifelines remaining!");
        } else {
            System.out.println("No more lifelines remaining!");
        }
    }

    public void doFiftyFifty() {
        Random rdm = new Random();
        List<Answer> copyTempAllAnswerList = new ArrayList<>(tempAllAnswersList);
        copyTempAllAnswerList.remove(currentQuestion.getCorrectAnswer());
        copyTempAllAnswerList.remove(rdm.nextInt(copyTempAllAnswerList.size()));
        copyTempAllAnswerList.remove(rdm.nextInt(copyTempAllAnswerList.size()));
        for (int i = 0; i < tempAllAnswersList.size(); i++) {
            Answer answer = tempAllAnswersList.get(i);
            if (answer.equals(currentQuestion.getCorrectAnswer()) || copyTempAllAnswerList.contains(answer)) {
                System.out.println(((char) (65 + i)) + "-" + tempAllAnswersList.get(i).getText());
            } else {
                System.out.println(((char) (65 + i)) + ". ");
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

