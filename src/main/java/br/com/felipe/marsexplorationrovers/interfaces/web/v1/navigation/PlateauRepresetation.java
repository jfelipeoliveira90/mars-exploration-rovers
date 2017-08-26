package br.com.felipe.marsexplorationrovers.interfaces.web.v1.navigation;

import br.com.felipe.marsexplorationrovers.domain.model.plateau.Plateau;
import br.com.felipe.marsexplorationrovers.domain.shared.Coordinate;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public final class PlateauRepresetation {

    private int x;
    private int y;

    public Plateau toPlateau() {
        return Plateau.of(Coordinate.of(x, y));
    }
}
