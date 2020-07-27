package ro.jademy.millionaire.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

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
            new Level(15, 4, 1000000, 500000)
    );

    private List<Question> difficultyOneQuestions = new ArrayList<>();
    private List<Question> difficultyTwoQuestions = new ArrayList<>();
    private List<Question> difficultyThreeQuestions = new ArrayList<>();
    private List<Question> difficultyFourQuestions = new ArrayList<>();

    private List<Lifeline> lifelines=new ArrayList<>();
    private Level currentLevel=LEVEL_LIST.get(0);

    public Game(List<Question>difficultyOneQuestions,List<Question>difficultyTwoQuestions,
                List<Question>difficultyThreeQuestionsQuestions,List<Question>difficultyFourQuestions){
        this.difficultyOneQuestions=difficultyOneQuestions;
        this.difficultyTwoQuestions=difficultyTwoQuestions;
        this.difficultyThreeQuestions=difficultyThreeQuestionsQuestions;
        this.difficultyFourQuestions=difficultyFourQuestions;

        lifelines.add(new Lifeline("50%"));
        lifelines.add(new Lifeline("50%"));
        lifelines.add(new Lifeline("50%"));
    }

    public void playGame(){
        printWelcome();
        printRules();
    }

    private void printWelcome(){
        System.out.println("Welcome to .......");
        System.out.println("Welcome to .......");
        System.out.println("Welcome to .......");
    }

    private void printRules(){
        System.out.println("Rules are .....");
        System.out.println("Rules are .....");
        System.out.println("Rules are .....");
    }

    private void showQuestion(){
        Question question;
        List<Answer> allAnswers;

        switch (currentLevel.getDifficultyLevel()){
            case 1:
                question=difficultyOneQuestions.get(0);
                allAnswers=getAnswerList(question);
                break;
            case 2:
                question=difficultyTwoQuestions.get(0);
                allAnswers=getAnswerList(question);
                break;
            case 3:
                question=difficultyThreeQuestions.get(0);
                allAnswers=getAnswerList(question);
                break;
            case 4:
                question=difficultyFourQuestions.get(0);
                allAnswers=getAnswerList(question);
                break;
            default:
                System.out.println("Error!");
                break;
        }
    }

    private List<Answer> getAnswerList(Question question) {
        List<Answer> allAnswers=new ArrayList<>();

        return allAnswers;
    }
}



