/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto.responsedto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

import com.ideas2it.ideas2movie.util.enums.Genre;
import com.ideas2it.ideas2movie.util.enums.Language;

/**
 * <h1>
 *     Movie Response DTO
 * </h1>
 * <p>
 *     Represents the Movie Response DTO,
 *     its shows the required data to the client.
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
