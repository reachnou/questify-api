package edu.mui.cs489.reachnou.questify.constants;

public enum Difficulty {
    EASY("EASY"), MEDIUM("MEDIUM"), HARD("HARD");

    private final String level;

    Difficulty(String level){
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
