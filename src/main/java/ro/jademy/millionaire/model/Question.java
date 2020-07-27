package ro.jademy.millionaire.model;

import java.util.List;

public class Question {

    private final String text;
    private final List<Answer> answerList;
    private final Answer correctAnswer;
    private final int difficultyLevel;

    public Question(String text, List<Answer> answerList, Answer correctAnswer, int difficultyLevel) {
        this.text = text;
        this.answerList=answerList;
        this.correctAnswer=correctAnswer;
        this.difficultyLevel=difficultyLevel;

    }

    public String getText() {
        return text;
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

}
