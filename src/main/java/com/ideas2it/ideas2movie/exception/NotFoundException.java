/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.exception;

import org.springframework.http.HttpStatus;

/**
 * <h2>
 *     NotFoundException
 * </h2>
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

    /**
     * <h1>
     *     NotFoundException constructor
     * </h1>
     * <p>
     *     Calls the super class constructor and passes in the error message and
     *     an HttpStatus.NOT_FOUND value.
     * </p>
     *
     * @param message - Message Which Represents the error
     */
    public NotFoundException(String message){
        super(message,HttpStatus.NOT_FOUND);
    }
}
