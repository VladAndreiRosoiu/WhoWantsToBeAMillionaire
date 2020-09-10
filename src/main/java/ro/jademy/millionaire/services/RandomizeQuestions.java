package ro.jademy.millionaire.services;

import ro.jademy.millionaire.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomizeQuestions {
    public static List<Question> getRandomQuestions(int nrOfQuestions, List<Question> questionList) {
        List<Question> questionOfGivenDiff = new ArrayList<>(questionList);
        List<Question> randomQuestions = new ArrayList<>();
        Random rdm = new Random();
        for (int i = 0; i < nrOfQuestions; i++) {
            int randomIndex = rdm.nextInt(questionOfGivenDiff.size());
            randomQuestions.add(questionOfGivenDiff.remove(randomIndex));
        }
        return randomQuestions;
    }
}
