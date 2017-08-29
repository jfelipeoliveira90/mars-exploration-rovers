package br.com.felipe.marsexplorationrovers.navigation;

import br.com.felipe.marsexplorationrovers.domain.model.navigation.Navigation;
import br.com.felipe.marsexplorationrovers.domain.model.plateau.Plateau;
import br.com.felipe.marsexplorationrovers.domain.model.probe.Probe;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioState;

import java.util.List;

public class WhenStage extends Stage<WhenStage> {

    @ScenarioState
    private Navigation navigation;

    @ExpectedScenarioState
    private Plateau plateau;

    @ExpectedScenarioState
    private Probe probe;

    @ExpectedScenarioState
    private List<String> commands;

    public WhenStage send_instruction_for_probe() {
        navigation = Navigation.of(plateau, probe)
                               .navigate(commands);
        return this;
    }
}
