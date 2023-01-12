/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import java.util.List;

import com.ideas2it.ideas2movie.model.Reservation;
import com.ideas2it.ideas2movie.model.Screen;
import com.ideas2it.ideas2movie.model.Seat;
import com.ideas2it.ideas2movie.dto.ReservationDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ReservationResponseDTO;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h1>
 *     ReservationService
 * </h1>
 * <p>
 *     ReservationService Used to manage the Operation for the Reservation
 *     Like ReserveSeats, Confirm reservation, Cancel reservation for the Show
 *     and Throws an Exception accordingly
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 09-01-2023
 */
public interface ReservationService {

    /**
     * <h1>
     *     reserveSeats
     * </h1>
     * <p>
     *     Gets the Input from the reservation Controller
     *     and checks whether the selected seats were reserved or not
     *     and saves the reservation of ticket
     *     by confirming the status of the Payment for the reservation
     * </p>
     *
     * @param reservationDTO - Holds the details to book Ticket
     * @return ReservationResponseDTO - Holds the Details of the Reservation
     */
    ReservationResponseDTO reserveSeats(ReservationDTO reservationDTO);

    /**
     * <h1>
     *     cancelReservation
     * </h1>
     * <p>
     *     gets the Id of the Reservation from the Reservation Controller
     *     and checks whether the Reservation id present or not
     *     If present then cancels the Reservation otherwise throws an Exception
     * </p>
     *
     * @param id - ID of the Reservation to cancel reservation
     * @return ReservationResponseDTO - Holds the Details of the Reservation
     * @throws NotFoundException - when
     */
    ReservationResponseDTO cancelReservation(Long id) throws NotFoundException;

    /**
     * <h1>
     *     cancelAllReservationForShow
     * </h1>
     * <p>
     *     Gets the Screen details form the ScreenService to cancel the All the reservations
     *     made for the show by Setting the Status of the reservation to Canceled
     * </p>
     * @param screen - Holds the Details of the Screen
     * @return boolean - status of Cancellation
     */
    boolean cancelAllReservationForShow(Screen screen);

    /**
     * <h1>
     *     confirmReservation
     * </h1>
     * <p>
     *     Gets the Reservation from PaymentController to Confirm the reservation for the User
     *     by changes the status of the Reservation by checking the Status of the Payment
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
     *     Gets the ID of the Reservation from the PaymentController
     *     and checks whether the Reservation is present or not
     *     If present then returns the Reservation Response DTO otherwise throws an Exception
     * </p>
     * @param id - ID of the Reservation
     * @return ReservationResponseDTO -  Holds the Response of the Reservation
     * @throws NotFoundException - when Reservation Not Found
     */
    ReservationResponseDTO getReservationDTOById(Long id) throws NotFoundException;

    /**
     * <h1>
     *     getReservedSeats
     * </h1>
     * <p>
     *     Gets the Id of the show from the ShowService and checks Reservation is Present or not
     *     If present then gets the Reservations for the Show Id and returns the List of Seats
     *     which are booked otherwise throws an Exception
     * </p>
     *
     * @param showId - ID of the Show to get Booking
     * @return List<Seat> - holds the Booked seats for a Show
     */
    List<Seat> getReservedSeats(Long showId) ;

    /**
     * <h1>
     *     getReservationById
     * </h1>
     * <p>
     *     Gets the ID of the Reservation from the PaymentController
     *     and checks whether the Reservation is present or not
     *     and returns the Reservation
     * </p>
     *
     * @param id - ID of the Reservation
     * @return Reservation -  Holds the Response of the Reservation
     * @throws NotFoundException - when Reservation Not Found
     */
    Reservation getReservationById(Long id) throws NotFoundException;

    /**
     * <h1>
     *     getAllByUserId
     * </h1>
     * <p>
     *     Gets the ID of the User from the PaymentController
     *     and checks whether the Reservation is present or not
     *     and returns the Reservation Response DTO
     * </p>
     *
     * @param id - ID of the User to find the Reservation for that User
     * @return List<ReservationResponseDTO> - Holds the List of Reservation for a User
     * @throws NotFoundException - when Reservation Not Found
     */
    List<ReservationResponseDTO> getAllReservationByUserId(Long id) throws NoContentException;
}
