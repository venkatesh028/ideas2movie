package com.ideas2it.ideas2movie.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends Ideas2MovieException{

    public BadRequestException(String message){
        super(message, HttpStatus.BAD_REQUEST);
    }
}
