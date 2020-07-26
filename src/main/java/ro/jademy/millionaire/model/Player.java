package ro.jademy.millionaire.model;

public class Player {

    //private String fullName;
    private int gainedMoney=0;
    private boolean isPlayerWrong=false;
    private boolean hasFiftyFifty=true;


    public int getGainedMoney() {
        return gainedMoney;
    }

    public void setGainedMoney(int gainedMoney) {
        this.gainedMoney = gainedMoney;
    }

    public boolean isHasFiftyFifty() {
        return hasFiftyFifty;
    }

    public void setHasFiftyFifty(boolean hasFiftyFifty) {
        this.hasFiftyFifty = hasFiftyFifty;
    }

    public boolean isPlayerWrong(){
        return isPlayerWrong;
    }

    public void setPlayerWrong(boolean isPlayerWrong){
        this.isPlayerWrong=isPlayerWrong;
    }

}
