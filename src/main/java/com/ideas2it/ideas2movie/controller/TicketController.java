/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.ideas2movie.dto.responsedto.TicketResponseDTO;
import com.ideas2it.ideas2movie.service.TicketService;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h1>
 *     TicketController
 * </h1>
 * <p>
 *     Gets the Input parameter as a Request from the Client and Validates them
 *     for get the Details of the Ticket
 *     and used to handle and mapping the Request to the Appropriate function
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@RestController
@RequestMapping("api/v1/tickets")
public class TicketController {
    private final TicketService ticketService;

    /**
     * <h1>
     *     TicketController Constructor
     * </h1>
     * <p>
     *     Used to initialize the Services for calling the Operation performers of Service
     *     and also achieves the Autowiring
     * </p>
     *
     * @param ticketService - An instance of the Ticket Service
     */
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * <h1>
     *     getTicketByID
     * </h1>
     * <p>
     *     Gets the PathVariable to get the Details of the Ticket
     *     and Process the request by sending to TicketService and returns the TicketResponseDTO and Http status
     *     or throws an Exception when occurred
     * </p>
     *
     * @param id - ID of the Ticket to get
     * @return ResponseEntity - Holds the TicketResponseDTo and Http Status
     */
    @GetMapping("/{id}")
    public ResponseEntity<TicketResponseDTO> getTicketById(@PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.getTicketDTOById(id));
    }
}
