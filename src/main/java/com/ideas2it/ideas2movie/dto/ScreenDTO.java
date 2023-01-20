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
    @NotBlank(message = Message.SCREEN_NAME_SHOULD_NOT_BE_EMPTY)
    private String name;
    @NotNull(message = Message.ROWS_SHOULD_NOT_NULL)
    private int totalNumberOfRows;
    @NotNull(message = Message.COLUMN_SHOULD_NOT_NULL)
    private int totalNumberOfColumns;
    @NotNull(message = Message.THEATER_ID_SHOULD_BE_BLANK)
    private Long theaterId;
}
