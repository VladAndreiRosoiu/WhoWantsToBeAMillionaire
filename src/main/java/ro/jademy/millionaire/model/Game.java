package ro.jademy.millionaire.model;

import java.util.*;

public class Game {

    private List<Answer> tempAllAnswersList = new ArrayList<>();
    private Question currentQuestion;
    private int levelNumber = 0;

    private static final List<Level> LEVEL_LIST = Arrays.asList(
            new Level(1, 1, 100, 0),
            new Level(2, 1, 200, 0),
            new Level(3, 1, 500, 0),
            new Level(4, 1, 700, 0),
            new Level(5, 1, 1000, 0),
            new Level(6, 2, 2000, 1000),
            new Level(7, 2, 4000, 1000),
            new Level(8, 2, 8000, 1000),
            new Level(9, 2, 16000, 1000),
            new Level(10,2, 32000, 1000),
            new Level(11,3, 64000, 32000),
            new Level(12,3, 125000, 32000),
            new Level(13,3, 250000, 32000),
            new Level(14,3, 500000, 32000),
            new Level(15,4, 1000000, 500000)
    );

    private final List<Question> difficultyOneQuestions;
    private final List<Question> difficultyTwoQuestions;
    private final List<Question> difficultyThreeQuestions;
    private final List<Question> difficultyFourQuestions;


    public Player player = new Player();
    private final List<Lifeline> lifelines = new ArrayList<>();
    private final Level currentLevel = LEVEL_LIST.get(levelNumber);

    public Game(List<Question> difficultyOneQuestions, List<Question> difficultyTwoQuestions,
                List<Question> difficultyThreeQuestionsQuestions, List<Question> difficultyFourQuestions) {
        this.difficultyOneQuestions = difficultyOneQuestions;
        this.difficultyTwoQuestions = difficultyTwoQuestions;
        this.difficultyThreeQuestions = difficultyThreeQuestionsQuestions;
        this.difficultyFourQuestions = difficultyFourQuestions;

        lifelines.add(new Lifeline("50%"));
        lifelines.add(new Lifeline("50%"));
        lifelines.add(new Lifeline("50%"));
    }

    public void printWelcome() {
        System.out.println("Welcome to .......");
        System.out.println("Welcome to .......");
        System.out.println("Welcome to .......");
    }

    public void printRules() {
        System.out.println("Rules are .....");
        System.out.println("Rules are .....");
        System.out.println("Rules are .....");
    }

    public void showQuestion() {
        switch (currentLevel.getDifficultyLevel()) {
            case 1:
                currentQuestion = difficultyOneQuestions.get(0);
                printQuestion();
                levelNumber++;
                difficultyOneQuestions.remove(0);
                tempAllAnswersList = printAnswers(currentQuestion);
                break;
            case 2:
                currentQuestion = difficultyTwoQuestions.get(0);
                printQuestion();
                levelNumber++;
                tempAllAnswersList = printAnswers(currentQuestion);
                difficultyTwoQuestions.remove(0);
                break;
            case 3:
                currentQuestion = difficultyThreeQuestions.get(0);
                printQuestion();
                levelNumber++;
                tempAllAnswersList = printAnswers(currentQuestion);
                difficultyThreeQuestions.remove(0);
                break;
            case 4:
                currentQuestion = difficultyFourQuestions.get(0);
                printQuestion();
                levelNumber++;
                tempAllAnswersList = printAnswers(currentQuestion);
                difficultyFourQuestions.remove(0);
                break;
            default:
                System.out.println("Error!");
                break;
        }
    }

    public void printQuestion() {
        System.out.println();
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

    public void printAnsweringOptions() {
        System.out.println("You can choose from 2 options to answer the given question.");
        System.out.println("Press 1 - 50-50, this will remove 2 of the answers");
        System.out.println("Press 2 - to answer directly");
    }

    public void doAnsweringOptions(String choice) {
        if (choice.equalsIgnoreCase("1")) {
            doFiftyFifty();
        } else if (choice.equalsIgnoreCase("2")) {
            System.out.println("Please enter answer:");
        } else {
            System.out.println("Unknown choice!");
        }
    }

    private void doFiftyFifty() {
        if (!lifelines.get(0).isUsed()) {
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
        }
    }

    public void checkAnswer(String answer) {
        if (answer.equalsIgnoreCase(currentQuestion.getCorrectAnswer().getText())){
            System.out.println("Correct");
        }else {
            gameOver();
        }
    }

    public void gameOver() {
        System.out.println("game over");
        player.setWrongGuess(true);
    }
}



