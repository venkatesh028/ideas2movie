/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto.responsedto;

import lombok.Getter;
import lombok.Setter;

import com.ideas2it.ideas2movie.util.enums.City;

/**
 * <h2>
 *     TheaterResponseDTO
 * </h2>
 * <p>
 *     TheaterResponseDTO represents the response sent to the Client with the ID
 *     after Creating and Updating the Theater Details.
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
    private City city;
    private String area;
}
