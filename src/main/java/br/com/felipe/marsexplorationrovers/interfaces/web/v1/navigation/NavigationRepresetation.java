package br.com.felipe.marsexplorationrovers.interfaces.web.v1.navigation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public final class NavigationRepresetation {

    @JsonProperty("plateau")
    private PlateauRepresetation plateauRepresetation;

    @JsonProperty("probes")
    private List<ProbeRepresetation> probesRepresetations;

    @JsonIgnore
    public PlateauRepresetation getPlateauRepresetation() {
        return plateauRepresetation;
    }

    @JsonIgnore
    public List<ProbeRepresetation> getProbesRepresetations() {
        return probesRepresetations;
    }
}
