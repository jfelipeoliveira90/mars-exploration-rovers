package br.com.felipe.marsexplorationrovers.domain.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ResponseStatus(value = BAD_REQUEST)
public class CommandException extends RuntimeException {

    public CommandException(String message) {
        super(message);
    }
}
