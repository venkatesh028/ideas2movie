/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.model.Payment;
import com.ideas2it.ideas2movie.model.Reservation;
import com.ideas2it.ideas2movie.model.Screen;
import com.ideas2it.ideas2movie.model.Seat;
import com.ideas2it.ideas2movie.model.Show;
import com.ideas2it.ideas2movie.model.User;
import com.ideas2it.ideas2movie.dto.ReservationDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ReservationResponseDTO;
import com.ideas2it.ideas2movie.service.ReservationService;
import com.ideas2it.ideas2movie.service.SeatService;
import com.ideas2it.ideas2movie.service.TicketService;
import com.ideas2it.ideas2movie.repository.ReservationRepository;
import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.util.enums.ReservationStatus;
import com.ideas2it.ideas2movie.util.enums.PaymentStatus;
import com.ideas2it.ideas2movie.exception.BadRequestException;
import com.ideas2it.ideas2movie.exception.NoContentException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.logger.CustomLogger;

/**
 * <h2>
 *     ReservationServiceImpl
 * </h2>
 * <p>
 *     ReservationServiceImpl provides the Business Logic to handle the Reservation for Seats of the Show
 *     Like Reserving the Seats, Cancel reservation of Seats for the Show
 *     and Retrieving the Details of the Reservation based on reservation ID and User ID form the storage
 *     and throws an Exception when occurred
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
    private final SeatService seatService;
    private final CustomLogger logger = new CustomLogger(ReservationServiceImpl.class);
    private final ModelMapper mapper = new ModelMapper();

    /**
     * <h1>
     *     ReservationServiceImpl Constructor
     * </h1>
     * <p>
     *     Used to inject the ReservationRepository, TicketService, SeatService
     *     and initialize the reservationRepository, ticketService, seatService variables
     * </p>
     *
     * @param reservationRepository - An instance of the ReservationRepository
     * @param ticketService - An instance of the TicketService
     * @param seatService - An instance of the SeatService
     */
    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  TicketService ticketService,
                                  SeatService seatService) {
        this.reservationRepository = reservationRepository;
        this.ticketService = ticketService;
        this.seatService = seatService;
    }

    /**
     * {@inheritDoc}
     */
    public ReservationResponseDTO reserveSeats(ReservationDTO reservationDTO) throws BadRequestException {
        logger.info("Inside the ReservationServiceImpl reserve Seats");
        Reservation newReservation = mapper.map(reservationDTO, Reservation.class);
        newReservation.setStatus(ReservationStatus.PROCESSING);
        newReservation.setUser(mapper.map(reservationDTO.getUser(), User.class));
        newReservation.getShow().setId(reservationDTO.getShow().getId());
        List<Seat> seats = new ArrayList<>();

        try {
            for (Long id : reservationDTO.getIdsOfSeats()) {
                seats.add(seatService.getSeatById(id));
            }
        } catch (NotFoundException notFoundException) {
            logger.error(notFoundException.getMessage());
            throw new BadRequestException(notFoundException.getMessage());
        }
        newReservation.setSeats(seats);
        newReservation.setTotalPrice(newReservation.getSeats().size() * newReservation.getShow().getPrice());
        return mapper.map(reservationRepository.save(newReservation), ReservationResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    public ReservationResponseDTO confirmReservation(Payment payment) throws NotFoundException {
        logger.info("Inside the ReservationServiceImpl confirm reservation");
        Optional<Reservation> existingReservation = reservationRepository.findById(payment.getReservation().getId());

        if (existingReservation.isEmpty()) {
            logger.error(Message.RESERVATION_NOT_FOUND);
            throw new NotFoundException(Message.RESERVATION_NOT_FOUND);
        }

        Reservation reservation = existingReservation.get();

        if (payment.getStatus().equals(PaymentStatus.PAID)) {
            reservation.setStatus(ReservationStatus.BOOKED);
            reservation.setTicket(ticketService.generateTicket(reservation));
        } else {
            reservation.setStatus(ReservationStatus.CANCELED);
        }
        return mapper.map(reservationRepository.save(reservation), ReservationResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReservationResponseDTO cancelReservationById(Long id) throws NotFoundException {
        logger.info("Inside the ReservationServiceImpl cancel reservation");
        Optional<Reservation> existingReservation = reservationRepository.findById(id);

        if (existingReservation.isEmpty()) {
            logger.error(Message.RESERVATION_NOT_FOUND);
            throw new NotFoundException(Message.RESERVATION_NOT_FOUND);
        }
        Reservation reservation = existingReservation.get();

        if (reservation.getStatus().equals(ReservationStatus.BOOKED)
                || reservation.getStatus().equals(ReservationStatus.PROCESSING)) {
            reservation.setStatus(ReservationStatus.CANCELED);
        }
        return mapper.map(reservationRepository.save(reservation), ReservationResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cancelAllReservationsForShow(Screen screen) {
        logger.info("Inside the ReservationServiceImpl cancel all reservation for show");
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
    @Override
    public ReservationResponseDTO getReservationDTOById(Long id) throws NotFoundException {
        logger.info("Inside the ReservationServiceImpl get reservationDTO by ID");
        Optional<Reservation>  reservation = reservationRepository.findById(id);

        if (reservation.isEmpty()) {
            logger.error(Message.RESERVATION_NOT_FOUND);
            throw new NotFoundException(Message.RESERVATION_NOT_FOUND);
        }
        return mapper.map(reservation.get(), ReservationResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Reservation getReservationById(Long id) throws NotFoundException {
        logger.info("Inside the ReservationServiceImpl get reservation by ID");
        Optional<Reservation> reservation = reservationRepository.findById(id);

        if (reservation.isEmpty()) {
            logger.error(Message.RESERVATION_NOT_FOUND);
            throw new NotFoundException(Message.RESERVATION_NOT_FOUND);
        }
        return reservation.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ReservationResponseDTO> getAllReservationsByUserId(Long id) throws NoContentException {
        logger.info("Inside the ReservationServiceImpl get all Reservation by user Id");
        List<Reservation> reservations = reservationRepository.findAllByUserId(id);

        if (reservations.isEmpty()) {
            logger.error(Message.RESERVATION_NOT_FOUND);
            throw new NoContentException(Message.RESERVATION_NOT_FOUND);
        }
        List<ReservationResponseDTO> responseDTOS = new ArrayList<>();

        for (Reservation reservation: reservations) {
            responseDTOS.add(mapper.map(reservation, ReservationResponseDTO.class));
        }
        return responseDTOS;
    }

    /**
     * {@inheritDoc}
     */
    public List<Seat> getReservedSeats(Long showId) {
        logger.info("Inside the ReservationServiceImpl get reserved Seats");
        List<Reservation> oldReservations = reservationRepository.findAllByShowId(showId);
        List<Seat> bookedSeats = new ArrayList<>();

        for (Reservation oldReservation : oldReservations) {
            if (oldReservation.getStatus().equals(ReservationStatus.BOOKED)) {
                bookedSeats = oldReservation.getSeats();
            }
        }
        return bookedSeats;
    }
}
