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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ideas2it.ideas2movie.dto.responsedto.ErrorMessageDTO;
import com.ideas2it.ideas2movie.logger.CustomLogger;

/**
 * <h2>
 *     MovieExceptionHandler
 * </h2>
 * <p>
 *    Handles the Exception within the Ideas2Movie application.
 *    It includes two exception handlers, one for handling specific custom exceptions
 *    Another one for handling Exception for invalid input values from request.
 *    proper response Error message with status code
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 05/01/2023
 *
 */
@RestControllerAdvice
public class MovieExceptionHandler {
    private final CustomLogger logger = new CustomLogger(MovieExceptionHandler.class);

    /**
     * <h1>
     *     handelIdeas2MovieException
     * </h1>
     * <p>
     *     Handles the Custom Exception for ideas2movie application
     *     Which occurs in different scenario like Resource Not found
     *     or Given Resource is Already Exists or No content For
     *     looking Resources
     * </p>
     *
     * @param exception - Holds The Custom Exception for the application
     * @return ResponseEntity - Holds the ErrorMessageDto and HttpStatus
     */
    @ExceptionHandler({
            NotFoundException.class,
            AlreadyExistException.class,
            NotAcceptableException.class,
            BadRequestException.class,
            NoContentException.class
    })
    public ResponseEntity<ErrorMessageDTO> handelIdeas2MovieException(Ideas2MovieException exception) {
        logger.error(exception.getMessage());
        ErrorMessageDTO errorMessage = new ErrorMessageDTO(exception.getMessage(),exception.getHttpStatus());
        return ResponseEntity.status(exception.getHttpStatus()).body(errorMessage);
    }


    /**
     * <h1>
     *     handelMethodNotValidationExceptions
     * </h1>
     * <p>
     *     Handles the exception thrown for the invalid format of the given values
     *     creates a new map of errors, where it puts the field name and error message in the map.
     *     and returns a ResponseEntity with the appropriate HTTP status code and the error map as the body.
     * </p>
     * @param methodArgumentNotValidException - Holds the methodArgumentNotValidException Which get Handled
     * @return ResponseEntity - Holds the appropriate HTTP status code and error map as the body
     */
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
