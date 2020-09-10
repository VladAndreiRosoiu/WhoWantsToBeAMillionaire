package ro.jademy.millionaire.services;

import ro.jademy.millionaire.model.Answer;
import ro.jademy.millionaire.model.Question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IOService {
    public static List<Question> readFile(String fileName) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new FileReader(fileName));
        List<Question> questions=new ArrayList<>();
        String line;
        while ((line=bufferedReader.readLine())!=null){
            String[]strings=line.split("#");
            String[] wrongAnswers=strings[1].split("/");
            List<Answer> wrongAnswerList= Arrays.asList(new Answer(wrongAnswers[0]),new Answer(wrongAnswers[1]),new Answer(wrongAnswers[2]));
            Question question=new Question(strings[0],wrongAnswerList,new Answer(strings[2]));
            questions.add(question);
        }

        return questions;
    }
}
