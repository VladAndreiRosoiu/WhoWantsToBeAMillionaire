package ro.jademy.whowantstobeamillionaire;

import java.util.ArrayList;

public class WhoWantsToBeAMillionaire {
    ArrayList<Question> questions;
    Player player;
    int questionNumber=0;

    public WhoWantsToBeAMillionaire(ArrayList<Question> questions, Player player){
        this.questions=questions;
        this.player=player;
    }

    public void printQuestion(){
        System.out.println(questions.get(questionNumber).getQuestion());
    }

    public void printAnswers(){
        System.out.println(questions.get(questionNumber).getAnswer1());
        System.out.println(questions.get(questionNumber).getAnswer2());
        System.out.println(questions.get(questionNumber).getAnswer3());
        System.out.println(questions.get(questionNumber).getAnswer4());
    }

    public void validateAnswer(String answer){
        if (answer.equalsIgnoreCase(questions.get(questionNumber).getCorrectAnswer())){
            System.out.println("Correct Answer!");
            questionNumber++;
        }else {
            System.out.println("Wrong!");
            player.setPlayerWrong(true);
        }
    }

}
