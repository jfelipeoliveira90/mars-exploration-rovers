package br.com.felipe.marsexplorationrovers.domain.model.probe;

public enum CardinalPoint {
    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    private String abbreviation;

    CardinalPoint(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String abbreviation() {
        return abbreviation;
    }
}
