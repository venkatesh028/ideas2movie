/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import com.ideas2it.ideas2movie.util.constant.Message;

/**
 * <p>
 * Represents the Theater DTO
 * </p>
 *
 * @author YOGESHWAR S
 * @version 1.0
 * @since - 09.01.2022
 */
@Getter
@Setter
public class TheaterDTO {
    private Long id;
    @NotBlank(message = Message.THEATER_NAME_SHOULD_NOT_BE_EMPTY)
    private String theaterName;
    @NotBlank(message = Message.CITY_NAME_SHOULD_NOT_BE_EMPTY)
    private String city;
    @NotBlank(message = Message.AMOUNT_SHOULD_NOT_BE_EMPTY)
    private String area;
    @NotBlank(message = Message.PINCODE_SHOULD_NOT_BE_EMPTY)
    private String pincode;
}
