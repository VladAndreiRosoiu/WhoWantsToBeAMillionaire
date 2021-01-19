package ro.jademy.millionaire.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question {
    private final String categoryText;
    private final String questionText;
    private final List<Answer> wrongAnswers;
    private final Answer correctAnswer;
    private final List<Answer> allAnswers;

    public Question(String categoryText, String questionText, List<Answer> wrongAnswers, Answer correctAnswer) {
        this.categoryText = categoryText;
        this.questionText = questionText;
        this.wrongAnswers = wrongAnswers;
        this.correctAnswer = correctAnswer;
        this.allAnswers = shuffleAnswers();
    }

    public String getCategoryText() {
        return categoryText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<Answer> getWrongAnswers() {
        return wrongAnswers;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    private List<Answer> shuffleAnswers() {
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
