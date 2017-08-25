package br.com.felipe.marsexplorationrovers.domain.model.plateau;

import br.com.felipe.marsexplorationrovers.domain.shared.Coordinate;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkNotNull;

public final class Plateau implements Serializable {
    private static final long serialVersionUID = 6220792624879239344L;

    private final Coordinate coordinate;

    private Plateau(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public static Plateau of(Coordinate coordinate) {
        checkNotNull(coordinate, "Coordenada nao pode ser nulo");

        return new Plateau(coordinate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plateau plateau = (Plateau) o;
        return Objects.equal(coordinate, plateau.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coordinate);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("coordinate", coordinate)
                          .toString();
    }
}
