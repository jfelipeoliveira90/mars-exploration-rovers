package br.com.felipe.marsexplorationrovers.domain.model.probe;

import br.com.felipe.marsexplorationrovers.domain.shared.Coordinate;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkNotNull;

public final class Position implements Serializable {
    private static final long serialVersionUID = 4682093957692461505L;

    private final Coordinate coordinate;
    private final CardinalPoint cardinalPoint;

    private Position(Coordinate coordinate, CardinalPoint cardinalPoint) {
        this.coordinate = coordinate;
        this.cardinalPoint = cardinalPoint;
    }

    public static Position of(Coordinate coordinate, CardinalPoint cardinalPoint) {
        checkNotNull(coordinate, "Coordenada invalida");
        checkNotNull(cardinalPoint, "Ponto cardeal invalido");

        return new Position(coordinate, cardinalPoint);
    }

    public Position withCardinalPoint(CardinalPoint cardinalPoint) {
        return of(this.coordinate, cardinalPoint);
    }

    public Position withCoordinate(Coordinate coordinate) {
        return of(coordinate, this.cardinalPoint);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public CardinalPoint getCardinalPoint() {
        return cardinalPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equal(coordinate, position.coordinate) &&
                cardinalPoint == position.cardinalPoint;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coordinate, cardinalPoint);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("coordinate", coordinate)
                          .add("cardinalPoint", cardinalPoint)
                          .toString();
    }
}
