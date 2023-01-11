/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto.responsedto;

import lombok.Getter;
import lombok.Setter;

/**
 * <h1>
 *     Theater Response DTO
 * </h1>
 * <p>
 *     Represents the Theater Response DTO,
 *     its shows the required data to the client.
 * </p>
 *
 * @author YOGESHWAR S
 * @version 1.0
 * @since - 09.01.2022
 */
@Getter
@Setter
public class TheaterResponseDTO {
    private  Long id;
    private String theaterName;
    private String city;
    private String area;
}
