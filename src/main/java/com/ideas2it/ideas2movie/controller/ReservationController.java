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
 *     Gets the input parameter as a request from the Client
 *     for create, Update, Get, Delete the Reservation Details
 *     by handling and mapping the request to appropriate function
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
     *     Gets the Input parameter as a request form the Client to Add reservation for a show
     *     by sending the Reservation DTO to the Reservation Service
     *     to perform Business logic to ass Reservation
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
     *     Gets the Input Parameter as a Request from the Client to Cancel the Reservation
     *     for a Show by sending the Reservation ID to Reservation Service
     *     to perform Business Logic to Cancel reservation
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
     *     Gets the Input parameter as a Request from the Client to get the reservation details
     *     for a show by sending the reservation ID to the Reservation Service
     *     to perform Business Logic to get Reservation
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
     *     Gets the Input parameter as a Request from the Client to get All Reservations of a User
     *     By sending the User ID to the Reservation Service
     *     to perform Business Logic to get Reservation of User
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
