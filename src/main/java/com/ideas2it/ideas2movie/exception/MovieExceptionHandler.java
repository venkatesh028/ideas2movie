/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ideas2it.ideas2movie.dto.responsedto.ErrorMessageDTO;

/**
 * <h1>
 *     MovieExceptionHandler
 * </h1>
 * <p>
 *    Handles the Exception and sends the
 *    proper response entity with status code
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 05/01/2023
 *
 */
@ControllerAdvice
public class MovieExceptionHandler {

    @ExceptionHandler(NotfoundException.class)
    public ResponseEntity<ErrorMessageDTO> notFoundException(NotfoundException notfoundException) {
        ErrorMessageDTO errorMessage = new ErrorMessageDTO(notfoundException.getMessage(),
                                                           HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<ErrorMessageDTO> alreadyExistException(AlreadyExistException alreadyExistException){
        ErrorMessageDTO errorMessage = new ErrorMessageDTO(alreadyExistException.getMessage(),
                                                           HttpStatus.NOT_ACCEPTABLE);
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_ACCEPTABLE);
    }

}
