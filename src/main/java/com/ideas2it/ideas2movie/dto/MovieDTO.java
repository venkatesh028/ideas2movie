package com.ideas2it.ideas2movie.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalTime;

import com.ideas2it.ideas2movie.model.CastAndCrew;
import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.util.enums.Genre;
import com.ideas2it.ideas2movie.util.enums.Language;

public class MovieDTO {
    private Long id;
    @NotBlank(message = Message.MOVIE_NAME_SHOULD_NOT_BE_EMPTY)
    private String name;
    @NotBlank(message = Message.LANGUAGE_SHOULD_NOT_BE_EMPTY)
    private Language language;
    @NotBlank(message = Message.DURATION_SHOULD_NOT_BE_EMPTY)
    private LocalTime duration;
    @NotBlank(message = Message.GENRE_SHOULD_NOT_BE_EMPTY)
    private Genre gener;
    private CastAndCrew castAndCrew;
}
