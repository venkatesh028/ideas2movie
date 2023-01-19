/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.model.Reservation;
import com.ideas2it.ideas2movie.model.Seat;
import com.ideas2it.ideas2movie.model.Ticket;
import com.ideas2it.ideas2movie.dto.responsedto.TicketResponseDTO;
import com.ideas2it.ideas2movie.service.TicketService;
import com.ideas2it.ideas2movie.repository.TicketRepository;
import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.logger.CustomLogger;

/**
 * <h2>
 *     TicketServiceImpl
 * </h2>
 * <p>
 *     TicketServiceImpl Provides the Business Logics for Generate the Ticket for Reservation
 *     and Fetches the Details of the Ticket from the Storage
 *     and throws an Exception when occurred
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final CustomLogger logger = new CustomLogger(TicketServiceImpl.class);
    private final ModelMapper mapper = new ModelMapper();

    /**
     * <h1>
     *     TicketServiceImpl Constructor
     * </h1>
     * <p>
     *      Used to inject the TicketRepository dependency and initialize the ticketRepository variable
     * </p>
     *
     * @param ticketRepository -  Instance of the TicketRepository
     */
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Ticket generateTicket(Reservation reservation) {
        logger.info("Inside the TicketServiceImpl generate Ticket");
        Ticket ticket  = new Ticket();
        ticket.setNumberOfSeatsSelected(reservation.getSeats().size());
        ticket.setReservationStatus(reservation.getStatus());
        ticket.setShowId(reservation.getShow().getId());
        ticket.setScreenName(reservation.getShow().getScreen().getName());
        ticket.setTheaterName(reservation.getShow().getScreen().getTheater().getTheaterName());
        ticket.setMovieName(reservation.getShow().getMovie().getName());
        ticket.setShowDate(reservation.getShow().getScreeningDate());
        ticket.setReservationStatus(reservation.getStatus());
        List<Seat> seats = reservation.getSeats();
        StringBuilder seatName = new StringBuilder();

        for(Seat seat: seats) {
            seatName.append(seat.getName()).append(",");
        }
        ticket.setSeats(seatName.toString());
        ticket.setMovieName(reservation.getShow().getMovie().getName());
        return ticketRepository.save(ticket);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TicketResponseDTO getTicketDTOById(Long id) throws NotFoundException {
        logger.info("Inside the TicketServiceImpl  get Ticket DTO by ID");
        Optional<Ticket> existingTicket = ticketRepository.findById(id);

        if (existingTicket.isEmpty()) {
            logger.error(Message.TICKET_NOT_FOUND);
            throw new NotFoundException(Message.TICKET_NOT_FOUND);
        }
        return mapper.map(existingTicket.get(), TicketResponseDTO.class);
    }
}
