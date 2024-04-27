package edu.mui.cs489.reachnou.questify.constants;

public enum ChallengeStatus {
    NOT_YET_START("NOT_YET_START"), IN_PROGRESS("IN_PROGRESS"), COMPLETED("COMPLETED");

    private final String status;

    ChallengeStatus(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
