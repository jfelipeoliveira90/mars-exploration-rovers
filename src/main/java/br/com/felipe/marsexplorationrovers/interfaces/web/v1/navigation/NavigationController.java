package br.com.felipe.marsexplorationrovers.interfaces.web.v1.navigation;

import br.com.felipe.marsexplorationrovers.application.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/v1/navigations")
public class NavigationController {

    @Autowired
    private NavigationService service;

    @PostMapping("/navigate")
    public ResponseEntity<List<ProbeRepresetation>> navigate(@RequestBody NavigationRepresetation navigation) {
        return ok(service.navigate(navigation));
    }
}
