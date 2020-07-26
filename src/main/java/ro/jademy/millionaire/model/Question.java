package ro.jademy.millionaire.model;

public class Question {

    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String correctAnswer;
    private int difficultyLevel;
    private int value;

    public Question(String question, String answer1, String answer2, String answer3, String answer4,
                    String correctAnswer, int difficultyLevel, int value) {
        this.question = question;
        this.answer1=answer1;
        this.answer2=answer2;
        this.answer3=answer3;
        this.answer4=answer4;
        this.correctAnswer = correctAnswer;
        this.difficultyLevel=difficultyLevel;
        this.value=value;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public int getDifficultyLevel(){
        return difficultyLevel;
    }

    public int getValue() {
        return value;
    }
}
