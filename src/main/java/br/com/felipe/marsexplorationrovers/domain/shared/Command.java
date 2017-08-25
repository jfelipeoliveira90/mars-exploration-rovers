package br.com.felipe.marsexplorationrovers.domain.shared;

public enum Command {
    LEFT("L"),
    RIGHT("R"),
    MOVE("V");

    private String value;

    Command(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
