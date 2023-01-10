/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import com.ideas2it.ideas2movie.dto.ReservationDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ReservationResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.model.Payment;
import com.ideas2it.ideas2movie.model.Reservation;
import com.ideas2it.ideas2movie.model.Seat;
import com.ideas2it.ideas2movie.model.Show;
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
     */
    ReservationResponseDTO reserveSeats(ReservationDTO reservationDTO);

    ReservationResponseDTO cancelBooking(Long id);

    /**
     * <h1>
     *     Confirm Reservation
     * </h1>
     * <p>
     *     Gets the Reservation from Payment Controller
     *     and according to the Payment Status change the
     *     status of the Reservation
     * </p>
     *
     * @param reservation - Holds the details of the Reservation
     * @return ReservationResponseDTO - Holds the response of the Reservation
     */
    ReservationResponseDTO confirmReservation(Reservation reservation);

    /**
     * <h1>
     *     getReservationDTOById
     * </h1>
     * <p>
     *     Gets the ID of the Reservation from the Payment Controller
     *     and checks whether the Reservation is present or not
     *     and returns the Reservation Response DTO
     * </p>
     * @param id - ID of the Reservation
     * @return ReservationResponseDTO -  Holds the Response of the Reservation
     */
    ReservationResponseDTO getReservationDTOById(Long id);

    /**
     * <h1>
     *     getReservedSeats
     * </h1>
     * <p>
     *     Gets the Id of the show from the Show Service
     *     and gets the Reservations for the Show Id
     *     and returns the List of Seats which are booked
     * </p>
     *
     * @param showId - ID of the Show to get Booking
     * @return List<Seat> - holds the Booked seats for a Show
     */
    List<Seat> getReservedSeats(Long showId);
    /**
     * <h1>
     *     getReservationById
     * </h1>
     * <p>
     *     Gets the ID of the Reservation from the Payment Controller
     *     and checks whether the Reservation is present or not
     *     and returns the Reservation
     * </p>
     *
     * @param id - ID of the Reservation
     * @return Reservation -  Holds the Response of the Reservation
     */
    Reservation getReservationById(Long id);

    /**
     * <h1>
     *     getAllByUserId
     * </h1>
     * <p>
     *     Gets the ID of the User from the Payment Controller
     *     and checks whether the Reservation is present or not
     *     and returns the Reservation Response DTO
     * </p>
     *
     * @param id - ID of the User to find the Reservation for that User
     * @return List<ReservationResponseDTO> - Holds the List of Reservation for a User
     */
    List<ReservationResponseDTO> getAllReservationByUserId(Long id);
}
