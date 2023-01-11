/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

import com.ideas2it.ideas2movie.model.CastAndCrew;
import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.util.enums.Genre;
import com.ideas2it.ideas2movie.util.enums.Language;

/**
 * <h1>
 *     Movie DTO
 * </h1>
 * <p>
 *     Get the input from the client for  the Movie
 *  * </p>
 *
 * @author YOGESHWAR S
 * @version 1.0
 * @since - 09.01.2022
 */
@Getter
@Setter
@NoArgsConstructor
public class MovieDTO {
    private Long id;
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
