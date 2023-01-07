/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import com.ideas2it.ideas2movie.dto.BookingDTO;
import com.ideas2it.ideas2movie.dto.responsedto.BookingResponseDTO;
import com.ideas2it.ideas2movie.model.Booking;
import com.ideas2it.ideas2movie.repository.BookingRepository;
import com.ideas2it.ideas2movie.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final ModelMapper mapper = new ModelMapper();
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    public BookingResponseDTO makeBooking(BookingDTO bookingDTO) {
        Booking booking = mapper.map(bookingDTO, Booking.class);

        return  null;
    }
}
