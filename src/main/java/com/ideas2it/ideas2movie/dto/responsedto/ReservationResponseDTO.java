/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto.responsedto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import com.ideas2it.ideas2movie.model.Show;
import com.ideas2it.ideas2movie.model.Ticket;


/**
 * <h1>
 *     BookingResponseDTO
 * </h1>
 * <p>
 *     BookingResponseDTO represents the Response sent to the Client with the ID of Reservation
 *     after Creating and Updating the Details of Reservation for Seats of the Show.
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@Getter
@Setter
public class ReservationResponseDTO {
    private Long id;
    private TicketResponseDTO ticket;
    private ShowResponseDTO show;
    private double price;
}
