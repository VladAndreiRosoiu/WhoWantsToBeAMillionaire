package ro.jademy.whowantstobeamillionaire;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {

        WhoWantsToBeAMillionaire becomingAMillionaire = initWhoWantsToBeAMillionaire();

        do {
            playGame(becomingAMillionaire);
        } while (!becomingAMillionaire.player.isPlayerWrong());

    }

    public static void playGame(WhoWantsToBeAMillionaire becomingAMillionaire) {
        do {
            becomingAMillionaire.printQuestion();
            becomingAMillionaire.printAnswers();
            System.out.println("Please enter answer:");
            String answer=sc.next();
            becomingAMillionaire.validateAnswer(answer);
        }while (!becomingAMillionaire.player.isPlayerWrong());
    }

    public static WhoWantsToBeAMillionaire initWhoWantsToBeAMillionaire() {
        Question q1 = new Question("In children’s stories, how many wishes are granted by a genie or fairy?",
                 "a)One", "b)Two", "c)Three", "d)Four","c");

        Question q2 = new Question("Which legal document states a person’s wishes regarding the disposal " +
                "of their property after death?", "a)Will", "b)Would", "c)Shall",
                "d)Should", "a");

        Question q3 = new Question("Which of these phrases refers to a brief success?",
                "a)Flash in the pan", "b)Blaze in the pot", "c)Spark in the tub",
                "d)Flare in the jug", "b");

        Question q4 = new Question("Which of these is a type of hat?", "a)Pork pie",
                "b)Sausage roll", "c)Scotch egg", "d)Potato crisp", "a");

        Question q5 = new Question("In which sport do two teams pull at the opposite ends of a rope?",
                "a)Basketball", "b)Tug of war", "c)Ice hockey",
                "d)Polo", "b");

        Question q6 = new Question("Where does a cowboy wear chaps?", "a)On his hands)",
                "b)On his head", "c)On his arms", "d)On his legs", "d");

        Question q7 = new Question("In 1581, Sir Francis Drake became mayor of which city?",
                "a)Bristol", "b)Hull", "c)Glasgow", "d)Plymouth",
                "d");

        Question q8 = new Question("The Walrus And The Carpenter is a well-known verse in which children’s novel?",
                "a)Through The Looking Glass", "b)Swallows And Amazons",
                "c)The Hobbit", "d)Stig Of The Dump", "a");

        Question q9 = new Question("Which of these have to pass a test on ‘The Knowledge’ to get a licence?",
                "a)Taxi drivers", "b)Police officers", "c)Bus Drivers",
                "d)Ambulance drivers", "b");

        Question q10 = new Question("In 2001, Donald Campbell’s Bluebird was recovered from which lake?",
                "a)Kleder Water", "b)Bala Lake", "c)Coniston Water",
                "d)Lake Windermere", "c");

        Question q11 = new Question("In Welsh, what does 'afon' mean?", "a)Lake",
                "b)Meadow", "c)Pool", "d)River", "d");

        Question q12 = new Question("Which king wrote a famous denunciation of smoking?",
                "a)William I", "b)Richard I", "c)George I",
                "d)James I", "d");

        Question q13 = new Question("The young of which creature is known as a squab?", "a)Octopus",
                "b)Salmon", "c)Horse", "d)Pigeon", "a");

        Question q14 = new Question("Who is the patron saint of Spain?", "a)St. James",
                "b)St. John", "c)St. Benedict", "d)St. Peter", "a");

        Question q15 = new Question("Which of these is not one of the American Triple Crown horse races?",
                "a)Preakness Stakes", "b)Belmont Stakes", "c)Kentucky Derby",
                "d)Arlington Million", "d");

        ArrayList<Question> questionsList = new ArrayList<>();
        questionsList.add(q1);
        questionsList.add(q2);
        questionsList.add(q3);
        questionsList.add(q4);
        questionsList.add(q5);
        questionsList.add(q6);
        questionsList.add(q7);
        questionsList.add(q8);
        questionsList.add(q9);
        questionsList.add(q10);
        questionsList.add(q11);
        questionsList.add(q12);
        questionsList.add(q13);
        questionsList.add(q14);
        questionsList.add(q15);

        Player player = new Player();

        return new WhoWantsToBeAMillionaire(questionsList, player);
    }
}
