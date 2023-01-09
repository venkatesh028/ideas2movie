package com.ideas2it.ideas2movie.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import com.ideas2it.ideas2movie.util.constant.Message;

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
