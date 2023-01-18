/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import com.ideas2it.ideas2movie.model.Reservation;
import com.ideas2it.ideas2movie.model.Ticket;
import com.ideas2it.ideas2movie.dto.responsedto.TicketResponseDTO;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h2>
 *     TicketService
 * </h2>
 * <p>
 *     TicketService provides the methods for generating the Tickets for a Reservation
 *     and to get the Details of the Ticket by the ID
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
public interface TicketService {
    /**
     * <h1>
     *     generateTicket
     * </h1>
     * <p>
     *     Generates the Ticket for the Reservation By Sets the properties of the ticket
     *     from the given reservation and returns the Details of the Generated Ticket
     * </p>
     *
     * @param reservation - Holds the Details of the Reservation
     * @return Ticket - Holds the Details of the Ticket
     */
    Ticket generateTicket(Reservation reservation);

    /**
     * <h1>
     *     getTicketDTOById
     * </h1>
     * <p>
     *     Retrieves the Details of the Ticket by ID of the Ticket
     *     and Validates If the Ticket is Not Exist throws the Exception
     *     else returns the Details of the Ticket
     * </p>
     *
     * @param id - ID of the Ticket to Get the Ticket Details
     * @return TicketResponseDTO - Holds the response of the Ticket
     * @throws NotFoundException - when Ticket is Not Found
     */
    TicketResponseDTO getTicketDTOById(Long id) throws NotFoundException;
}
