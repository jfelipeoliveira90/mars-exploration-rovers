package br.com.felipe.marsexplorationrovers.domain.model.command;

import br.com.felipe.marsexplorationrovers.domain.model.probe.Position;

public interface Command {

    String LEFT = "L";
    String RIGHT = "R";
    String MOVE = "M";

    Position execute(Position position);
}
