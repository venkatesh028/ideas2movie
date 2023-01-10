/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import com.ideas2it.ideas2movie.dto.ReservationDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ReservationResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.model.Payment;
import com.ideas2it.ideas2movie.model.Reservation;
import com.ideas2it.ideas2movie.model.Seat;
import com.ideas2it.ideas2movie.model.Show;
import com.ideas2it.ideas2movie.repository.ReservationRepository;
import com.ideas2it.ideas2movie.service.ReservationService;
import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.util.enums.BookingStatus;
import com.ideas2it.ideas2movie.util.enums.PaymentStatus;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * <h1>
 *     Booking Service Impl
 * </h1>
 * <p>
 *     Implements the Booking Service and
 *     Holds the Business Logic to perform
 *     make, cancel and get the Bookings
 *     for a User
 * </p>
 */
@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final ModelMapper mapper = new ModelMapper();
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    /**
     * {@inheritDoc}
     */
    public ReservationResponseDTO reserveSeats(ReservationDTO reservationDTO) {
        Reservation newReservation = mapper.map(reservationDTO, Reservation.class);
        newReservation.setStatus(BookingStatus.PROCESSING);
        newReservation.setTotalPrice(newReservation.getSeats().size() * newReservation.getShow().getPrice());
        return mapper.map(reservationRepository.save(newReservation), ReservationResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    public List<Seat> getReservedSeats(Long showId) {
        List<Reservation> oldReservations = reservationRepository.findAllByShowId(showId);

        List<Seat> bookedSeats = new ArrayList<>();

        for (Reservation oldReservation : oldReservations) {
            if(oldReservation.getStatus().equals(BookingStatus.BOOKED)) {
                bookedSeats = oldReservation.getSeats();
            }
        }
        return bookedSeats;
    }

    /**
     * {@inheritDoc}
     */
    public ReservationResponseDTO confirmReservation(Reservation reservation) {
        Reservation existingReservation = reservationRepository.findById(reservation.getId()).get();
        existingReservation.setPayment(reservation.getPayment());

        if (reservation.getPayment().getStatus().equals(PaymentStatus.PAID)) {
            existingReservation.setStatus(BookingStatus.BOOKED);
        } else {
            existingReservation.setStatus(BookingStatus.CANCELED);
        }

        return mapper.map(reservationRepository.save(existingReservation), ReservationResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReservationResponseDTO cancelBooking(Long id) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReservationResponseDTO getReservationDTOById(Long id) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Reservation getReservationById(Long id) {

        return null;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<ReservationResponseDTO> getAllReservationByUserId(Long id) {
        return null;
    }
}
