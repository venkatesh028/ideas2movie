/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.model.Ticket;
import com.ideas2it.ideas2movie.dto.responsedto.TicketResponseDTO;
import com.ideas2it.ideas2movie.service.SeatService;
import com.ideas2it.ideas2movie.service.TicketService;
import com.ideas2it.ideas2movie.repository.TicketRepository;

/**
 * <h1>
 *     TicketServiceImpl
 * </h1>
 * <p>
 *     Implements the TicketService and
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
