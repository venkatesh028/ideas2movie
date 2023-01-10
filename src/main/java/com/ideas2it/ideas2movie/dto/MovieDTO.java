/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

import com.ideas2it.ideas2movie.model.CastAndCrew;
import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.util.enums.Genre;
import com.ideas2it.ideas2movie.util.enums.Language;

/**
 * <p>
 * Represents the Movie DTO
 * </p>
 *
 * @author YOGESHWAR S
 * @version 1.0
 * @since - 09.01.2022
 */
@Getter
@Setter
public class MovieDTO {
    private Long id;
    @NotBlank(message = Message.MOVIE_NAME_SHOULD_NOT_BE_EMPTY)
    private String name;
    @NotBlank(message = Message.LANGUAGE_SHOULD_NOT_BE_EMPTY)
    private Language language;
    @NotBlank(message = Message.DURATION_SHOULD_NOT_BE_EMPTY)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime duration;
    @NotBlank(message = Message.GENRE_SHOULD_NOT_BE_EMPTY)
    private Genre gener;
    private CastAndCrew castAndCrew;
}
