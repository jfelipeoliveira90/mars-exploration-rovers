package br.com.felipe.marsexplorationrovers.navigation;

import br.com.felipe.marsexplorationrovers.navigation.stage.GivenStage;
import br.com.felipe.marsexplorationrovers.navigation.stage.ThenStage;
import br.com.felipe.marsexplorationrovers.navigation.stage.WhenStage;
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
import static java.util.Collections.EMPTY_LIST;

@RunWith(JUnitParamsRunner.class)
public class NavigationTest extends ScenarioTest<GivenStage, WhenStage, ThenStage> {

    @Test
    @Parameters(method = "parametersCreatedSuccessfully")
    public void created_successfully(PlateauTO plateauTO, ProbeTO probeTO, List<String> commands, NavigationTO expected) {
        given().coordinates_of_plateau(plateauTO.getX(), plateauTO.getY())
               .and()
               .initial_position_of_probe(probeTO.getX(), probeTO.getY(), probeTO.getDirection())
               .and()
               .list_of_commands(commands);

        when().send_instruction_for_probe();

        then().navigation_created_successfully_$(expected);
    }

    @Test
    @Parameters(method = "parametersFailedToCreateWithPlateauCoordinatesInvalid")
    public void failed_to_create_with_plateau_coordinates_invalid(PlateauTO plateauTO, ProbeTO probeTO, List<String> commands) {
        scenarioException(plateauTO, probeTO, commands);
    }

    @Test
    @Parameters(method = "parametersFailedToCreateWithProbeCoordinatesInvalid")
    public void failed_to_create_with_probe_coordinates_invalid(PlateauTO plateauTO, ProbeTO probeTO, List<String> commands) {
        scenarioException(plateauTO, probeTO, commands);
    }

    @Test
    @Parameters(method = "parametersFailedToCreateWithProbeCardinalPointInvalid")
    public void failed_to_create_with_probe_cardinal_point_invalid(PlateauTO plateauTO, ProbeTO probeTO, List<String> commands) {
        scenarioException(plateauTO, probeTO, commands);
    }

    @Test
    @Parameters(method = "parametersFailedToCreateWithProbeExceedingPlateauBoundary")
    public void failed_to_create_with_probe_exceeding_plateau_boundary(PlateauTO plateauTO, ProbeTO probeTO, List<String> commands) {
        scenarioException(plateauTO, probeTO, commands);
    }

    private void scenarioException(PlateauTO plateauTO, ProbeTO probeTO, List<String> commands) {
        given().coordinates_of_plateau(plateauTO.getX(), plateauTO.getY())
               .and()
               .initial_position_of_probe(probeTO.getX(), probeTO.getY(), probeTO.getDirection())
               .and()
               .list_of_commands(commands);

        when().send_instruction_for_probe();

        then().an_exception_is_thrown();
    }

    private Object parametersCreatedSuccessfully() {
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
                },
                new Object[]{
                        new PlateauTO(0, 0),
                        new ProbeTO(0, 0, "EAST"),
                        asList("L", "L", "L", "L"),
                        new NavigationTO(0, 0, "EAST")
                },
                new Object[]{
                        new PlateauTO(0, 0),
                        new ProbeTO(0, 0, "EAST"),
                        EMPTY_LIST,
                        new NavigationTO(0, 0, "EAST")
                },
                new Object[]{
                        new PlateauTO(0, 0),
                        new ProbeTO(0, 0, "EAST"),
                        null,
                        new NavigationTO(0, 0, "EAST")
                }
        };
    }

    private Object parametersFailedToCreateWithPlateauCoordinatesInvalid() {
        return new Object[]{
                new Object[]{
                        new PlateauTO(-1, 0),
                        new ProbeTO(1, 2, "NORTH"),
                        asList("L", "M", "L", "M", "L", "M", "L", "M", "M")
                },
                new Object[]{
                        new PlateauTO(5, -5),
                        new ProbeTO(3, 3, "EAST"),
                        asList("M", "M", "R", "M", "M", "R", "M", "R", "R", "M", "M", "M")
                }
        };
    }

    private Object parametersFailedToCreateWithProbeCoordinatesInvalid() {
        return new Object[]{
                new Object[]{
                        new PlateauTO(5, 5),
                        new ProbeTO(-1, 2, "NORTH"),
                        asList("L", "M", "L", "M", "L", "M", "L", "M", "M")
                },
                new Object[]{
                        new PlateauTO(5, 5),
                        new ProbeTO(3, -3, "EAST"),
                        asList("M", "M", "R", "M", "M", "R", "M", "R", "R", "M", "M", "M")
                }
        };
    }

    private Object parametersFailedToCreateWithProbeCardinalPointInvalid() {
        return new Object[]{
                new Object[]{
                        new PlateauTO(5, 5),
                        new ProbeTO(1, 2, null),
                        asList("L", "M", "L", "M", "L", "M", "L", "M", "M")
                },
                new Object[]{
                        new PlateauTO(5, 5),
                        new ProbeTO(3, 3, "XXXX"),
                        asList("M", "M", "R", "M", "M", "R", "M", "R", "R", "M", "M", "M")
                }
        };
    }

    private Object parametersFailedToCreateWithProbeExceedingPlateauBoundary() {
        return new Object[]{
                new Object[]{
                        new PlateauTO(0, 0),
                        new ProbeTO(1, 2, "EAST"),
                        null
                },
                new Object[]{
                        new PlateauTO(5, 5),
                        new ProbeTO(3, 3, "EAST"),
                        asList("M", "M", "M", "M", "M")
                }
        };
    }
}
