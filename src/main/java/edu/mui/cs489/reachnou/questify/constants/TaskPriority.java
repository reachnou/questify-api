package edu.mui.cs489.reachnou.questify.constants;

public enum TaskPriority {
    HIGH("HIGH"), MEDIUM("MEDIUM"), LOW("LOW");

    private final String priority;

    TaskPriority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }
}
