package ro.jademy.millionaire.model;

public class Player {
    private boolean wrongGuess;

    public boolean isWrongGuess(){
        return wrongGuess;
    }

    public void setWrongGuess(boolean isPlayerWrong){
        this.wrongGuess =isPlayerWrong;
    }
}
