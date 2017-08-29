package br.com.felipe.marsexplorationrovers.navigation;

import com.tngtech.jgiven.junit.ScenarioTest;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class NavigationTest extends ScenarioTest<GivenStage, WhenStage, ThenStage> {

    @Test
    @Parameters({
            ""
    })
    public void created_successfully(int plateuX, int plateuY, int probeX, int probeY, String probeDirection, String... commands) {
        given().coordinates_of_plateu(plateuX, plateuY)
               .and()
               .initial_position_of_probe(probeX, probeY, probeDirection)
               .and()
               .list_of_commands(commands);


    }
}
