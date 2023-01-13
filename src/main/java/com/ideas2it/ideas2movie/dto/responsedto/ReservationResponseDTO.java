/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto.responsedto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

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
    private TicketResponseDTO ticketResponseDTO;
    private PaymentResponseDTO paymentResponseDTO;
    private ShowResponseDTO showResponseDTO;
    private List<ShowResponseDTO> seats;
    private double price;
}
