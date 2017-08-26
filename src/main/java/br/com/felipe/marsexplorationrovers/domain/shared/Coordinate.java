package br.com.felipe.marsexplorationrovers.domain.shared;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;

import static com.google.common.base.Preconditions.checkArgument;

public final class Coordinate implements Serializable, Comparable<Coordinate> {
    private static final long serialVersionUID = -5372973857556661162L;

    private final int x;
    private final int y;

    private Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinate of(int x, int y) {
        checkArgument(x >= 0, "Valor invalido para a eixo X");
        checkArgument(y >= 0, "Valor invalido para a eixo Y");

        return new Coordinate(x, y);
    }

    public Coordinate plus(int x, int y) {
        return of(this.x + x, this.y + y);
    }

    public Coordinate less(int x, int y) {
        return of(this.x - x, this.y - y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
    public int compareTo(Coordinate that) {
        if (that == null) {
            return 1;
        }

        final int xcomp = Double.compare(this.x, that.x);
        return xcomp == 0 ? Double.compare(this.y, that.y) : xcomp;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("x", x)
                          .add("y", y)
                          .toString();
    }
}
