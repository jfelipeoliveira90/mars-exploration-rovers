package br.com.felipe.marsexplorationrovers.domain.model.probe;

public enum CardinalPoint {

    NORTH("N") {
        @Override
        public CardinalPoint left() {
            return WEST;
        }

        @Override
        public CardinalPoint right() {
            return EAST;
        }
    },

    SOUTH("S") {
        @Override
        public CardinalPoint left() {
            return EAST;
        }

        @Override
        public CardinalPoint right() {
            return WEST;
        }
    },

    EAST("E") {
        @Override
        public CardinalPoint left() {
            return NORTH;
        }

        @Override
        public CardinalPoint right() {
            return SOUTH;
        }
    },

    WEST("W") {
        @Override
        public CardinalPoint left() {
            return SOUTH;
        }

        @Override
        public CardinalPoint right() {
            return NORTH;
        }
    };

    private final String abbreviation;

    CardinalPoint(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public abstract CardinalPoint left();

    public abstract CardinalPoint right();

    public String abbreviation() {
        return abbreviation;
    }
}
