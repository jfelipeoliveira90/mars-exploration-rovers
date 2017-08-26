package br.com.felipe.marsexplorationrovers.interfaces.web.v1.navigation;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@JsonAutoDetect(fieldVisibility = ANY)
public final class PlateauRepresetation {

    private int x;
    private int y;
}
