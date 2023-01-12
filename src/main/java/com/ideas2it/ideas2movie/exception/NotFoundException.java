/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.exception;

import org.springframework.http.HttpStatus;

/**
 * <h1>
 *
 * </h1>
 * <p>
 *
 * </p>
 */
public class NotFoundException  extends Ideas2MovieException{
    public NotFoundException(String message){
        super(message,HttpStatus.NOT_FOUND);
    }
}
