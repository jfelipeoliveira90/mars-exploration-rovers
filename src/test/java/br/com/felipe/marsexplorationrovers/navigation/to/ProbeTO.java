package br.com.felipe.marsexplorationrovers.navigation.to;

public class ProbeTO {
    private int x;
    private int y;
    private String direction;

    public ProbeTO(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getDirection() {
        return direction;
    }
}
