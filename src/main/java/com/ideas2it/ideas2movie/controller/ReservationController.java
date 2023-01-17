/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.controller;

import java.util.List;

import jakarta.validation.Valid;

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
import com.ideas2it.ideas2movie.exception.BadRequestException;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h1>
 *     ReservationController
 * </h1>
 * <p>
 *     ReservationController provides the RESTful endpoints to Handle the CRUD Operation for the Reservation
 *     of the Seats for Show and validates the Information of Reservation according to validation Constraints
 *     If not valid throws anException otherwise returns the Details of Reservation and Http Status
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    /**
     * <h1>
     *     ReservationController
     * </h1>
     * <p>
     *     Used to inject the ReservationService dependency
     *     and initialize the reservationService variable
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
     *     Adds a new reservation of the Seat for a Show by the User by validating the ReservationDTO
     *     according to the Validation constraints If any Details is Not valida throws an Exception
     *     else process the request and returns the ResponseEntity with Http Status OK
     *     and Details of Reservation or throws an Exception when occurred
     * </p>
     *
     * @param reservationDTO - holds the Details to reserve ticket
     * @return ResponseEntity - holds the Reservation Response DTO and Http Status CREATED
     * @throws BadRequestException - When Seat is Not Found
     */
    @PostMapping
    public ResponseEntity<ReservationResponseDTO> addReservation(@Valid @RequestBody ReservationDTO reservationDTO)
            throws BadRequestException {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.reserveSeats(reservationDTO));
    }

    /**
     * <h1>
     *     cancelReservation
     * </h1>
     * <p>
     *     Cancels the Reservation of the Seats for the Show by the ID of the reservation
     *     by processing the Request and returns the ResponseEntity with the Http Status OK
     *     and Details of the Reservation or throws an Exception when occurred
     * </p>
     *
     * @param id - ID of the reservation to Cancel
     * @return ResponseEntity - Holds the ReservationResponseDTO and Http Status
     * @throws NotFoundException - When Reservation Not Found
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
     *     Retrieves the Details of the Reservation by the ID of the Reservation
     *     by processing the request and returns the ResponseEntity with Http Status OK
     *     and Details of the Reservation or throws an Exception when occurred
     * </p>
     *
     * @param id - ID of the Reservation to Get details of Reservation
     * @return ResponseEntity - Holds the ReservationResponseDTO and Http Status
     * @throws NotFoundException - When Reservation Not Found
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
     *     Retrieves the Details of the All Reservations for the User by the User ID
     *     by processing the request and returns the ResponseEntity with Http Status OK
     *     and Details of the All Reservations for User or throws an Exception when occurred
     * </p>
     *
     * @param id - ID of the User to Get the Reservations of User
     * @return ResponseEntity - Holds the ReservationResponseDTO and Http Status
     * @throws NoContentException - When there is No Reservation Found for User
     */
    @GetMapping("/of-user/{id}")
    public ResponseEntity<List<ReservationResponseDTO>> getAllReservationByUserId(@PathVariable("id") Long id)
            throws NoContentException {
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.getAllReservationByUserId(id));
    }
}
