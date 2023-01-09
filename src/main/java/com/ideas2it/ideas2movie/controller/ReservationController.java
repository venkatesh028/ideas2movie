/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.controller;

import com.ideas2it.ideas2movie.dto.ReservationDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ReservationResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.service.ReservationService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.stylesheets.LinkStyle;

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
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
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

    @DeleteMapping("{/id}")
    public ResponseEntity<ReservationResponseDTO> cancelBooking(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.cancelBooking(id));
    }

    @GetMapping("{/id}")
    public ResponseEntity<ReservationResponseDTO> getBookingById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.getBookingById(id));
    }

    @GetMapping("{/all-booking/id")
    public ResponseEntity<List<ReservationResponseDTO>> getAllBookingByUserId(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.getAllBookingByUserId(id));
    }
}
