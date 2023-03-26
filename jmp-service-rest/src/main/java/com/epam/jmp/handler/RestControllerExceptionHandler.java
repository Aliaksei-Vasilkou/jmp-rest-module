package com.epam.jmp.handler;

import com.epam.jmp.exception.ResourceNotFoundException;
import com.epam.jmp.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerExceptionHandler {

    private static final String APPLICATION_SOURCE = "jmp-application";

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ErrorResponse errorResponse = buildErrorResponse("RESOURCE_NOT_FOUND", exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    private ErrorResponse buildErrorResponse(String code, String message) {

        return new ErrorResponse(code, message, APPLICATION_SOURCE);
    }
}
