package br.com.felipe.marsexplorationrovers.domain.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(value = BAD_REQUEST)
public class CardinalPointException extends RuntimeException {

    public CardinalPointException(String message) {
        super(message);
    }
}
