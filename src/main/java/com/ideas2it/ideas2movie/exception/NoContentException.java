package com.ideas2it.ideas2movie.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * <h1>
 *
 * </h1>
 * <p>
 *
 * </p>
 */
@Getter
public class NoContentException extends Ideas2MovieException {
    public NoContentException(String message){
        super(message, HttpStatus.NO_CONTENT);
    }
}
