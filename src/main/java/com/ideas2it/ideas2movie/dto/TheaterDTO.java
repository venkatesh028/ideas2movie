/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto;

import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.util.enums.City;

/**
 * <h1>
 *     Theater DTO
 * </h1>
 * <p>
 *      TheaterDTO represents a Simplified version of the Theater Model
 *      which Holds the Necessary Information of the Theater model
 * </p>
 *
 * @author YOGESHWAR S
 * @version 1.0
 * @since - 09.01.2022
 */
@Getter
@Setter
@NoArgsConstructor
public class TheaterDTO {
    @NotBlank(message = Message.THEATER_NAME_SHOULD_NOT_BE_EMPTY)
    private String theaterName;
    @NotBlank(message = Message.CITY_NAME_SHOULD_NOT_BE_EMPTY)
    private City city;
    @NotBlank(message = Message.AMOUNT_SHOULD_NOT_BE_EMPTY)
    private String area;
}
