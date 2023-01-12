/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.ideas2movie.dto.ReservationDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ReservationResponseDTO;
import com.ideas2it.ideas2movie.service.ReservationService;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h1>
 *     BookingController
 * </h1>
 * <p>
 *     Gets the input parameter as a request from the Client and Validates them
 *     for creating, Updating, Deleting and Getting the Details of the Reservation
 *     and used to handle and mapping the request to appropriate function
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@RestController
@RequestMapping("/api/v1/bookings")
public class ReservationController {
    private final ReservationService reservationService;

    /**
     * <h1>
     *     ReservationController
     * </h1>
     * <p>
     *     Used to initialize the Services for calling the Operation performers of Service
     *     and also achieves the Autowiring
     * </p>
     *
     * @param reservationService - An instance of a ReservationService
     */
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /**
     * <h1>
     *     addReservation
     * </h1>
     * <p>
     *     Gets the RequestBody for Add the Reservation and Validates according to Validation Constraints
     *     and process the request by sending to ReservationService and returns the ReservationResponseDTO
     *     and Http Status or throws an Exception when occurred
     * </p>
     *
     * @param reservationDTO - holds the Details to reserve ticket
     * @return ResponseEntity - holds the Reservation Response DTO and Http Status
     */
    @PostMapping
    public ResponseEntity<ReservationResponseDTO> addReservation(@RequestBody ReservationDTO reservationDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.reserveSeats(reservationDTO));
    }

    /**
     * <h1>
     *     cancelReservation
     * </h1>
     * <p>
     *     Gets the PathVariable to cancel the Reservation and process the request by sending
     *     to ReservationService and returns the ReservationResponseDTO and Http Status
     *     or throws an Exception when occurred
     * </p>
     *
     * @param id - ID of the reservation to Cancel
     * @return ResponseEntity - Holds the ReservationResponseDTO and Http Status
     */
    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<ReservationResponseDTO> cancelReservation(@PathVariable("id") Long id)
            throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.cancelReservation(id));
    }

    /**
     * <h1>
     *     getReservationById
     * </h1>
     * <p>
     *     Gets the PathVariable to get the Details of the Reservation and process the request
     *     by sending to ReservationService and returns the ReservationResponseDTO and Http Status
     *     or throws an Exception when Occurred
     * </p>
     *
     * @param id - ID of the Reservation to Get details of Reservation
     * @return ResponseEntity - Holds the ReservationResponseDTO and Http Status
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponseDTO> getReservationById(@PathVariable("id") Long id)
            throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.getReservationDTOById(id));
    }

    /**
     * <h1>
     *     getAllReservationByUserId
     * </h1>
     * <p>
     *     Gets the PathVariable to get All the Details of the User By User ID and process the request
     *     by sending to ReservationService and returns the ReservationResponseDTO and Http Status
     *     or throws an Exception when occurred
     * </p>
     *
     * @param id - ID of the User to Get the Reservations of User
     * @return ResponseEntity - Holds the ReservationResponseDTO and Http Status
     */
    @GetMapping("/of-user/{id}")
    public ResponseEntity<List<ReservationResponseDTO>> getAllReservationByUserId(@PathVariable("id") Long id)
            throws NoContentException {
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.getAllReservationByUserId(id));
    }
}
