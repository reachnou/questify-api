package edu.mui.cs489.reachnou.questify.constants;

public enum AnswerState {
    CORRECT("CORRECT"), INCORRECT("INCORRECT");

    private final String state;

    AnswerState(String state){
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
