/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import com.ideas2it.ideas2movie.dto.ReservationDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ReservationResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import java.util.List;

public interface ReservationService {
    ReservationResponseDTO makeBooking(ReservationDTO reservationDTO) throws AlreadyExistException;

    ReservationResponseDTO cancelBooking(Long id);

    ReservationResponseDTO getBookingById(Long id);

    List<ReservationResponseDTO> getAllBookingByUserId(Long id);
}
