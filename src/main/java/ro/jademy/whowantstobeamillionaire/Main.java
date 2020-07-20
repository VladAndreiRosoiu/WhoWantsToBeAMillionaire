package ro.jademy.whowantstobeamillionaire;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //TODO - fix random question list - duplicated questions
        //TODO - fix 50% player option - does not remove 2 answers all the time
        //TODO - fix quit option for player
        //TODO - fix ending game when quiting and starting a new one from the beginning

        WhoWantsToBeAMillionaire becomingAMillionaire = initWhoWantsToBeAMillionaire();

        do {
            playGame(becomingAMillionaire);
        } while (!becomingAMillionaire.player.isPlayerWrong());
    }

    public static void playGame(WhoWantsToBeAMillionaire becomingAMillionaire) {
        String answer, option;
        ArrayList<Question> questionList = becomingAMillionaire.createRandomQuestionList();
        becomingAMillionaire.printWelcomeMessage();
        becomingAMillionaire.printRules();
        System.out.println("Let's start, are you ready? Yes/No:");
        answer = sc.next();
        if (becomingAMillionaire.startGame(answer)) {
            do {
                if (becomingAMillionaire.questionNumber==5||becomingAMillionaire.questionNumber==10||becomingAMillionaire.questionNumber==13){
                    System.out.println("You can't quit now and keep your "+becomingAMillionaire.earnedAmount+ ", or you can continue and try to " +
                            "earn 1.000.000 $!!!");
                    System.out.println("Press 1 to quit and keep your earnings or 2 to continue:");
                    answer=sc.next();
                    becomingAMillionaire.quitingOptionForPlayer(answer);
                }
                becomingAMillionaire.printQuestion(questionList);
                becomingAMillionaire.printAnswers(questionList);
                System.out.println("Please enter 1 for 50% or 2 to continue:");
                option = sc.next();
                becomingAMillionaire.answeringOptions(option, questionList);
                System.out.println("Please enter your answer:");
                sc.skip("\n");
                answer = sc.nextLine();
                becomingAMillionaire.validateAnswer(answer, questionList);
            } while (!becomingAMillionaire.player.isPlayerWrong());
        }
    }

    public static WhoWantsToBeAMillionaire initWhoWantsToBeAMillionaire() {
        Question q1 = new Question("In children’s stories, how many wishes are granted by a genie or fairy?",
                "a)One", "b)Two", "c)Three", "d)Four", "c)Three",
                1, 100);

        Question q2 = new Question("Which of these products is sold by the brands Colgate, Oral-B and Sensodyne?",
                "a)Deodorant", "b)Shampoo", "c)Toothpaste", "d)Sun cream",
                "c)Toothpaste", 1, 100);

        Question q3 = new Question("Which tool was used as a weapon by the Norse god Thor?",
                "a)Pliers", "b)Hammer", "c)Screwdriver", "d)Saw",
                "b)Hammer", 1, 100);

        Question q4 = new Question("What is the name of the classic dessert consisting of sponge cake and " +
                "ice cream covered in meringue?", "a)Baked Rhode Island", "b)Baked Wyoming",
                "c)Baked Connecticut", "d)Baked Alaska", "d)Baked Alaska", 1,
                100);

        Question q5 = new Question("Trigonometry is a branch of which subject?", "a)Biology",
                "b)Economics", "c)Psychology", "d)Mathematics", "d)Mathematics",
                1, 100);

        Question q6 = new Question("Lily Savage was a persona of which TV personality?",
                "a)Paul O'Grady", "b)Barry Humphries", "c)Les Dawson",
                "d)Brendan O'Carroll", "a)Paul O'Grady", 1, 100);

        Question q7 = new Question("Which legal document states a person’s wishes regarding the disposal " +
                "of their property after death?", "a)Will", "b)Would", "c)Shall",
                "d)Should", "a)Will", 1, 100);

        Question q8 = new Question("Which of these phrases refers to a brief success?",
                "a)Flash in the pan", "b)Blaze in the pot", "c)Spark in the tub",
                "d)Flare in the jug", "b)Blaze in the pot", 1, 100);

        Question q9 = new Question("Which of these is a type of hat?", "a)Pork pie",
                "b)Sausage roll", "c)Scotch egg", "d)Potato crisp", "a)Pork pie",
                1, 100);

        Question q10 = new Question("In which sport do two teams pull at the opposite ends of a rope?",
                "a)Basketball", "b)Tug of war", "c)Ice hockey", "d)Polo",
                "b)Tug of war", 1, 100);

        Question q11 = new Question("Where does a cowboy wear chaps?", "a)On his hands)",
                "b)On his head", "c)On his arms", "d)On his legs", "d)On his legs",
                2, 500);

        Question q12 = new Question("In 1581, Sir Francis Drake became mayor of which city?",
                "a)Bristol", "b)Hull", "c)Glasgow", "d)Plymouth",
                "d)Plymouth", 2, 500);

        Question q13 = new Question("Which of these means a speech in a play where a character talks to " +
                "themselves rather than to other characters?", "a)Interlude", "b)Revue",
                "c)Soliloquy", "d)Chorus", "c)Soliloquy", 2, 500);

        Question q14 = new Question("Which of these is a religious event celebrated in Hinduism?",
                "a)Diwali", "b)Ramadan", "c)Hanukkah", "d)Whitsun",
                "a)Diwali", 2, 500);

        Question q15 = new Question("British athlete Katarina Johnson-Thompson became a world champion in which" +
                " athletics event in 2019?", "a)Heptathlon", "b)Marathon", "c)100 metres",
                "d)400 meters hurdles", "a)Heptathlon", 2, 500);

        Question q16 = new Question("Which iconic horror film involves a couple whose newborn child is replaced" +
                " at birth with the Antichrist?", "a)The Shining", "b)Don't Look Now",
                "c)The Exorcist", "d)The Omen", "d)The Omen", 2, 500);


        Question q17 = new Question("The Walrus And The Carpenter is a well-known verse in which children’s novel?",
                "a)Through The Looking Glass", "b)Swallows And Amazons",
                "c)The Hobbit", "d)Stig Of The Dump", "a)Through The Looking Glass",
                2, 500);

        Question q18 = new Question("Which of these have to pass a test on ‘The Knowledge’ to get a licence?",
                "a)Taxi drivers", "b)Police officers", "c)Bus Drivers",
                "d)Ambulance drivers", "b)Police officers", 2, 500);

        Question q19 = new Question("In 2001, Donald Campbell’s Bluebird was recovered from which lake?",
                "a)Kleder Water", "b)Bala Lake", "c)Coniston Water",
                "d)Lake Windermere", "c)Coniston Water", 2, 500);

        Question q20 = new Question("In Welsh, what does 'afon' mean?", "a)Lake",
                "b)Meadow", "c)Pool", "d)River", "d)River", 2, 500);

        Question q21 = new Question("Which king wrote a famous denunciation of smoking?", "a)William I",
                "b)Richard I", "c)George I", "d)James I", "d)James I", 3,
                100000);

        Question q22 = new Question("The young of which creature is known as a squab?", "a)Octopus",
                "b)Salmon", "c)Horse", "d)Pigeon", "a)Octopus", 3,
                100000);

        Question q23 = new Question("Who is the patron saint of Spain?", "a)St. James",
                "b)St. John", "c)St. Benedict", "d)St. Peter", "a)St. James",
                3, 100000);

        Question q24 = new Question("In the opera by Rossini, what is the first name of The Barber of Seville?",
                "a)Tamino", "b)Alfred", "c)Don Carlos", "d)Figaro", "d)Figaro",
                3, 100000);

        Question q25 = new Question("Which of these books is believed to have been inspired by the real-life " +
                "experiences of the Scottish sailor Alexander Selkirk?", "a)Moby Dick",
                "b)Robinson Crusoe", "c)Treasure Island", "d)The Count Of Monte Cristo",
                "b)Robinson Crusoe", 3, 100000);

        Question q26 = new Question("Which toxic substance is obtained from the pressed seeds of the castor " +
                "oil plant?", "a)Sarin", "b)Strychnine", "c)Ricin", "d)Cyanide",
                "c)Ricin", 3, 100000);

        Question q27 = new Question("The Twelve Apostles is a series of peaks connected to which mountain?",
                "a)Aoraki Mount Cook", "b)K2", "c)Table Mountain", "d)Mont Blanc",
                "c)Table Mountain", 3, 100000);

        Question q28 = new Question("First performed in 1804, Beethoven's Eroica Symphony was originally " +
                "dedicated to which historical figure?", "a)Marie Antoinette", "b)Napoleon Bonaparte",
                "c)Louis XVIII of France", "d)Voltaire", "b)Napoleon Bonaparte",
                3, 100000);

        Question q29 = new Question("Which of these is not one of the American Triple Crown horse races?",
                "a)Preakness Stakes", "b)Belmont Stakes", "c)Kentucky Derby",
                "d)Arlington Million", "d)Arlington Million", 4, 597000);

        Question q30 = new Question("In the history of motor sport, which of these iconic races was held first?",
                "a)Le Mans 24 Hours", "b)Monaco Grand Prix", "c)Indy 500",
                "d)Isle of Man TT", "d)Isle of Man TT", 4, 597000);

        ArrayList<Question> entireQuestionList = new ArrayList<>();
        entireQuestionList.add(q1);
        entireQuestionList.add(q2);
        entireQuestionList.add(q3);
        entireQuestionList.add(q4);
        entireQuestionList.add(q5);
        entireQuestionList.add(q6);
        entireQuestionList.add(q7);
        entireQuestionList.add(q8);
        entireQuestionList.add(q9);
        entireQuestionList.add(q10);
        entireQuestionList.add(q11);
        entireQuestionList.add(q12);
        entireQuestionList.add(q13);
        entireQuestionList.add(q14);
        entireQuestionList.add(q15);
        entireQuestionList.add(q16);
        entireQuestionList.add(q17);
        entireQuestionList.add(q18);
        entireQuestionList.add(q19);
        entireQuestionList.add(q20);
        entireQuestionList.add(q21);
        entireQuestionList.add(q22);
        entireQuestionList.add(q23);
        entireQuestionList.add(q24);
        entireQuestionList.add(q25);
        entireQuestionList.add(q26);
        entireQuestionList.add(q27);
        entireQuestionList.add(q28);
        entireQuestionList.add(q29);
        entireQuestionList.add(q30);

        Player player = new Player();

        return new WhoWantsToBeAMillionaire(entireQuestionList, player);
    }
}
