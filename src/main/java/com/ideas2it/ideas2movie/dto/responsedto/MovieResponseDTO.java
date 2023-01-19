/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto.responsedto;

import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

import com.ideas2it.ideas2movie.util.enums.Genre;
import com.ideas2it.ideas2movie.util.enums.Language;

/**
 * <h2>
 *     MovieResponseDTO
 * </h2>
 * <p>
 *     MovieResponseDTO represents the response sent to the Client with the ID
 *     after Creating and Updating the Movie Details.
 * </p>
 *
 * @author YOGESHWAR S
 * @version 1.0
 * @since - 09.01.2022
 */
@Getter
@Setter
public class MovieResponseDTO {
    private Long id;
    private String name;
    private Language language;
    private LocalTime duration;
    private Genre genre;
    private CastAndCrewResponseDTO castAndCrew;
}
