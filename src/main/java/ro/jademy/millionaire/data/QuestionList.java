package ro.jademy.millionaire.data;

import ro.jademy.millionaire.model.Answer;
import ro.jademy.millionaire.model.Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuestionList {
    public static List<Question> getDiffOneList() {
        Question q1 = new Question("In children’s stories, how many wishes are granted by a genie or fairy?",
                Arrays.asList(new Answer("ONE"), new Answer("TWO"), new Answer("FOUR")),
                new Answer("THREE"));
        Question q2 = new Question("Which of these products is sold by the brands Colgate, Oral-B and Sensodyne?",
                Arrays.asList(new Answer("Deodorant"), new Answer("Shampoo"), new Answer("Sun cream")),
                new Answer("Toothpaste"));
        Question q3 = new Question("Which tool was used as a weapon by the Norse god Thor?",
                Arrays.asList(new Answer("Pliers"), new Answer("Screwdriver"), new Answer("Saw")),
                new Answer("Hammer"));
        Question q4 = new Question("What is the name of the classic dessert consisting of sponge cake and ice cream covered in meringue?",
                Arrays.asList(new Answer("Baked Rhode Island"), new Answer("Baked Wyoming"), new Answer("Baked Connecticut")),
                new Answer("Baked Alaska"));
        Question q5 = new Question("Trigonometry is a branch of which subject?",
                Arrays.asList(new Answer("Biology"), new Answer("Economics"), new Answer("Psychology")),
                new Answer("Mathematics"));
        Question q6 = new Question("Lily Savage was a persona of which TV personality?",
                Arrays.asList(new Answer("Barry Humphries"), new Answer("Les Dawson"), new Answer("Brendan O'Carroll")),
                new Answer("Paul O'Grady"));
        Question q7 = new Question("Which legal document states a person’s wishes regarding the disposal of their property after death?",
                Arrays.asList(new Answer("Would"), new Answer("Shall"), new Answer("Should")),
                new Answer("Will"));
        Question q8 = new Question("Which of these phrases refers to a brief success?",
                Arrays.asList(new Answer("Flash in the pan"), new Answer("Spark in the tub"), new Answer("Flare in the jug")),
                new Answer("Blaze in the pot"));
        Question q9 = new Question("Which of these is a type of hat?",
                Arrays.asList(new Answer("Sausage roll"), new Answer("Scotch egg"), new Answer("Potato crisp")),
                new Answer("Pork pie"));
        Question q10 = new Question("In which sport do two teams pull at the opposite ends of a rope?",
                Arrays.asList(new Answer("Basketball"), new Answer("Ice hockey"), new Answer("Polo")),
                new Answer("Tug of war"));
        List<Question> diffOneList = new ArrayList<>();
        diffOneList.add(q1);
        diffOneList.add(q2);
        diffOneList.add(q3);
        diffOneList.add(q4);
        diffOneList.add(q5);
        diffOneList.add(q6);
        diffOneList.add(q7);
        diffOneList.add(q8);
        diffOneList.add(q9);
        diffOneList.add(q10);
        return getRandomQuestions(5, diffOneList);
    }

    public static List<Question> getDiffTwoList() {
        Question q1 = new Question("Where does a cowboy wear chaps?",
                Arrays.asList(new Answer("On his hands"), new Answer("On his head"), new Answer("On his arms")),
                new Answer("On his legs"));
        Question q2 = new Question("In 1581, Sir Francis Drake became mayor of which city?",
                Arrays.asList(new Answer("Bristol"), new Answer("Hull"), new Answer("Glasgow")),
                new Answer("Plymouth"));
        Question q3 = new Question("Which of these means a speech in a play where a character talks to themselves rather than to other characters?",
                Arrays.asList(new Answer("Interlude"), new Answer("Revue"), new Answer("Chorus")),
                new Answer("Soliloquy"));
        Question q4 = new Question("Which of these is a religious event celebrated in Hinduism?",
                Arrays.asList(new Answer("Ramadan"), new Answer("Hanukkah"), new Answer("Whitsun")),
                new Answer("Diwali"));
        Question q5 = new Question("British athlete Katarina Johnson-Thompson became a world champion in which athletics event in 2019?",
                Arrays.asList(new Answer("Marathon"), new Answer("100 metres"), new Answer("400 meters hurdles")),
                new Answer("Heptathlon"));
        Question q6 = new Question("Which iconic horror film involves a couple whose newborn child is replaced at birth with the Antichrist?",
                Arrays.asList(new Answer("The Shining"), new Answer("Don't Look Now"), new Answer("The Exorcist")),
                new Answer("The Omen"));
        Question q7 = new Question("The Walrus And The Carpenter is a well-known verse in which children’s novel?",
                Arrays.asList(new Answer("Swallows And Amazons"), new Answer("The Hobbit"), new Answer("Stig Of The Dump")),
                new Answer("Through The Looking Glass"));
        Question q8 = new Question("Which of these have to pass a test on ‘The Knowledge’ to get a licence?",
                Arrays.asList(new Answer("Taxi drivers"), new Answer("Bus Drivers"), new Answer("Ambulance drivers")),
                new Answer("Police officers"));
        Question q9 = new Question("In 2001, Donald Campbell’s Bluebird was recovered from which lake?",
                Arrays.asList(new Answer("Kleder Water"), new Answer("Bala Lake"), new Answer("Lake Windermere")),
                new Answer("Coniston Water"));
        Question q10 = new Question("In Welsh, what does 'afon' mean?",
                Arrays.asList(new Answer("Lake"), new Answer("Meadow"), new Answer("Pool")),
                new Answer("River"));
        List<Question> diffTwoList = new ArrayList<>();
        diffTwoList.add(q1);
        diffTwoList.add(q2);
        diffTwoList.add(q3);
        diffTwoList.add(q4);
        diffTwoList.add(q5);
        diffTwoList.add(q6);
        diffTwoList.add(q7);
        diffTwoList.add(q8);
        diffTwoList.add(q9);
        diffTwoList.add(q10);
        return getRandomQuestions(5, diffTwoList);
    }

    public static List<Question> getDiffThreeList() {
        Question q1 = new Question("Which king wrote a famous denunciation of smoking?",
                Arrays.asList(new Answer("William I"), new Answer("Richard I"), new Answer("George I")),
                new Answer("James I"));
        Question q2 = new Question("The young of which creature is known as a squab?",
                Arrays.asList(new Answer("Salmon"), new Answer("Horse"), new Answer("Pigeon")),
                new Answer("Octopus"));
        Question q3 = new Question("Who is the patron saint of Spain?",
                Arrays.asList(new Answer("St. John"), new Answer("St. Benedict"), new Answer("St. Peter")),
                new Answer("St. James"));
        Question q4 = new Question("In the opera by Rossini, what is the first name of The Barber of Seville?",
                Arrays.asList(new Answer("Tamino"), new Answer("Alfred"), new Answer("Don Carlos")),
                new Answer("Figaro"));
        Question q5 = new Question("Which of these books is believed to have been inspired by the real-life experiences of the Scottish sailor Alexander Selkirk?",
                Arrays.asList(new Answer("Moby Dick"), new Answer("Treasure Island"), new Answer("The Count Of Monte Cristo")),
                new Answer("Robinson Crusoe"));
        Question q6 = new Question("Which toxic substance is obtained from the pressed seeds of the castor oil plant?",
                Arrays.asList(new Answer("Sarin"), new Answer("Strychnine"), new Answer("Cyanide")),
                new Answer("Ricin"));
        Question q7 = new Question("The Twelve Apostles is a series of peaks connected to which mountain?",
                Arrays.asList(new Answer("Aoraki Mount Cook"), new Answer("K2"), new Answer("Mont Blanc")),
                new Answer("Table Mountain"));
        Question q8 = new Question("First performed in 1804, Beethoven's Eroica Symphony was originally dedicated to which historical figure?",
                Arrays.asList(new Answer("Marie Antoinette"), new Answer("Louis XVIII of France"), new Answer("Voltaire")),
                new Answer("Napoleon Bonaparte"));
        List<Question> diffThreeList = new ArrayList<>();
        diffThreeList.add(q1);
        diffThreeList.add(q2);
        diffThreeList.add(q3);
        diffThreeList.add(q4);
        diffThreeList.add(q5);
        diffThreeList.add(q6);
        diffThreeList.add(q7);
        diffThreeList.add(q8);
        return getRandomQuestions(4, diffThreeList);
    }

    public static List<Question> getDiffFourList() {
        Question q1 = new Question("Which of these is not one of the American Triple Crown horse races?",
                Arrays.asList(new Answer("Preakness Stakes"), new Answer("Belmont Stakes"), new Answer("Kentucky Derby")),
                new Answer("Arlington Million"));
        Question q2 = new Question("In the history of motor sport, which of these iconic races was held first?",
                Arrays.asList(new Answer("Le Mans 24 Hours"), new Answer("Monaco Grand Prix"), new Answer("Indy 500")),
                new Answer("Isle of Man TT"));
        List<Question> diffFourList = new ArrayList<>();
        diffFourList.add(q1);
        diffFourList.add(q2);
        return getRandomQuestions(1, diffFourList);
    }

    private static List<Question> getRandomQuestions(int nrOfQuestions, List<Question> questionList) {
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
