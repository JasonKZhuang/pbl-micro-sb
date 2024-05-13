package com.zkz.microservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by Jason Zhuang 17/11/2021
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @ResponseBody signals that this advice is rendered straight into the response body.
     * @ExceptionHandler configures the advice to only respond if an ProductNotFoundException is thrown.
     * @ResponseStatus says to issue an HttpStatus.NOT_FOUND, i.e. an HTTP 404.
     * The body of the advice generates the content. In this case, it gives the message of the exception.
     */
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorMessage> productNotFoundHandler(ProductNotFoundException ex) {
        log.error("error", ex);
        return ResponseEntity.
                status(HttpStatus.NOT_FOUND)
                .body(
                        new ErrorMessage(404, ex.getMessage())
                );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException ex) {
        log.error("error", ex);
        return ResponseEntity.
                status(HttpStatus.NOT_FOUND)
                .body(
                        new ErrorMessage(404, ex.getMessage())
                );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorMessage> handleBadRequestException(BadRequestException ex) {
        log.error("error", ex);
        return ResponseEntity.
                status(HttpStatus.BAD_REQUEST)
                .body(
                        new ErrorMessage(400, ex.getMessage())
                );
    }
}