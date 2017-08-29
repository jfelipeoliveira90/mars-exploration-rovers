package br.com.felipe.marsexplorationrovers.navigation.stage;

import br.com.felipe.marsexplorationrovers.domain.model.plateau.Plateau;
import br.com.felipe.marsexplorationrovers.domain.model.probe.CardinalPoint;
import br.com.felipe.marsexplorationrovers.domain.model.probe.Position;
import br.com.felipe.marsexplorationrovers.domain.model.probe.Probe;
import br.com.felipe.marsexplorationrovers.domain.shared.Coordinate;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ScenarioState;

import java.util.List;

public class GivenStage extends Stage<GivenStage> {

    @ScenarioState
    private Plateau plateau;

    @ScenarioState
    private Probe probe;

    @ScenarioState
    private List<String> commands;

    @ScenarioState
    private RuntimeException exception;

    public GivenStage coordinates_of_plateau(int x, int y) {
        try {
            plateau = Plateau.of(Coordinate.of(x, y));
        } catch (NullPointerException | IllegalArgumentException e) {
            exception = e;
        }

        return this;
    }

    public GivenStage initial_position_of_probe(int x, int y, String direction) {
        try {
            probe = Probe.of(Position.of(Coordinate.of(x, y), CardinalPoint.valueOf(direction)));
        } catch (NullPointerException | IllegalArgumentException e) {
            exception = e;
        }

        return this;
    }

    public GivenStage list_of_commands(List<String> commands) {
        this.commands = commands;
        return this;
    }
}
