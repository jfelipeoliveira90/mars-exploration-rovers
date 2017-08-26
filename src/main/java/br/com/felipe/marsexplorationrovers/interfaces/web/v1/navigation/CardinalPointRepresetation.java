package br.com.felipe.marsexplorationrovers.interfaces.web.v1.navigation;

public enum CardinalPointRepresetation {

    N("NORTH"),
    S("SOUTH"),
    E("EAST"),
    W("WEST");

    private final String direction;

    CardinalPointRepresetation(String direction) {
        this.direction = direction;
    }

    public String direction() {
        return direction;
    }
}
