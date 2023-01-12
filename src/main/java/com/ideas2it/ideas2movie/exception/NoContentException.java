package com.ideas2it.ideas2movie.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * <h1>
 *     NoContentException
 * </h1>
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
    public NoContentException(String message){
        super(message, HttpStatus.NO_CONTENT);
    }
}
