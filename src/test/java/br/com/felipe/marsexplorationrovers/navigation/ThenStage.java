package br.com.felipe.marsexplorationrovers.navigation;

import br.com.felipe.marsexplorationrovers.domain.model.navigation.Navigation;
import br.com.felipe.marsexplorationrovers.domain.model.probe.Position;
import br.com.felipe.marsexplorationrovers.domain.shared.Coordinate;
import br.com.felipe.marsexplorationrovers.navigation.to.NavigationTO;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.POJOFormat;

import static org.junit.Assert.assertEquals;

public class ThenStage extends Stage<ThenStage> {

    @ExpectedScenarioState
    private Navigation navigation;

    public ThenStage navigation_created_successfully_$(@POJOFormat NavigationTO expected) {
        Position position = navigation.getProbe().getPosition();
        Coordinate coordinateProbe = position.getCoordinate();

        assertEquals(expected.getProbeX(), coordinateProbe.getX());
        assertEquals(expected.getProbeY(), coordinateProbe.getY());
        assertEquals(expected.getDirection(), position.getCardinalPoint().name());

        return this;
    }
}
