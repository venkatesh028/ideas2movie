package com.ideas2it.ideas2movie.exception;

import org.springframework.http.HttpStatus;

/**
 * <h1>
 *
 * </h1>
 * <p>
 *
 * </p>
 */
public class NotAcceptableException extends Ideas2MovieException{

    public NotAcceptableException(String message) {
        super(message, HttpStatus.NOT_ACCEPTABLE);
    }
}
