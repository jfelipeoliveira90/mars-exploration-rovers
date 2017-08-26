package br.com.felipe.marsexplorationrovers.domain.model.navigation;

import br.com.felipe.marsexplorationrovers.domain.model.plateau.Plateau;
import br.com.felipe.marsexplorationrovers.domain.model.probe.Probe;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public final class Navigation implements Serializable {
    private static final long serialVersionUID = -8848923950089576759L;

    private final Plateau plateau;
    private final Probe probe;

    private Navigation(Plateau plateau, Probe probe) {
        this.plateau = plateau;
        this.probe = probe;
    }

    public static Navigation of(Plateau plateau, Probe probe) {
        checkNotNull(plateau, "Planalto invalido");
        checkNotNull(probe, "Sonda invalida");
        checkArgument(probe.getPosition().getCoordinate().compareTo(plateau.getCoordinate()) < 0, "Sonda ultrapassou limite do planalto");

        return new Navigation(plateau, probe);
    }

    public Probe getProbe() {
        return probe;
    }

    public Navigation navigate(List<String> commands) {
        Builder builder = new Builder().from(this);

        commands.forEach(command -> builder.withProbe(builder.probe.changePosition(command)));

        return builder.build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Navigation that = (Navigation) o;
        return Objects.equal(plateau, that.plateau) &&
                Objects.equal(probe, that.probe);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(plateau, probe);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("plateau", plateau)
                          .add("probe", probe)
                          .toString();
    }

    public static class Builder {
        private Plateau plateau;
        private Probe probe;

        public Builder from(Navigation navigation) {
            this.plateau = navigation.plateau;
            this.probe = navigation.probe;

            return this;
        }

        public Builder withPlateau(Plateau plateau) {
            this.plateau = plateau;

            return this;
        }

        public Builder withProbe(Probe probe) {
            this.probe = probe;

            return this;
        }

        public Navigation build() {
            return of(plateau, probe);
        }
    }
}
