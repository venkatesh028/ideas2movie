/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto.responsedto;

import lombok.Getter;
import lombok.Setter;

/**
 * <h1>
 *     SeatResponseDTO
 * </h1>
 * <p>
 *     SeatResponseDTO represents the response sent to the Client with the ID
 *     after Creating the Seat.
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 06/01/2023
 */

@Getter
@Setter
public class SeatResponseDTO {
    private Long id;
    private String name;

}
