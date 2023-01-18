/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import java.util.List;

import com.ideas2it.ideas2movie.model.Payment;
import com.ideas2it.ideas2movie.model.Reservation;
import com.ideas2it.ideas2movie.model.Screen;
import com.ideas2it.ideas2movie.model.Seat;
import com.ideas2it.ideas2movie.dto.ReservationDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ReservationResponseDTO;
import com.ideas2it.ideas2movie.exception.BadRequestException;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h2>
 *     ReservationService
 * </h2>
 * <p>
 *     ReservationService provides the Method for Reservation CRUD, Used to handle the Reservation of Seats
 *     for the show by the User Like Reserving Seats for show, Cancel reservation
 *     and Retrieving the Details of the Reservation based on reservation ID and User ID
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
     *     Reserve Selected Seats for the Show and Sets the Status of reservation to PROCESSING
     *     and calculates the total price for the reservation and returns the Details of the Reservation
     * </p>
     *
     * @param reservationDTO - Holds the details to book Ticket
     * @return ReservationResponseDTO - Holds the Details of the Reservation
     * @throws BadRequestException - When
     */
    ReservationResponseDTO reserveSeats(ReservationDTO reservationDTO) throws BadRequestException;

    /**
     * <h1>
     *      confirmReservation
     * </h1>
     * <p>
     *      Confirms the Reservation for the Given Reservation by validating If the Status of the payment is PAID
     *      then sets the Status of the Reservation to BOOKED otherwise CANCELLED
     *      and returns the Details of the Reservation
     * </p>
     *
     * @param payment - Holds the details of the Payment for Reservation
     * @return ReservationResponseDTO - Holds the response of the Reservation
     */
    ReservationResponseDTO confirmReservation(Payment payment) throws NotFoundException;

    /**
     * <h1>
     *     cancelReservation
     * </h1>
     * <p>
     *     Cancels the reservation for the Show for the Given ID of the reservation
     *     by sets the Status of the Reservation to CANCELLED and also sets the status of Payment to REFUNDED
     *     and returns the Details of the reservation
     * </p>
     *
     * @param id - ID of the Reservation to cancel reservation
     * @return ReservationResponseDTO - Holds the Details of the Reservation
     * @throws NotFoundException - when Reservation is Not Found
     */
    ReservationResponseDTO cancelReservationById(Long id) throws NotFoundException;

    /**
     * <h1>
     *     cancelAllReservationForShow
     * </h1>
     * <p>
     *     Cancels the reservation for the Screen by getting the All the Reservation for Shows of the Screen
     *     and sets the Status of the Reservation to CANCELLED and also sets the status of Payment to REFUNDED
     *     and validates If the CancelCount is equal to total count of Reservation then returns the true else false
     * </p>
     * @param screen - Holds the Details of the Screen
     * @return boolean - status of Cancellation
     */
    boolean cancelAllReservationsForShow(Screen screen);


    /**
     * <h1>
     *     getReservationDTOById
     * </h1>
     * <p>
     *     Retrieves the Details of the Reservation using the ID of the Reservation
     *     If Reservation not is Exist throws an Exception else returns the Details of Reservation
     * </p>
     *
     * @param id - ID of the Reservation
     * @return ReservationResponseDTO -  Holds the Response of the Reservation
     * @throws NotFoundException - when Reservation Not Found
     */
    ReservationResponseDTO getReservationDTOById(Long id) throws NotFoundException;

    /**
     * <h1>
     *     getReservationById
     * </h1>
     * <p>
     *     Retrieves the Details of the Reservation using the ID of the Reservation
     *     If Reservation not is Exist throws an Exception else returns the Details of Reservation
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
     *     Retrieves the List of the All Reservation Details using the ID of the User
     *     If Reservation not is Exist throws an Exception else returns the List of All Reservation
     * </p>
     *
     * @param id - ID of the User to find the Reservation for that User
     * @return List<ReservationResponseDTO> - Holds the List of Reservation for a User
     * @throws NoContentException - when No Reservations Found For User
     */
    List<ReservationResponseDTO> getAllReservationsByUserId(Long id) throws NoContentException;

    /**
     * <h1>
     *      getReservedSeats
     * </h1>
     * <p>
     *     Retrieves the List of All Reserved Seats for the Show ID by getting all the reservations for the Show
     *     and iterate and validates If the show is Booked then adds the seat to the List of reserved Seats
     *     and returns it.
     * </p>
     *
     * @param showId - ID of the Show to get Booking
     * @return List<Seat> - holds the Booked seats for a Show
     */
    List<Seat> getReservedSeats(Long showId);
}
