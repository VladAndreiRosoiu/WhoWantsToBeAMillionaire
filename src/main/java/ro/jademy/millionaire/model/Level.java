package ro.jademy.millionaire.model;

public class Level {

    private final int levelNumber;
    private final int reward;
    private final int rewardBreakout;

    public Level(int levelNumber, int reward, int rewardBreakout) {
        this.levelNumber = levelNumber;
        this.reward = reward;
        this.rewardBreakout = rewardBreakout;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public int getReward() {
        return reward;
    }

    public int getRewardBreakout() {
        return rewardBreakout;
    }
}
