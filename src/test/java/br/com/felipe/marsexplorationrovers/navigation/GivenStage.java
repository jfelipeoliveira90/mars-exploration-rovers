package br.com.felipe.marsexplorationrovers.navigation;

import com.tngtech.jgiven.Stage;

public class GivenStage extends Stage<GivenStage> {

    public GivenStage coordinates_of_plateu(int x, int y) {
        return self();
    }

    public GivenStage initial_position_of_probe(int x, int y, String direction) {
        return self();
    }

    public GivenStage list_of_commands(String... commands) {
        return self();
    }
}
