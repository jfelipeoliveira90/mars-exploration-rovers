package br.com.felipe.marsexplorationrovers.application.impl;

import br.com.felipe.marsexplorationrovers.application.NavigationService;
import br.com.felipe.marsexplorationrovers.domain.model.navigation.Navigation;
import br.com.felipe.marsexplorationrovers.domain.model.plateau.Plateau;
import br.com.felipe.marsexplorationrovers.interfaces.web.v1.navigation.NavigationRepresetation;
import br.com.felipe.marsexplorationrovers.interfaces.web.v1.navigation.ProbeRepresetation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NavigationServiceImpl implements NavigationService {

    @Override
    public NavigationRepresetation create(NavigationRepresetation navigationRepresetation) {
        Plateau plateau = navigationRepresetation.getPlateauRepresetation().toPlateau();

        List<ProbeRepresetation> probesRepresetations = navigationRepresetation.getProbesRepresetations()
                                                                               .stream()
                                                                               .map(pr -> Navigation.of(plateau, pr.toProbe()).navigate(pr.getCommands()))
                                                                               .map(Navigation::getProbe)
                                                                               .map(ProbeRepresetation::from)
                                                                               .collect(Collectors.toList());

        return navigationRepresetation.withProbesRepresetations(probesRepresetations);
    }
}
