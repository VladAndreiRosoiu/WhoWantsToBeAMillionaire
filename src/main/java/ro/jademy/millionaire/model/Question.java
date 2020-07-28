package ro.jademy.millionaire.model;

import java.util.List;

public class Question {

    private final String text;
    private final List<Answer> wrongAnswerList;
    private final Answer correctAnswer;
    private final int difficultyLevel;

    public Question(String text, List<Answer> wrongAnswerList, Answer correctAnswer, int difficultyLevel) {
        this.text = text;
        this.wrongAnswerList = wrongAnswerList;
        this.correctAnswer=correctAnswer;
        this.difficultyLevel=difficultyLevel;

    }

    public String getText() {
        return text;
    }

    public List<Answer> getWrongAnswerList(){
        return wrongAnswerList;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public int getDifficultyLevel(){
        return difficultyLevel;
    }

}
