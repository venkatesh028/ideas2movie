package com.ideas2it.ideas2movie.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.http.HttpStatus;

/**
 * <h2>
 *     Ideas2MovieException
 * </h2>
 * <p>
 *     Ideas2MovieException is a custom exception for the Ideas2Movie application.
 *     It extends the base Exception and includes additional fields for a message and an HTTP status code.
 *     This allows for more detailed and specific error handling within the application.
 * </p>
 *
 * @version 1.0
 * @author Venkatesh TM
 * @since 12/01/2023
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ideas2MovieException extends Exception {
    private String message;
    private HttpStatus httpStatus;
}
