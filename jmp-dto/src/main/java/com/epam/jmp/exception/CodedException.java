package com.epam.jmp.exception;

import lombok.Getter;

@Getter
public class CodedException extends RuntimeException {

    private final String code;
    private final String message;

    public CodedException(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
