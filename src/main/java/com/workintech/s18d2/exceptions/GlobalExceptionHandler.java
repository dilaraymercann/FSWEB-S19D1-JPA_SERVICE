package com.workintech.s18d2.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FruitException.class)
    public ResponseEntity<FruitErrorResponse> handleFruitException(FruitException e) {
        log.error("FruitException: {}", e.getMessage());
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(new FruitErrorResponse(e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<FruitErrorResponse> handleException(Exception e) {
        log.error("Exception: {}", e.getMessage());
        return ResponseEntity
                .status(500)
                .body(new FruitErrorResponse(e.getMessage()));
    }
}