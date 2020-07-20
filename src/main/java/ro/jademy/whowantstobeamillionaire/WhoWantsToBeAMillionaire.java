package ro.jademy.whowantstobeamillionaire;

import java.util.ArrayList;
import java.util.Random;

public class WhoWantsToBeAMillionaire {
    ArrayList<Question> questions;
    Player player;
    int earnedAmount;
    int questionNumber = 0;

    public WhoWantsToBeAMillionaire(ArrayList<Question> questions, Player player) {
        this.questions = questions;
        this.player = player;
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome!");
    }

    public void printRules() {
        System.out.println("Rules are ........");
        System.out.println("Rules are ........");
        System.out.println("Rules are ........");
        System.out.println("Rules are ........");
    }

    public boolean startGame(String answer) {
        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Let the game begin!");
            return true;
        } else {
            System.out.println("Come back again when you're ready!");
            System.out.println("----------------------------------");
            return false;
        }
    }

    public ArrayList<Question> createRandomQuestionList() {
        ArrayList<Question> questionList = new ArrayList<>();
        Random rdm = new Random();
        int number;
        int min;
        int max;
        for (int i = 0; i < 15; i++) {
            if (i < 5) {
                number = rdm.nextInt(9);
                questionList.add(questions.get(number));
            } else if (i > 4 && i < 10) {
                min = 10;
                max = 19;
                number = (int) (Math.random() * (max - min + 1) + min);
                questionList.add(questions.get(number));
            } else if (i > 9 && i < 14) {
                min = 20;
                max = 27;
                number = (int) (Math.random() * (max - min + 1) + min);
                questionList.add(questions.get(number));
            } else if (i == 14) {
                min = 28;
                max = 29;
                number = (int) (Math.random() * (max - min + 1) + min);
                questionList.add(questions.get(number));
            }
        }
        return questionList;
    }

    public void printQuestion(ArrayList<Question> questionList) {
        System.out.println(questionList.get(questionNumber).getQuestion());
    }

    public void printAnswers(ArrayList<Question> questionList) {
        System.out.println(questionList.get(questionNumber).getAnswer1());
        System.out.println(questionList.get(questionNumber).getAnswer2());
        System.out.println(questionList.get(questionNumber).getAnswer3());
        System.out.println(questionList.get(questionNumber).getAnswer4());
    }

    public void answeringOptions(String answer, ArrayList<Question> questionList) {

        ArrayList<String> answerList = createAnswerList(questionList);

        if (answer.equalsIgnoreCase("1")) {
            if (player.isHasFiftyFifty()) {
                removeTwoRandomAnswers(answerList, questionList);
                System.out.println("50 % of the answers have been eliminated.");
                for (String answers : answerList) {
                    System.out.println(answers);
                }
                player.setHasFiftyFifty(false);
            } else {
                System.out.println("50% option already used. Please answer:");
            }
        }
    }

    public void removeTwoRandomAnswers(ArrayList<String> answerList, ArrayList<Question> questionList) {
        for (int i = 0; i < 2; i++) {
            Random rdm = new Random();
            int randomAnswerToRemove = rdm.nextInt(3);
            if (!answerList.get(randomAnswerToRemove).equalsIgnoreCase
                    (questionList.get(questionNumber).getCorrectAnswer())) {
                answerList.remove(randomAnswerToRemove);
            }
        }
    }

    public ArrayList<String> createAnswerList(ArrayList<Question> questionList) {
        ArrayList<String> answerList = new ArrayList<>();
        answerList.add(questionList.get(questionNumber).getAnswer1());
        answerList.add(questionList.get(questionNumber).getAnswer2());
        answerList.add(questionList.get(questionNumber).getAnswer3());
        answerList.add(questionList.get(questionNumber).getAnswer4());
        return answerList;
    }

    public void validateAnswer(String answer, ArrayList<Question> questionList) {
        if (answer.equalsIgnoreCase(questionList.get(questionNumber).getCorrectAnswer())) {
            System.out.println("Correct Answer!");
            continueGameIfAnswerIsCorrect(questionList);
        } else {
            System.out.println("Wrong!");
            printGameOver();
            player.setPlayerWrong(true);
        }
    }

    public void continueGameIfAnswerIsCorrect(ArrayList<Question> questionList) {
        earnedAmount += questionList.get(questionNumber).getValue();
        setEarnedMoneyAtThreshold();
        questionNumber++;
    }

    public void setEarnedMoneyAtThreshold() {
        if (questionNumber == 4) {
            player.setGainedMoney(earnedAmount);
        } else if (questionNumber == 9) {
            player.setGainedMoney(earnedAmount);
        } else if (questionNumber == 13) {
            player.setGainedMoney(earnedAmount);
        } else if (questionNumber == 14) {
            player.setGainedMoney(earnedAmount);
        }
    }

    public void printGameOver(){
        System.out.println("Thank you for playing!");
        System.out.println("You have earned " + player.getGainedMoney());
    }

    public void quitingOptionForPlayer(String answer){
            if (answer.equalsIgnoreCase("1")){
                printGameOver();
                player.setPlayerWrong(true);
            }
    }

}
