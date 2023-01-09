/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.controller;

import com.ideas2it.ideas2movie.dto.ReservationDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ReservationResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>
 *     Booking Controller
 * </h1>
 * <p>
 *     Gets the input parameter as a request from the Client
 *     for create, Update, Get, Delete the Booking Details
 *     by sending those parameter or Object
 *     to the Booking Service to perform Business Logics on them
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@RestController
public class BookingController {
    private final ReservationService reservationService;

    public BookingController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /**
     * <h1>
     *     Book Ticket
     * </h1>
     * <p>
     *     Gets the Input parameter as a request form the Client
     *     to book Tickets for a show
     *     by sending the Reservation DTO to the Reservation Service
     *     to perform Business logic to book ticket
     * </p>
     *
     * @param reservationDTO - holds the Details to book ticket
     * @return ResponseEntity - holds the Reservation Response DTO and Http Status
     * @throws AlreadyExistException - when seats already booked
     */
    @PostMapping
    public ResponseEntity<ReservationResponseDTO> bookTicket(@RequestBody ReservationDTO reservationDTO) throws AlreadyExistException {
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.makeBooking(reservationDTO));
    }
}
