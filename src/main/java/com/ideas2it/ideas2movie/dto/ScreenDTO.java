package com.ideas2it.ideas2movie.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * <h1>
 *     ScreenDTO
 * </h1>
 * <p>
 *     Gets the input from the client for the screen
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 06/01/2023
 */
@Getter
@Setter
public class ScreenDTO {
    @NotBlank(message = "Screen name should not be empty")
    private String name;
    @NotBlank(message = "Total Number of seat should not be blank")
    private int totalNoOfSeat;
    @NotBlank(message = "Theater id should not be blank")
    private Long theaterId;
}
