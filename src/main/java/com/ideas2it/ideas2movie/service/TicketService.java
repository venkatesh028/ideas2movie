/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import com.ideas2it.ideas2movie.dto.responsedto.TicketResponseDTO;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.model.Reservation;
import com.ideas2it.ideas2movie.model.Ticket;

/**
 * <h1>
 *     TicketService
 * </h1>
 * <p>
 *     TicketService used to manage the Operation for the Ticket
 *     Like Creating, Updating, Viewing the Details of the Ticket
 *     and throwing the Exceptions accordingly
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
     *     gets the Reservation Model to Generate a unique ticket for the Given Reservation
     *     by getting the Details of the movie , show and theater form the reservation
     *     and returns the Reservation by setting the Ticket in it
     * </p>
     * @param reservation
     * @return
     */
    Ticket generateTicket(Reservation reservation);

    /**
     * <h1>
     *     getTicketDTOById
     * </h1>
     * <p>
     *     Gets the Ticket by getting the ID of the ticket from Controller
     *     and checks whether the ticket is present or not
     *     and returns the response accordingly
     * </p>
     *
     * @param id - ID of the Ticket to Get the Ticket Details
     * @return TicketResponseDTO - Holds the response of the Ticket
     */
    TicketResponseDTO getTicketDTOById(Long id) throws NotFoundException;

    /**
     * <h1>
     *      getTicketById
     * </h1>
     * <p>
     *      Gets the Ticket by getting the ID of the ticket from Controller
     *      and checks whether the ticket is present or not
     *      and returns the response accordingly
     * </p>
     *
     * @param id - ID of the Ticket to Get the Ticket Details
     * @return Ticket - Holds the response of the Ticket
     */
    Ticket getTicketById(Long id);
}
