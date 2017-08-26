package br.com.felipe.marsexplorationrovers.interfaces.web.v1.navigation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/navigations")
public class NavigationController {

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody NavigationRepresetation navigation) {
        return ResponseEntity.noContent().build();
    }
}
