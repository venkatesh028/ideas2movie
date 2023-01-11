package com.ideas2it.ideas2movie.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * <h1>
 *     SeatDTO
 * </h1>
 * <p>
 *     Gets the input from the client for the seat
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 06/01/2023
 */
@Getter
@Setter
public class SeatDTO {
    @NotBlank(message = "Seat name should not be blank")
    private String name;
    @NotNull(message = "price should not be blank")
    private double price;
    @NotBlank(message = "screen id should not be blank")
    private Long screenId;
}
