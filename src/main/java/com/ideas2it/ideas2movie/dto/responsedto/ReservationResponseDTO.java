/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto.responsedto;

import lombok.Getter;
import lombok.Setter;

/**
 * <h1>
 *     Booking Response DTO
 * </h1>
 * <p>
 *     Contains the Response of the Booking Entity
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
}
