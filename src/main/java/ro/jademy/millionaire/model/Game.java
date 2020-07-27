package ro.jademy.millionaire.model;

import ro.jademy.millionaire.data.QuestionList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game{

}

//    ArrayList<Question> entireQuestionList;
//    public Player player;
//    public boolean gameIsRunning;
//    public int earnedAmount;
//    public int questionNumber = 0;
//
//    public Game(ArrayList<Question> entireQuestionList, Player player) {
//        this.entireQuestionList = entireQuestionList;
//        this.player = player;
//    }
//
//    public void printWelcomeMessage() {
//        System.out.println("Welcome!");
//    }
//
//    public void printRules() {
//        System.out.println("Rules are ........");
//        System.out.println("Rules are ........");
//        System.out.println("Rules are ........");
//        System.out.println("Rules are ........");
//    }
//
//    public boolean startGame(String answer) {
//        if (answer.equalsIgnoreCase("yes")) {
//            System.out.println("Let the game begin!");
//            gameIsRunning = true;
//            return true;
//        } else {
//            System.out.println("Come back again when you're ready!");
//            return false;
//        }
//    }
//
//    public List<Question> createRandomQuestionList(int numberOfQuestions, int difficulty) {
//        List<Question> givenDiffRandomQuestion = new ArrayList<>();
//        List<Question> temporaryQuestionList = new ArrayList<>();
//
//        for (Question question : entireQuestionList) {
//            if (question.getDifficultyLevel() == difficulty) {
//                temporaryQuestionList.add(question);
//            }
//        }
//        Random rdm = new Random();
//        for (int i = 0; i < numberOfQuestions; i++) {
//            int randomIndex = rdm.nextInt(temporaryQuestionList.size());
//            givenDiffRandomQuestion.add(temporaryQuestionList.remove(randomIndex));
//        }
//        return givenDiffRandomQuestion;
//    }
//
//    public List<Question> finalQuestionList(List<Question> list1, List<Question> list2, List<Question> list3, List<Question> list4) {
//        List<Question> tempList1 = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
//        List<Question> tempList2 = Stream.concat(list3.stream(), list4.stream()).collect(Collectors.toList());
//        List<Question> finalList = Stream.concat(tempList1.stream(), tempList2.stream()).collect(Collectors.toList());
//        return finalList;
//    }
//
//    public void printQuestion(ArrayList<Question> questionList) {
//        System.out.println(questionList.get(questionNumber).getText());
//    }
//
//    public void printAnswers(ArrayList<Question> questionList) {
//        System.out.println(questionList.get(questionNumber).getAnswer1());
//        System.out.println(questionList.get(questionNumber).getAnswer2());
//        System.out.println(questionList.get(questionNumber).getAnswer3());
//        System.out.println(questionList.get(questionNumber).getAnswer4());
//    }
//
//    public void answeringOptions(String answer, ArrayList<Question> questionList) {
//
//        ArrayList<String> answerList = createAnswerList(questionList);
//
//        if (answer.equalsIgnoreCase("1")) {
//            if (player.isHasFiftyFifty()) {
//                removeTwoRandomAnswers(answerList, questionList);
//                System.out.println("50 % of the answers have been eliminated.");
//                for (String answers : answerList) {
//                    System.out.println(answers);
//                }
//                player.setHasFiftyFifty(false);
//            } else {
//                System.out.println("50% option already used. Please answer:");
//            }
//        }
//    }
//
//    public void removeTwoRandomAnswers(ArrayList<String> answerList, ArrayList<Question> questions) {
//        for (int i = 0; i < answerList.size(); i++) {
//            Random rdm = new Random();
//            int randomIndex = rdm.nextInt(answerList.size());
//
//            if (!answerList.get(i).equalsIgnoreCase(questions.get(questionNumber).getCorrectAnswer())) {
//                answerList.remove(randomIndex);
//            }
//        }
//    }
//
//    public ArrayList<String> createAnswerList(ArrayList<Question> questionList) {
//        ArrayList<String> answerList = new ArrayList<>();
//        answerList.add(questionList.get(questionNumber).getAnswer1());
//        answerList.add(questionList.get(questionNumber).getAnswer2());
//        answerList.add(questionList.get(questionNumber).getAnswer3());
//        answerList.add(questionList.get(questionNumber).getAnswer4());
//        return answerList;
//    }
//
//    public void validateAnswer(String answer, ArrayList<Question> questionList) {
//        if (answer.equalsIgnoreCase(questionList.get(questionNumber).getCorrectAnswer())) {
//            System.out.println("Correct Answer!");
//            continueGameIfAnswerIsCorrect(questionList);
//        } else {
//            System.out.println("Wrong!");
//            printGameOver();
//            player.setPlayerWrong(true);
//            gameIsRunning = false;
//        }
//    }
//
//    public void continueGameIfAnswerIsCorrect(ArrayList<Question> questionList) {
//        earnedAmount += questionList.get(questionNumber).getValue();
//        setEarnedMoneyAtThreshold();
//        questionNumber++;
//    }
//
//    public void setEarnedMoneyAtThreshold() {
//        if (questionNumber == 4) {
//            player.setGainedMoney(earnedAmount);
//        } else if (questionNumber == 9) {
//            player.setGainedMoney(earnedAmount);
//        } else if (questionNumber == 13) {
//            player.setGainedMoney(earnedAmount);
//        } else if (questionNumber == 14) {
//            player.setGainedMoney(earnedAmount);
//        }
//    }
//
//    public void printGameOver() {
//        System.out.println("Thank you for playing!");
//        System.out.println("You have earned " + player.getGainedMoney());
//    }
//
//    public void quitingOptionForPlayer(String answer) {
//        if (answer.equalsIgnoreCase("1")) {
//            printGameOver();
//            player.setPlayerWrong(true);
//            gameIsRunning = false;
//        }
//    }


