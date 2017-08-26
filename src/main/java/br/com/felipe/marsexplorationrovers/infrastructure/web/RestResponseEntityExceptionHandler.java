package br.com.felipe.marsexplorationrovers.infrastructure.web;

import br.com.felipe.marsexplorationrovers.domain.exceptions.CardinalPointException;
import br.com.felipe.marsexplorationrovers.domain.exceptions.CommandException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            IllegalArgumentException.class,
            NullPointerException.class,
            CardinalPointException.class,
            CommandException.class
    })
    protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode message = mapper.createObjectNode();
        message.put("message", ex.getMessage());

        return handleExceptionInternal(ex, message, new HttpHeaders(), BAD_REQUEST, request);
    }
}
