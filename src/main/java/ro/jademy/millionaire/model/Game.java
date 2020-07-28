package ro.jademy.millionaire.model;

import java.util.*;

public class Game {

    private Scanner sc = new Scanner(System.in);
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
            new Level(10, 2, 32000, 1000),
            new Level(11, 3, 64000, 32000),
            new Level(12, 3, 125000, 32000),
            new Level(13, 3, 250000, 32000),
            new Level(14, 3, 500000, 32000),
            new Level(15, 4, 1000000, 500000),
            new Level(16, 4, 1000000, 1000000)
    );

    private List<Question> difficultyOneQuestions;
    private List<Question> difficultyTwoQuestions;
    private List<Question> difficultyThreeQuestions;
    private List<Question> difficultyFourQuestions;

    private Player player = new Player();
    private final List<Lifeline> lifelines = new ArrayList<>();
    private Level currentLevel = LEVEL_LIST.get(levelNumber);

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

    public void playGame() {

        String choice;
        String answer;

        printWelcome();
        printRules();

        do {
            showQuestion();
            printAnsweringOptions();
            choice = sc.next();
            doAnsweringOptions(choice);
            sc.skip("\n");
            answer = sc.nextLine();
            validateAnswer(answer);
            if (currentLevel.getLevelNumber()==15){
                gameWon();
            }else{
                currentLevel = LEVEL_LIST.get(++levelNumber);
            }
            if (currentLevel.getLevelNumber()==6 || currentLevel.getLevelNumber()==11 || currentLevel.getLevelNumber()==15){
                printQuitOption();
                choice=sc.next();
                doQuitOption(choice);
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
        System.out.println("You will be able to use "+lifelines.size()+" 50-50 option, after that... you are on your own!");
    }

    private void showQuestion() {
        switch (currentLevel.getDifficultyLevel()) {
            case 1:
                currentQuestion = difficultyOneQuestions.get(0);
                printQuestion();
                difficultyOneQuestions.remove(0);
                break;
            case 2:
                currentQuestion = difficultyTwoQuestions.get(0);
                printQuestion();
                difficultyTwoQuestions.remove(0);
                break;
            case 3:
                currentQuestion = difficultyThreeQuestions.get(0);
                printQuestion();
                difficultyThreeQuestions.remove(0);
                break;
            case 4:
                currentQuestion = difficultyFourQuestions.get(0);
                printQuestion();
                break;
            default:
                System.out.println("Error!");
                break;
        }
        tempAllAnswersList = printAnswers(currentQuestion);
    }

    private void printQuestion() {
        System.out.println();
        System.out.println("Next question for "+currentLevel.getReward()+" $!");
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
        Lifeline life=null;
        for (Lifeline lifeline : lifelines) {
            life=lifeline;
            break;
        }
        if (life!=null){
            doFiftyFifty();
            System.out.println("You have now "+lifelines.size() + " lifelines remaining!");
        }else {
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

    public void printQuitOption(){
        System.out.println("You can quit now and keep your "+currentLevel.getRewardBreakout()+" $!");
        System.out.println("Or...");
        System.out.println("You can keep trying to earn the 1.000.000 $!");
        System.out.println("Please enter \"Q\" to quit or \"C\" to continue! ");
    }

    public void doQuitOption(String choice){
        if (choice.equalsIgnoreCase("Q")){
            gameOver();
        }else {
            System.out.println("Great! Let's go on!");
        }
    }

    private void gameOver() {
        System.out.println("Game Over!!!");
        System.out.println("You have won "+currentLevel.getRewardBreakout()+" $!");
        player.setWrongGuess(true);
    }

    private void gameWon(){
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



