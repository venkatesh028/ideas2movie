/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ideas2it.ideas2movie.dto.responsedto.ErrorMessageDTO;
import com.ideas2it.ideas2movie.logger.CustomLogger;

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
    private final CustomLogger logger = new CustomLogger(MovieExceptionHandler.class);
    @ExceptionHandler(NotfoundException.class)
    public ResponseEntity<ErrorMessageDTO> notFoundException(NotfoundException notfoundException) {
        logger.error(notfoundException.getMessage());
        ErrorMessageDTO errorMessage = new ErrorMessageDTO(notfoundException.getMessage(),
                                                           HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ErrorMessageDTO> alreadyExistException(AlreadyExistException alreadyExistException){
        ErrorMessageDTO errorMessage = new ErrorMessageDTO(alreadyExistException.getMessage(),
                                                           HttpStatus.NOT_ACCEPTABLE);
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_ACCEPTABLE);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>>  handleMethodNotValidationExceptions(
            MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> errors = new HashMap<>();

        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.NOT_ACCEPTABLE);
    }
}
