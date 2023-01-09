/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import com.ideas2it.ideas2movie.dto.ReservationDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ReservationResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import java.util.List;

/**
 * <h1>
 *     Reservation Service
 * </h1>
 * <p>
 *     Service Layer for the Reservation
 *     to reserve, cancel and get the Reserved tickets by User Id
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 09-01-2023
 */
public interface ReservationService {
    /**
     * <h1>
     *     Make Booking
     * </h1>
     * <p>
     *     Gets the Input from the reservation Controller
     *     and checks whether the selected seats were reserved or not
     *     and saves the reservation of ticket
     *     by confirming the status of the Payment for the reservation
     * </p>
     *
     * @param reservationDTO - Holds the details to book Ticket
     * @return ReservationResponseDTO - Holds the Response of the Reservation
     * @throws AlreadyExistException - when Seats is Booked already
     */
    ReservationResponseDTO reserveSeats(ReservationDTO reservationDTO) throws AlreadyExistException;

    ReservationResponseDTO cancelBooking(Long id);

    ReservationResponseDTO getBookingById(Long id);

    List<ReservationResponseDTO> getAllBookingByUserId(Long id);
}
