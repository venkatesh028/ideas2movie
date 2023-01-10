/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import com.ideas2it.ideas2movie.dto.TicketDTO;
import com.ideas2it.ideas2movie.dto.responsedto.TicketResponseDTO;
import com.ideas2it.ideas2movie.model.Ticket;

/**
 * <h1>
 *     TicketService
 * </h1>
 * <p>
 *     Service Layer for Ticket
 *     to Book, Cancel and get the Ticket
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
public interface TicketService {
    /**
     * <h1>
     *     bookTicket
     * </h1>
     * <p>
     *     Books the Ticket
     *     by getting the TicketDTO from Controller
     *     and performs the Calculation for ticket price
     *     and returns the Response accordingly
     * </p>
     *
     * @param ticketDTO - Holds the Details of the Ticket to Book
     * @return TicketResponseDTO - Holds the response of the Booked Ticket
     */
    TicketResponseDTO addTicket(TicketDTO ticketDTO);

    /**
     * <h1>
     *     getTicketDTOById
     * </h1>
     * <p>
     *     Gets the Ticket
     *     by getting the ID of the ticket from Controller
     *     and checks whether the ticket is present or not
     *     and returns the response accordingly
     * </p>
     *
     * @param id - ID of the Ticket to Get the Ticket Details
     * @return TicketResponseDTO - Holds the response of the Ticket
     */
    TicketResponseDTO getTicketDTOById(Long id);

    /**
     * <h1>
     *      getTicketById
     * </h1>
     * <p>
     *      Gets the Ticket
     *      by getting the ID of the ticket from Controller
     *      and checks whether the ticket is present or not
     *      and returns the response accordingly
     * </p>
     *
     * @param id - ID of the Ticket to Get the Ticket Details
     * @return Ticket - Holds the response of the Ticket
     */
    Ticket getTicketById(Long id);
}
