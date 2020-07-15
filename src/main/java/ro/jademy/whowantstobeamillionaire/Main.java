package ro.jademy.whowantstobeamillionaire;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        WhoWantsToBeAMillionaire becomingAMillionaire = initWhoWantsToBeAMillionaire();

        do {
            playGame(becomingAMillionaire);
        } while (becomingAMillionaire.gameOn());

    }

    public static void playGame(WhoWantsToBeAMillionaire becomingAMillionaire) {
        becomingAMillionaire.welcomeMessage();
    }

    public static WhoWantsToBeAMillionaire initWhoWantsToBeAMillionaire() {
        Question q1 = new Question("In children’s stories, how many wishes are granted by a genie or fairy?",
                "c)Three", "a)One", "b)Two", "c)Four", 1);

        Question q2 = new Question("Which legal document states a person’s wishes regarding the disposal " +
                "of their property after death?", "c)Will", "a)Would", "b)Shall",
                "c)Should", 1);

        Question q3 = new Question("Which of these phrases refers to a brief success?",
                "c)Flash in the pan", "a)Blaze in the pot", "b)Spark in the tub",
                "c)Flare in the jug", 1);

        Question q4 = new Question("Which of these is a type of hat?", "c)Pork pie",
                "a)Sausage roll", "b)Scotch egg", "c)Potato crisp", 1);

        Question q5 = new Question("In which sport do two teams pull at the opposite ends of a rope?",
                "c)Tug of war", "a)Basketball", "b)Ice hockey",
                "c)Polo", 1);

        Question q6 = new Question("Where does a cowboy wear chaps?", "c)On his legs",
                "a)On his head", "b)On his arms", "c)On his hands", 2);

        Question q7 = new Question("In 1581, Sir Francis Drake became mayor of which city?",
                "c)Plymouth", "a)Hull", "b)Glasgow", "c)Bristol",
                2);

        Question q8 = new Question("The Walrus And The Carpenter is a well-known verse in which children’s novel?",
                "c)Though The Looking Glass", "a)Swallows And Amazons",
                "b)The Hobbit", "c)Stig Of The Dump", 2);

        Question q9 = new Question("Which of these have to pass a test on ‘The Knowledge’ to get a licence?",
                "c)Police officers", "a)Taxi drivers", "b)Bus Drivers",
                "c)Ambulance drivers", 2);

        Question q10 = new Question("In 2001, Donald Campbell’s Bluebird was recovered from which lake?",
                "c)Coniston Water", "a)Bala Lake", "b)Kleder Water",
                "c)Lake Windermere", 2);

        Question q11 = new Question("In Welsh, what does 'afon' mean?", "c)River",
                "a)Meadow", "b)Pool", "c)River", 3);

        Question q12 = new Question("Which king wrote a famous denunciation of smoking?",
                "c)James I", "a)Richard I", "b)George I",
                "c)William I", 3);

        Question q13 = new Question("The young of which creature is known as a squab?", "c)Octopus",
                "a)Salmon", "b)Horse", "c)Pigeon", 3);

        Question q14 = new Question("Who is the patron saint of Spain?", "c)St. James",
                "a)St. John", "b)St. Benedict", "c)St. Peter", 3);

        Question q15 = new Question("Which of these is not one of the American Triple Crown horse races?",
                "c)Arlington Million", "a)Belmont Stakes", "b)Kentucky Derby",
                "c)Preakness Stakes", 3);

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
