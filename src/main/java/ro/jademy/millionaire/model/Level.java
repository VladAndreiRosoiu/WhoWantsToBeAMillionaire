package ro.jademy.millionaire.model;

public class Level {

    private int levelNumber;
    private DifficultyLevel difficultyLevel;
    private int reward;
    private int rewardBreakout;

    public Level(int levelNumber, DifficultyLevel difficultyLevel, int reward, int rewardBreakout) {
        this.levelNumber = levelNumber;
        this.difficultyLevel = difficultyLevel;
        this.reward = reward;
        this.rewardBreakout = rewardBreakout;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public int getReward() {
        return reward;
    }

    public int getRewardBreakout() {
        return rewardBreakout;
    }
}
