/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import com.ideas2it.ideas2movie.dto.TicketDTO;
import com.ideas2it.ideas2movie.dto.responsedto.TicketResponseDTO;
import com.ideas2it.ideas2movie.model.Seat;
import com.ideas2it.ideas2movie.model.Ticket;
import com.ideas2it.ideas2movie.repository.TicketRepository;
import com.ideas2it.ideas2movie.service.SeatService;
import com.ideas2it.ideas2movie.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * <h1>
 *     Ticket Service Impl
 * </h1>
 * <p>
 *     Implements the Ticket Service and
 *     Holds the Business Logic
 *     to perform Book, Cancel and get the Ticket
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final SeatService seatService;
    private final ModelMapper mapper = new ModelMapper();

    public TicketServiceImpl(TicketRepository ticketRepository, SeatService seatService) {
        this.ticketRepository = ticketRepository;
        this.seatService = seatService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TicketResponseDTO bookTicket(TicketDTO ticketDTO) {
        Ticket ticket = mapper.map(ticketDTO, Ticket.class);

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TicketResponseDTO getTicketDTOById(Long id) {

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Ticket getTicketById(Long id) {

        return null;
    }
}
