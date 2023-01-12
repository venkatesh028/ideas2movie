/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.exception;

import org.springframework.http.HttpStatus;

/**
 * <h1>
 *     NotFoundException
 * </h1>
 * <p>
 *     NotFoundException is a custom exception for the Ideas2Movie application.
 *     It extends the Ideas2MovieException and provides a specific exception
 *     when a requested resource is not found.
 * </p>
 *
 * @version 1.0
 * @author Venkatesh TM
 * @since 12/01/2023
 */
public class NotFoundException  extends Ideas2MovieException{
    public NotFoundException(String message){
        super(message,HttpStatus.NOT_FOUND);
    }
}
