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
    public ReservationResponseDTO reserveSeats(ReservationDTO reservationDTO) throws AlreadyExistException {
        Reservation newReservation = mapper.map(reservationDTO, Reservation.class);
        List<Long> reservedSeats = getReservedSeats(newReservation);

        if (!reservedSeats.isEmpty()) {
            throw new AlreadyExistException(reservedSeats + Message.SEAT_ALREADY_BOOKED);
        } else {
            newReservation.setStatus(BookingStatus.PROCESSING);
            return mapper.map(reservationRepository.save(newReservation), ReservationResponseDTO.class);
        }
    }

    /**
     * {@inheritDoc}
     */
    private List<Long> getReservedSeats(Reservation reservation) {
        List<Reservation> oldReservations = reservationRepository.findAllByShowId(reservation.getShow().getId());

        List<Seat> bookedSeats;
        List<Seat> selectedSeats = reservation.getSeats();
        List<Long> reservedSeats = new ArrayList<>();

        for (Reservation oldReservation : oldReservations) {
            bookedSeats = oldReservation.getSeats();

            for (Seat seat : selectedSeats) {
                if (bookedSeats.contains(seat)) {
                    reservedSeats.add(seat.getId());
                }
            }
        }
        return reservedSeats;
    }

    /**
     * {@inheritDoc}
     */
    public ReservationResponseDTO confirmBooking(Reservation reservation, Payment payment) {
        Reservation existingReservation = reservationRepository.findById(reservation.getId()).get();
        existingReservation.setPayment(payment);

        if (payment.getStatus().equals(PaymentStatus.PAID)) {
            existingReservation.setStatus(BookingStatus.BOOKED);
        } else {
            existingReservation.setStatus(BookingStatus.CANCELED);
        }
        return null;
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
    public ReservationResponseDTO getBookingById(Long id) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ReservationResponseDTO> getAllBookingByUserId(Long id) {
        return null;
    }
}
