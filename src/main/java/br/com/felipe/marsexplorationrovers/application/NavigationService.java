package br.com.felipe.marsexplorationrovers.application;

import br.com.felipe.marsexplorationrovers.interfaces.web.v1.navigation.NavigationRepresetation;
import br.com.felipe.marsexplorationrovers.interfaces.web.v1.navigation.ProbeRepresetation;

import java.util.List;

public interface NavigationService {

    List<ProbeRepresetation> navigate(NavigationRepresetation navigation);
}
