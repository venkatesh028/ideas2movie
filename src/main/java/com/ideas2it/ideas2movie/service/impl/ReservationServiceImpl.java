/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import com.ideas2it.ideas2movie.dto.ReservationDTO;
import com.ideas2it.ideas2movie.dto.responsedto.ReservationResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.model.Reservation;
import com.ideas2it.ideas2movie.model.Seat;
import com.ideas2it.ideas2movie.repository.ReservationRepository;
import com.ideas2it.ideas2movie.service.ReservationService;
import com.ideas2it.ideas2movie.util.constant.Message;
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
    public ReservationResponseDTO makeBooking(ReservationDTO reservationDTO) throws AlreadyExistException {
        Reservation newReservation = mapper.map(reservationDTO, Reservation.class);
        List<Reservation> oldReservations = reservationRepository.findAllByShowId(newReservation.getShow().getId());

        List<Seat> reservedSeats;
        List<Seat> selectedSeats = newReservation.getSeats();
        List<Seat> bookedSeats = new ArrayList<>();

        for (Reservation oldReservation : oldReservations) {
            reservedSeats = oldReservation.getSeats();

            for (Seat seat: selectedSeats) {
                if (reservedSeats.contains(seat)) {
                    bookedSeats.add(seat);
                }
                throw new AlreadyExistException(bookedSeats + Message.SEAT_ALREADY_BOOKED);
            }

        }

        return  mapper.map(reservationRepository.save(newReservation), ReservationResponseDTO.class);
    }

    @Override
    public ReservationResponseDTO cancelBooking(Long id) {
        return null;
    }

    @Override
    public ReservationResponseDTO getBookingById(Long id) {
        return null;
    }

    @Override
    public List<ReservationResponseDTO> getAllBookingByUserId(Long id) {
        return null;
    }
}
