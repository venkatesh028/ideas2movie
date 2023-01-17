/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
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
 *      SeatDTO represents a Simplified version of the Seat Model
 *      which Holds the Necessary Information of the Seat model
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
