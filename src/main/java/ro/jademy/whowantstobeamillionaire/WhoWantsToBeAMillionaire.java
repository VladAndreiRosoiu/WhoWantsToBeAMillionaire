package ro.jademy.whowantstobeamillionaire;

import java.util.ArrayList;

public class WhoWantsToBeAMillionaire {
    ArrayList<Question> questions;
    Player player;

    public WhoWantsToBeAMillionaire(ArrayList<Question> questions, Player player){
        this.questions=questions;
        this.player=player;
    }

    public void welcomeMessage(){
        System.out.println("Welcome to the greatest game in history!");
        System.out.println("Who Wants To Be a Millionaire?!");
        System.out.println("Rules here ..... ...... ...... ..");
    }

    public boolean gameOn(){
        return player.getTries()==1;
    }

}
