/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
public class NotFoundException  extends Exception{
    private static HttpStatus httpStatus = HttpStatus.NOT_FOUND;
    public NotFoundException(String message){
        super(message);
    }
}
