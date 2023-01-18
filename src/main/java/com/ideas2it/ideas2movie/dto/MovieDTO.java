/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto;

import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.ideas2it.ideas2movie.model.CastAndCrew;
import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.util.enums.Genre;
import com.ideas2it.ideas2movie.util.enums.Language;

/**
 * <h2>
 *     Movie DTO
 * </h2>
 * <p>
 *      MovieDTO represents a Simplified version of the Movie Model
 *      which Holds the Necessary Information of the Movie model
 * </p>
 *
 * @author YOGESHWAR S
 * @version 1.0
 * @since - 09.01.2022
 */
@Getter
@Setter
@NoArgsConstructor
public class MovieDTO {
    @NotBlank(message = Message.MOVIE_NAME_SHOULD_NOT_BE_EMPTY)
    private String name;
    @NotNull(message = Message.LANGUAGE_SHOULD_NOT_BE_EMPTY)
    private Language language;
    @NotNull(message = Message.DURATION_SHOULD_NOT_BE_EMPTY)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime duration;
    @NotNull(message = Message.GENRE_SHOULD_NOT_BE_EMPTY)
    private Genre genre;
    private CastAndCrew castAndCrew;
}
