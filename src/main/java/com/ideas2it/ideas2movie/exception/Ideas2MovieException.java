package com.ideas2it.ideas2movie.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * <h1>
 *     Ideas2MovieException
 * </h1>
 * <p>
 *
 * </p>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ideas2MovieException extends Exception {
    private String message;
    private HttpStatus httpStatus;
}
