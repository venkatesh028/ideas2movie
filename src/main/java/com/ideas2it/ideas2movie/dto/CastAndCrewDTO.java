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

/**
 * <h1>
 *     CastAndCrew DTO
 * </h1>
 * <p>
 *      CastAndCrewDTO represents a Simplified version of the CastAndCrew Model
 *      which Holds the Necessary Information of the CastAndCrew model
 * </p>
 *
 * @author YOGESHWAR S
 * @version 1.0
 * @since - 09.01.2022
 */
@Getter
@Setter
@NoArgsConstructor
public class CastAndCrewDTO {
    @NotBlank(message = Message.DIRECTOR_NAME_SHOULD_NOT_BE_EMPTY)
    private String director;
    @NotBlank(message = Message.HERO_NAME_SHOULD_NOT_BE_EMPTY)
    private String hero;
    @NotBlank(message = Message.HEROINE_NAME_SHOULD_NOT_BE_EMPTY)
    private String heroine;
}
