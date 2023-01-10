/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto;

import jakarta.validation.constraints.NotBlank;

import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.util.enums.ModeOfBooking;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h1>
 *     ReservationDTO
 * </h1>
 * <p>
 *     ReservationDTO is used to get the Details for the Reservation
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@Getter
@Setter
@NoArgsConstructor
public class ReservationDTO {
    @NotBlank(message = "")
    private Long userId;
    @NotBlank
    private Long showId;
    @NotBlank
    private ModeOfBooking modeOfBooking;
    @NotBlank
    private List<Long> idsOfSeats;
}
