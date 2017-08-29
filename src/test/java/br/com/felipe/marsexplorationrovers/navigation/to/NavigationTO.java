package br.com.felipe.marsexplorationrovers.navigation.to;

import com.tngtech.jgiven.annotation.Format;

public class NavigationTO {

    @Format(args = "X = %s")
    private int probeX;

    @Format(args = "Y = %s")
    private int probeY;

    @Format(args = "Cardinal Point = %s")
    private String direction;

    public NavigationTO(int probeX, int probeY, String direction) {
        this.probeX = probeX;
        this.probeY = probeY;
        this.direction = direction;
    }

    public int getProbeX() {
        return probeX;
    }

    public int getProbeY() {
        return probeY;
    }

    public String getDirection() {
        return direction;
    }

}
