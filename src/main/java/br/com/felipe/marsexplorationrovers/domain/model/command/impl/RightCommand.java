package br.com.felipe.marsexplorationrovers.domain.model.command.impl;

import br.com.felipe.marsexplorationrovers.domain.model.command.Command;
import br.com.felipe.marsexplorationrovers.domain.model.probe.Position;

public final class RightCommand implements Command {

    @Override
    public Position execute(Position position) {
        return position.withCardinalPoint(position.getCardinalPoint().right());
    }
}
