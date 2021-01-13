package ro.jademy.millionaire.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    private final String text;
    private final List<Answer> wrongAnswers;
    private final Answer correctAnswer;
    private List<Answer> allAnswers;

    public Question(String text, List<Answer> wrongAnswers, Answer correctAnswer) {
        this.text = text;
        this.wrongAnswers = wrongAnswers;
        this.correctAnswer = correctAnswer;
        this.allAnswers=shuffleAnswers();
    }

    public String getText() {
        return text;
    }

    public List<Answer> getWrongAnswers() {
        return wrongAnswers;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    private List<Answer> shuffleAnswers(){
        List<Answer> shuffledAnswers = new ArrayList<>();
        shuffledAnswers.add(correctAnswer);
        shuffledAnswers.addAll(wrongAnswers);
        Collections.shuffle(wrongAnswers);
        return shuffledAnswers;
    }

    public List<Answer> getAllAnswers() {
        return allAnswers;
    }
}
