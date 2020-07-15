package ro.jademy.whowantstobeamillionaire;

public class Player {

    //private String fullName;
    private int gainedMoney=0;
    private int tries=1;
    private boolean hasFiftyFifty=true;

//    //public Player(String fullName){
//        //this.fullName=fullName;
//    }

//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }

    public int getGainedMoney() {
        return gainedMoney;
    }

    public void setGainedMoney(int gainedMoney) {
        this.gainedMoney = gainedMoney;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public boolean isHasFiftyFifty() {
        return hasFiftyFifty;
    }

    public void setHasFiftyFifty(boolean hasFiftyFifty) {
        this.hasFiftyFifty = hasFiftyFifty;
    }
}
