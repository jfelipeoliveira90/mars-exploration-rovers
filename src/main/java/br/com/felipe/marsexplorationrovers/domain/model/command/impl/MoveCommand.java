package br.com.felipe.marsexplorationrovers.domain.model.command.impl;

import br.com.felipe.marsexplorationrovers.domain.exceptions.CardinalPointException;
import br.com.felipe.marsexplorationrovers.domain.model.command.Command;
import br.com.felipe.marsexplorationrovers.domain.model.probe.Position;
import br.com.felipe.marsexplorationrovers.domain.shared.Coordinate;

public final class MoveCommand implements Command {

    @Override
    public Position execute(Position position) {
        Coordinate coordinate = position.getCoordinate();

        switch (position.getCardinalPoint()) {
            case NORTH:
                return position.withCoordinate(coordinate.plus(0, 1));
            case EAST:
                return position.withCoordinate(coordinate.plus(1, 0));
            case SOUTH:
                return position.withCoordinate(coordinate.less(0, 1));
            case WEST:
                return position.withCoordinate(coordinate.less(1, 0));
            default:
                throw new CardinalPointException("Ponto cardeal nao implementado");
        }
    }
}
