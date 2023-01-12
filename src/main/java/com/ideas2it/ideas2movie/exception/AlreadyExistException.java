/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.exception;

import lombok.Getter;

import org.springframework.http.HttpStatus;

@Getter
public class AlreadyExistException extends Exception {
    private static HttpStatus httpStatus = HttpStatus.CONFLICT;
    public AlreadyExistException(String message) {
        super(message);
    }
}
