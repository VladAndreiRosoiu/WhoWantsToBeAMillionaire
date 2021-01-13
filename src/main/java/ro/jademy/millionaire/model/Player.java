package ro.jademy.millionaire.model;

public class Player {
    private String name;
    private boolean wrongGuess;

    public Player(String name) {
        this.name = name;
        this.wrongGuess=false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWrongGuess() {
        return wrongGuess;
    }

    public void setWrongGuess(boolean isPlayerWrong) {
        this.wrongGuess = isPlayerWrong;
    }
}
