/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto.responsedto;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *     Represents the CastAndCrew Response DTO,
 *     its shows the required data to the client.
 * </p>
 *
 * @author YOGESHWAR S
 * @version 1.0
 * @since - 09.01.2022
 */
@Getter
@Setter
public class CastAndCrewResponseDTO {
    private Long id;
    private String director;
    private String hero;
    private String heroine;
}
