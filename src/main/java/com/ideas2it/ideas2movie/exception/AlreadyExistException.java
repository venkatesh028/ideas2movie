/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.exception;

import org.springframework.http.HttpStatus;

public class AlreadyExistException extends Exception{
    public AlreadyExistException(String message) {
        super(message);
    }
}
