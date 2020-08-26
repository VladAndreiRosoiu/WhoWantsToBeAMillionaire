package ro.jademy.millionaire.model;

import java.util.List;

public class Question {
    private final String text;
    private final List<Answer> wrongAnswerList;
    private final Answer correctAnswer;

    public Question(String text, List<Answer> wrongAnswerList, Answer correctAnswer) {
        this.text = text;
        this.wrongAnswerList = wrongAnswerList;
        this.correctAnswer = correctAnswer;
    }

    public String getText() {
        return text;
    }

    public List<Answer> getWrongAnswerList() {
        return wrongAnswerList;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

}
