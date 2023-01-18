package com.ideas2it.ideas2movie.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * <h2>
 *     NoContentException
 * </h2>
 * <p>
 *     NoContentException is a custom exception for the Ideas2Movie application.
 *     It extends the Ideas2MovieException and provides a specific exception
 *     when there is no content to return for the requested resources.
 * </p>
 *
 * @version 1.0
 * @author Venkatesh TM
 * @since 12/01/2023
 */
@Getter
public class NoContentException extends Ideas2MovieException {

    /**
     * <h1>
     *     NoContentException constructor
     * </h1>
     * <p>
     *     Calls the super class constructor and passes in the error message and
     *     an HttpStatus.NO_CONTENT value.
     * </p>
     *
     * @param message - Message Which Represents the error
     */
    public NoContentException(String message){
        super(message, HttpStatus.NO_CONTENT);
    }
}
