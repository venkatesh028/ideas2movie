/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <h1>
 *     Mode Of Booking
 * </h1>
 * <p>
 *     Contains the Mode of the Booking as a Enum
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   05-01-2023
 */
@AllArgsConstructor
public enum ModeOfBooking {
    OFFLINE("Offline"), ONLINE("Online");

    @Getter
    @Setter
    private String mode;
}
