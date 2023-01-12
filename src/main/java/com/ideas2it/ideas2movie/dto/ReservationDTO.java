/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.util.enums.ModeOfBooking;

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
    @NotNull
    private Long userId;
    @NotNull
    private Long showId;
    @NotBlank
    private ModeOfBooking modeOfBooking;
    @NotNull
    private List<Long> idsOfSeats;
}
