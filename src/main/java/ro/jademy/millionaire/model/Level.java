package ro.jademy.millionaire.model;

public class Level {

    private int levelNumber;
    private int difficultyLevel;
    private int reward;
    private int rewardBreakout;

    public Level(int levelNumber, int difficultyLevel, int reward,int rewardBreakout){
        this.levelNumber=levelNumber;
        this.difficultyLevel=difficultyLevel;
        this.reward=reward;
        this.rewardBreakout=rewardBreakout;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public int getReward() {
        return reward;
    }

    public int getRewardBreakout() {
        return rewardBreakout;
    }
}
