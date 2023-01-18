/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.exception;

import lombok.Getter;

import org.springframework.http.HttpStatus;

/**
 * <h2>
 *     AlreadyExistException
 * </h2>
 * <p>
 *     AlreadyExistException is a custom exception for the Ideas2Movie application.
 *     It extends the Ideas2MovieException and provides a specific exception
 *     when a resource already exists.
 * </p>
 *
 * @version 1.0
 * @author Venkatesh TM
 * @since 12/01/2023
 */
@Getter
public class AlreadyExistException extends Ideas2MovieException {

    /**
     * <h1>
     *     AlreadyExistException constructor
     * </h1>
     * <p>
     *     Calls the super class constructor and passes in the error message and
     *     an HttpStatus.CONFLICT value.
     * </p>
     * @param message - Message Which Represents the error
     */
    public AlreadyExistException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
