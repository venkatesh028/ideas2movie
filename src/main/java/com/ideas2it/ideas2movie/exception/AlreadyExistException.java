/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
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
public class AlreadyExistException extends Ideas2MovieException {
    public AlreadyExistException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
