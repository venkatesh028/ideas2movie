package com.ideas2it.ideas2movie.exception;

import org.springframework.http.HttpStatus;

/**
 * <h2>
 *     BadRequestException
 * </h2>
 * <p>
 *     BadRequestException is a custom exception for the Ideas2Movie application.
 *     It extends the Ideas2MovieException and provides a specific exception
 *     when a Error in the value from the request.
 * </p>
 *
 * @version 1.0
 * @author Venkatesh TM
 * @since 12/01/2023
 */
public class BadRequestException extends Ideas2MovieException{

    /**
     * <h1>
     *     BadRequestException constructor
     * </h1>
     * <p>
     *     Calls the super class constructor and passes in the error message and
     *     an HttpStatus.BAD_REQUEST value.
     * </p>
     * @param message - Message Which Represents the error
     */

    public BadRequestException(String message){
        super(message, HttpStatus.BAD_REQUEST);
    }
}
