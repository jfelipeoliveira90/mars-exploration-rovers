package br.com.felipe.marsexplorationrovers.domain.service.impl;

import br.com.felipe.marsexplorationrovers.domain.model.plateau.Plateau;
import br.com.felipe.marsexplorationrovers.domain.model.probe.Probe;
import br.com.felipe.marsexplorationrovers.domain.service.Navigation;
import br.com.felipe.marsexplorationrovers.domain.shared.Command;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NavigationImpl implements Navigation {

    @Override
    public Probe navigate(Plateau plateau, Probe probe, List<Command> commands) {
        commands.forEach(command -> {

        });

        return null;
    }
}
