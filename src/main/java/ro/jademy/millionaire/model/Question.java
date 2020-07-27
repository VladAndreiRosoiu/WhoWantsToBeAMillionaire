package ro.jademy.millionaire.model;

import java.util.List;

public class Question {

    private String question;
    private List<Answer> answerList;
    private Answer correctAnswer;
    private int difficultyLevel;
    private int value;

    public Question(String question, List<Answer> answerList, Answer correctAnswer, int difficultyLevel, int value) {
        this.question = question;
        this.answerList=answerList;
        this.correctAnswer=correctAnswer;
        this.difficultyLevel=difficultyLevel;
        this.value=value;
    }

    public String getQuestion() {
        return question;
    }

    public List<Answer> getAnswerList(){
        return answerList;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public int getDifficultyLevel(){
        return difficultyLevel;
    }

    public int getValue() {
        return value;
    }
}
