/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import com.ideas2it.ideas2movie.util.constant.Message;

/**
 * <h2>
 *     ScreenDTO
 * </h2>
 * <p>
 *     ScreenDTO represents a Simplified version of the Screen Model
 *     which Holds the Necessary Information of the Screen model
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
    @NotNull(message = "Number of Rows Should not be null")
    private int totalNumberOfRows;
    @NotNull(message = "Number of Columns Should not be null")
    private int totalNumberOfColumns;
    @NotNull(message = "Theater id should not be blank")
    private Long theaterId;
}
