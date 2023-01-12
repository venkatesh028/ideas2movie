package com.ideas2it.ideas2movie.exception;

import org.springframework.http.HttpStatus;

/**
 * <h1>
 *     NotAcceptableException
 * </h1>
 * <p>
 *     NotAcceptableException is a custom exception for the Ideas2Movie application.
 *     It extends the Ideas2MovieException and provides a specific exception
 *     when the requested resource is not acceptable according to the Accept headers sent in the request
 * </p>
 *
 * @version 1.0
 * @author Venkatesh TM
 * @since 12/01/2023
 */
public class NotAcceptableException extends Ideas2MovieException{

    public NotAcceptableException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
