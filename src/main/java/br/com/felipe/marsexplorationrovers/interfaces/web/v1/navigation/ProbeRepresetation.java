package br.com.felipe.marsexplorationrovers.interfaces.web.v1.navigation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public final class ProbeRepresetation {

    private int x;
    private int y;

    @JsonProperty("cardinal-point")
    private String cardinalPoint;
}
