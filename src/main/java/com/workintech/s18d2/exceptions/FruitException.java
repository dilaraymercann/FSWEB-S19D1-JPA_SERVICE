package com.workintech.s18d2.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FruitException extends RuntimeException {
    private final HttpStatus httpStatus;

    public FruitException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}