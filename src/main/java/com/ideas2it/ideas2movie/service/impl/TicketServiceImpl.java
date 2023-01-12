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
import com.ideas2it.ideas2movie.service.SeatService;
import com.ideas2it.ideas2movie.service.TicketService;
import com.ideas2it.ideas2movie.repository.TicketRepository;
import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.exception.NotFoundException;
/**
 * <h1>
 *     TicketServiceImpl
 * </h1>
 * <p>
 *     Implements the TicketService and Provides the Business Logics
 *     to generate and get the Details of the ticket
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
    public Ticket generateTicket(Reservation reservation) {
        Ticket ticket  = new Ticket();
        ticket.setNumberOfSeatsSelected(reservation.getSeats().size());
        ticket.setReservationStatus(reservation.getStatus());
        ticket.setScreenName(reservation.getShow().getScreen().getName());
        ticket.setTheaterName(reservation.getShow().getScreen().getTheater().getTheaterName());
        ticket.setShowDate(reservation.getShow().getScreeningDate());
        List<Seat> seats = reservation.getSeats();
        String seatName = "";

        for(Seat seat: seats) {
            seatName += seat.getName() + ",";
        }
        ticket.setSeats(seatName);
        ticket.setMovieName(reservation.getShow().getMovie().getName());
        return ticketRepository.save(ticket);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TicketResponseDTO getTicketDTOById(Long id) throws NotFoundException {
        Optional<Ticket> existingTicket = ticketRepository.findById(id);

        if (existingTicket.isEmpty()) {
            throw new NotFoundException(Message.TICKET_NOT_FOUND);
        }
        return null;
    }
}
