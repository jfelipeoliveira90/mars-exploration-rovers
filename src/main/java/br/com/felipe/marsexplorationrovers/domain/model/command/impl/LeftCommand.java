package br.com.felipe.marsexplorationrovers.domain.model.command.impl;

import br.com.felipe.marsexplorationrovers.domain.exceptions.CardinalPointException;
import br.com.felipe.marsexplorationrovers.domain.model.command.Command;
import br.com.felipe.marsexplorationrovers.domain.model.probe.Position;

import static br.com.felipe.marsexplorationrovers.domain.model.probe.CardinalPoint.EAST;
import static br.com.felipe.marsexplorationrovers.domain.model.probe.CardinalPoint.NORTH;
import static br.com.felipe.marsexplorationrovers.domain.model.probe.CardinalPoint.SOUTH;
import static br.com.felipe.marsexplorationrovers.domain.model.probe.CardinalPoint.WEST;

public final class LeftCommand implements Command {

    @Override
    public Position execute(Position position) {
        switch (position.getCardinalPoint()) {
            case NORTH:
                return position.withCardinalPoint(WEST);
            case EAST:
                return position.withCardinalPoint(SOUTH);
            case SOUTH:
                return position.withCardinalPoint(EAST);
            case WEST:
                return position.withCardinalPoint(NORTH);
            default:
                throw new CardinalPointException("Ponto cardeal nao implementado");
        }
    }
}
