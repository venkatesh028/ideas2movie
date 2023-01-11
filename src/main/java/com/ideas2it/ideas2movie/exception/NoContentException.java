package com.ideas2it.ideas2movie.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NoContentException extends Exception{

    private static final HttpStatus httpStatus = HttpStatus.NO_CONTENT;
    public NoContentException(String message){
        super(message);
    }
}
