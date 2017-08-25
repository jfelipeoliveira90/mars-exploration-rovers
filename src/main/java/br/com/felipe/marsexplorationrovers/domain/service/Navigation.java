package br.com.felipe.marsexplorationrovers.domain.service;

import br.com.felipe.marsexplorationrovers.domain.model.plateau.Plateau;
import br.com.felipe.marsexplorationrovers.domain.model.probe.Probe;
import br.com.felipe.marsexplorationrovers.domain.shared.Command;

import java.util.List;

public interface Navigation {

    Probe navigate(Plateau plateau, Probe probe, List<Command> commands);
}
