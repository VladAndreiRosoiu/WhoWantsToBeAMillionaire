package ro.jademy.millionaire.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ro.jademy.millionaire.models.Answer;
import ro.jademy.millionaire.models.Question;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;

public class QuestionsProviderService {
    public String apiResponse(int difficulty) throws IOException {
        String stringURL = "";
        switch (difficulty) {
            case 1:
                stringURL = "https://opentdb.com/api.php?amount=15&difficulty=easy&type=multiple&encode=base64";
                break;
            case 2:
                stringURL = "https://opentdb.com/api.php?amount=15&difficulty=medium&type=multiple&encode=base64";
                break;
            case 3:
                stringURL = "https://opentdb.com/api.php?amount=15&difficulty=hard&type=multiple&encode=base64";
                break;
        }
        URL URL = new URL(stringURL);
        HttpURLConnection connection = (HttpURLConnection) URL.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            Scanner scanner = new Scanner(URL.openStream());
            StringBuilder line = new StringBuilder();
            while (scanner.hasNext()) {
                line.append(scanner.nextLine());
            }
            scanner.close();
            return line.toString();
        }
        return null;
    }

    public List<Question> getQuestions(String apiResponse) throws ParseException {
        List<Question> questions = new ArrayList<>();
        List<Answer> wrongAnswerList = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(apiResponse);
        JSONArray jsonArray = (JSONArray) jsonObject.get("results");
        for (Object object : jsonArray) {
            JSONObject questionObject = (JSONObject) object;
            JSONArray wrongAnswerJsonArray = (JSONArray) questionObject.get("incorrect_answers");
            for (Object answerObject : wrongAnswerJsonArray) {
                byte[] decodedWrongAnswer = Base64.getDecoder().decode((String) answerObject);
                Answer wrongAnswer = new Answer(new String(decodedWrongAnswer));
                wrongAnswerList.add(wrongAnswer);
            }
            byte[] categoryByteArr = Base64.getDecoder().decode((String) questionObject.get("category"));
            String categoryText = new String(categoryByteArr);
            byte[] questionByteArr = Base64.getDecoder().decode((String) questionObject.get("question"));
            String questionText = new String(questionByteArr);
            byte[] correctAnswerByteArr = Base64.getDecoder().decode((String) questionObject.get("correct_answer"));
            Answer correctAnswer = new Answer(new String(correctAnswerByteArr));
            questions.add(new Question(
                    categoryText,
                    questionText,
                    wrongAnswerList,
                    correctAnswer
            ));
            wrongAnswerList.clear();
        }
        return questions;
    }
}
