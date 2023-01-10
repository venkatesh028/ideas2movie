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
 * Represents the CastAndCrew DTO
 * </p>
 *
 * @author YOGESHWAR S
 * @version 1.0
 * @since - 09.01.2022
 */
@Getter
@Setter
public class CastAndCrewDTO {
    private Long id;
    @NotBlank(message = Message.DIRECTOR_NAME_SHOULD_NOT_BE_EMPTY)
    private String director;
    @NotBlank(message = Message.HERO_NAME_SHOULD_NOT_BE_EMPTY)
    private String hero;
    @NotBlank(message = Message.HEROINE_NAME_SHOULD_NOT_BE_EMPTY)
    private String heroine;
}
