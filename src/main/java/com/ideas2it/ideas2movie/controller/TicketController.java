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
 *     TicketController provides the RESTful Endpoints for handle the Retrieving
 *     Operation of the Ticket and validates according to the Validation Constraints
 *     and throws an exception when occurred and returns Details of the Ticket and HTtp Status
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
     *     Used to inject the TicketService dependency and initialize the ticketService variable
     * </p>
     *
     * @param ticketService - An instance of the TicketService
     */
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    /**
     * <h1>
     *     getTicketByID
     * </h1>
     * <p>
     *     Retrieves the Details of the Ticket By the ID of the Ticket
     *     and process the request If the Ticket is Not Found then throws an Exception
     *     otherwise returns the ResponseEntity with Http Status OK and Details of the Ticket
     * </p>
     *
     * @param id - ID of the Ticket to get
     * @return ResponseEntity - Holds the TicketResponseDTo and Http Status Ok
     * @throws NotFoundException - when Ticket Not Found
     */
    @GetMapping("/{id}")
    public ResponseEntity<TicketResponseDTO> getTicketById(@PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.getTicketDTOById(id));
    }
}
