package edu.mui.cs489.reachnou.questify.constants;

public enum ChallengeType {
    SOLO("SOLO"), PAIR("PAIR"), GROUP("GROUP");

    private final String type;

    ChallengeType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
