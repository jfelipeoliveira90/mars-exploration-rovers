package br.com.felipe.marsexplorationrovers.navigation;

import br.com.felipe.marsexplorationrovers.navigation.to.NavigationTO;
import br.com.felipe.marsexplorationrovers.navigation.to.PlateauTO;
import br.com.felipe.marsexplorationrovers.navigation.to.ProbeTO;
import com.tngtech.jgiven.junit.ScenarioTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static java.util.Arrays.asList;

@RunWith(JUnitParamsRunner.class)
public class NavigationTest extends ScenarioTest<GivenStage, WhenStage, ThenStage> {

    @Test
    @Parameters(method = "parameters")
    public void created_successfully(PlateauTO plateauTO, ProbeTO probeTO, List<String> commands, NavigationTO expected) {
        given().coordinates_of_plateau(plateauTO.getX(), plateauTO.getY())
               .and()
               .initial_position_of_probe(probeTO.getX(), probeTO.getY(), probeTO.getDirection())
               .and()
               .list_of_commands(commands);

        when().send_instruction_for_probe();

        then().navigation_created_successfully_$(expected);
    }

    private Object parameters() {
        return new Object[]{
                new Object[]{
                        new PlateauTO(5, 5),
                        new ProbeTO(1, 2, "NORTH"),
                        asList("L", "M", "L", "M", "L", "M", "L", "M", "M"),
                        new NavigationTO(1, 3, "NORTH")
                },
                new Object[]{
                        new PlateauTO(5, 5),
                        new ProbeTO(3, 3, "EAST"),
                        asList("M", "M", "R", "M", "M", "R", "M", "R", "R", "M"),
                        new NavigationTO(5, 1, "EAST")
                }
        };
    }
}
