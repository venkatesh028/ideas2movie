/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.ideas2it.ideas2movie.dto.responsedto.ShowResponseDTO;
import com.ideas2it.ideas2movie.dto.responsedto.UserResponseDTO;
import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.util.enums.ModeOfReservation;

/**
 * <h1>
 *     ReservationDTO
 * </h1>
 * <p>
 *     ReservationDTO represent the Simplified version of the Reservation Model
 *     which Holds the Necessary Details of the Reservation model to get from User to Reserve Seats for Show.
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
    @NotNull(message = Message.MODE_OF_RESERVATION_SHOULD_NOT_BE_EMPTY)
    private ModeOfReservation modeOfReservation;
    @NotNull(message = Message.SELECT_AT_LEAST_ONE_SEAT)
    private List<Long> idsOfSeats;
    @NotNull(message = Message.USER_SHOULD_NOT_BE_EMPTY)
    private UserResponseDTO user;
    @NotNull(message = Message.SHOW_SHOULD_NOT_BE_EMPTY)
    private ShowResponseDTO show;
}
