package br.com.felipe.marsexplorationrovers.domain.model.probe;

import br.com.felipe.marsexplorationrovers.domain.exceptions.CommandException;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import java.io.Serializable;
import java.util.Optional;

import static br.com.felipe.marsexplorationrovers.domain.model.command.Commands.getCommandMap;
import static com.google.common.base.Preconditions.checkNotNull;

public final class Probe implements Serializable {
    private static final long serialVersionUID = 4253369952647185350L;

    private final Position position;

    private Probe(Position position) {
        this.position = position;
    }

    public static Probe of(Position position) {
        checkNotNull(position, "Posicao invalida");

        return new Probe(position);
    }

    public Probe changePosition(String command) {
        Position position = Optional.ofNullable(getCommandMap().get(command))
                                    .orElseThrow(() -> new CommandException("Instrucao nao implementada"))
                                    .execute(this.position);

        return of(position);
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Probe probe = (Probe) o;
        return Objects.equal(position, probe.position);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("position", position)
                          .toString();
    }
}
