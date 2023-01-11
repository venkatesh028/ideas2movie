/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import com.ideas2it.ideas2movie.model.Screen;
import com.ideas2it.ideas2movie.model.Show;
import com.ideas2it.ideas2movie.service.TicketService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.model.Reservation;
import com.ideas2it.ideas2movie.model.Seat;
import com.ideas2it.ideas2movie.dto.ReservationDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ReservationResponseDTO;
import com.ideas2it.ideas2movie.service.ReservationService;
import com.ideas2it.ideas2movie.repository.ReservationRepository;
import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.util.enums.ReservationStatus;
import com.ideas2it.ideas2movie.util.enums.PaymentStatus;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h1>
 *     BookingServiceImpl
 * </h1>
 * <p>
 *     Implements the BookingService and Provides the Business Logics
 *     to make, cancel and get the Details of the Reservation
 *     and Throws an Exception when occurred
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final TicketService ticketService;
    private final ModelMapper mapper = new ModelMapper();
    public ReservationServiceImpl(ReservationRepository reservationRepository, TicketService ticketService) {
        this.reservationRepository = reservationRepository;
        this.ticketService = ticketService;
    }

    /**
     * {@inheritDoc}
     */
    public ReservationResponseDTO reserveSeats(ReservationDTO reservationDTO) {
        Reservation newReservation = mapper.map(reservationDTO, Reservation.class);
        newReservation.setStatus(ReservationStatus.PROCESSING);
        newReservation.setTotalPrice(newReservation.getSeats().size() * newReservation.getShow().getPrice());
        return mapper.map(reservationRepository.save(newReservation), ReservationResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    public ReservationResponseDTO confirmReservation(Reservation reservation) {
        Reservation existingReservation = reservationRepository.findById(reservation.getId()).get();
        existingReservation.setPayment(reservation.getPayment());

        if (reservation.getPayment().getStatus().equals(PaymentStatus.PAID)) {
            existingReservation.setStatus(ReservationStatus.BOOKED);
            existingReservation.setTicket(ticketService.generateTicket(existingReservation));
        } else {
            existingReservation.setStatus(ReservationStatus.CANCELED);
        }
        return mapper.map(reservationRepository.save(existingReservation), ReservationResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReservationResponseDTO cancelReservation(Long id) throws NotFoundException {
        Optional<Reservation> existingReservation = reservationRepository.findById(id);

        if (existingReservation.isEmpty()) {
            throw new NotFoundException(Message.RESERVATION_NOT_FOUND);
        }
        Reservation reservation = existingReservation.get();

        if (reservation.getStatus().equals(ReservationStatus.BOOKED)
                || reservation.getStatus().equals(ReservationStatus.PROCESSING)) {
            reservation.setStatus(ReservationStatus.CANCELED);
            reservation.getPayment().setStatus(PaymentStatus.REFUNDED);
        }
        return mapper.map(reservationRepository.save(reservation), ReservationResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cancelAllReservationForShow(Screen screen) {
        List<Show> shows = screen.getShows();
        List<Reservation> reservations = new ArrayList<>();
        int canceledCount = 0;
        boolean isCanceled;

        for (Show show: shows) {
             reservations = reservationRepository.findAllByShowId(show.getId());
        }

        if (reservations.isEmpty()) {
            isCanceled = true;
        } else {
            for (Reservation reservation: reservations) {
                reservation.setStatus(ReservationStatus.CANCELED);
                reservationRepository.save(reservation);
                canceledCount++;
            }

            isCanceled = (canceledCount == reservations.size());
        }
        return isCanceled;
    }

    /**
     * {@inheritDoc}
     */
    public List<Seat> getReservedSeats(Long showId) {
        List<Reservation> oldReservations = reservationRepository.findAllByShowId(showId);
        List<Seat> bookedSeats = new ArrayList<>();

        for (Reservation oldReservation : oldReservations) {
            if(oldReservation.getStatus().equals(ReservationStatus.BOOKED)) {
                bookedSeats = oldReservation.getSeats();
            }
        }
        return bookedSeats;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReservationResponseDTO getReservationDTOById(Long id) throws NotFoundException {
        Optional<Reservation>  reservation = reservationRepository.findById(id);

        if (reservation.isEmpty()) {
            throw new NotFoundException(Message.RESERVATION_NOT_FOUND);
        }
        return mapper.map(reservation.get(), ReservationResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Reservation getReservationById(Long id) throws NotFoundException {
        Optional<Reservation> reservation = reservationRepository.findById(id);

        if (reservation.isEmpty()) {
            throw new NotFoundException(Message.RESERVATION_NOT_FOUND);
        }
        return reservation.get();

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ReservationResponseDTO> getAllReservationByUserId(Long id) {
        List<Reservation> reservations = reservationRepository.findAllByUserId(id);
        List<ReservationResponseDTO> responseDTOS = new ArrayList<>();

        for (Reservation reservation: reservations) {
            responseDTOS.add(mapper.map(reservation, ReservationResponseDTO.class));
        }
        return responseDTOS;
    }
}
