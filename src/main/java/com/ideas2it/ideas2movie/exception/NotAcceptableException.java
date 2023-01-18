package com.ideas2it.ideas2movie.exception;

import org.springframework.http.HttpStatus;

/**
 * <h2>
 *     NotAcceptableException
 * </h2>
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

    /**
     * <h1>
     *     NotAcceptableException constructor
     * </h1>
     * <p>
     *     Calls the super class constructor and passes in the error message and
     *     an HttpStatus.BAD_REQUEST value.
     * </p>
     *
     * @param message - Message Which Represents the error
     */
    public NotAcceptableException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
