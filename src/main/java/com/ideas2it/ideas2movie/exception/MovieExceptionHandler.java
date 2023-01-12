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

import com.ideas2it.ideas2movie.dto.responsedto.ErrorMessageDTO;
import com.ideas2it.ideas2movie.logger.CustomLogger;

/**
 * <h1>
 *     MovieExceptionHandler
 * </h1>
 * <p>
 *    Handles the Exception and sends the
 *    proper response Error message with status code
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

    @ExceptionHandler({
            NotFoundException.class,
            AlreadyExistException.class,
            NotAcceptableException.class,
            NoContentException.class
    })
    public ResponseEntity<ErrorMessageDTO> handelIdeas2MovieException(Ideas2MovieException exception) {
        logger.error(exception.getMessage());
        ErrorMessageDTO errorMessage = new ErrorMessageDTO(exception.getMessage(),exception.getHttpStatus());
        return ResponseEntity.status(exception.getHttpStatus()).body(errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>>  handleMethodNotValidationExceptions(
            MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> errors = new HashMap<>();

        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            logger.error(errorMessage);
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
