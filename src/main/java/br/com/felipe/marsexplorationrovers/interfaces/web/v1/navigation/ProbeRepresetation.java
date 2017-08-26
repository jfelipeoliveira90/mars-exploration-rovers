package br.com.felipe.marsexplorationrovers.interfaces.web.v1.navigation;

import br.com.felipe.marsexplorationrovers.domain.model.probe.CardinalPoint;
import br.com.felipe.marsexplorationrovers.domain.model.probe.Position;
import br.com.felipe.marsexplorationrovers.domain.model.probe.Probe;
import br.com.felipe.marsexplorationrovers.domain.shared.Coordinate;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@JsonAutoDetect(fieldVisibility = ANY)
public final class ProbeRepresetation {

    private int x;
    private int y;

    @JsonProperty("cardinal-point")
    private CardinalPointRepresetation cardinalPoint;

    @JsonProperty(access = WRITE_ONLY)
    private List<String> commands;

    private ProbeRepresetation() {
    }

    private ProbeRepresetation(int x, int y, CardinalPointRepresetation cardinalPoint, List<String> commands) {
        this.x = x;
        this.y = y;
        this.cardinalPoint = cardinalPoint;
        this.commands = commands;
    }

    public static ProbeRepresetation from(Probe probe) {
        return new ProbeRepresetation(probe.getPosition().getCoordinate().getX(), probe.getPosition().getCoordinate().getY(),
                CardinalPointRepresetation.valueOf(probe.getPosition().getCardinalPoint().abbreviation()), null);
    }

    @JsonIgnore
    public List<String> getCommands() {
        return commands;
    }

    public Probe toProbe() {
        return Probe.of(Position.of(Coordinate.of(x, y), CardinalPoint.valueOf(cardinalPoint.direction())));
    }
}
