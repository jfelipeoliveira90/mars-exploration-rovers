package br.com.felipe.marsexplorationrovers.domain.shared;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkArgument;

public final class Coordinate implements Serializable {
    private static final long serialVersionUID = -5372973857556661162L;

    private final int x;
    private final int y;

    private Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinate of(int x, int y) {
        checkArgument(x > 0, "Valor invalido para a coordenada X");
        checkArgument(y > 0, "Valor invalido para a coordenada Y");

        return new Coordinate(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(x, y);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("x", x)
                          .add("y", y)
                          .toString();
    }
}
