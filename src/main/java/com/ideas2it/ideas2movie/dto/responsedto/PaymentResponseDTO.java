/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto.responsedto;

import com.ideas2it.ideas2movie.util.enums.PaymentStatus;
import java.sql.Timestamp;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

/**
 * <h1>
 *     PaymentResponseDTO
 * </h1>
 * <p>
 *     PaymentResponseDTO represents the Response sent to the Client with ID of Payment
 *     after Making and Updating the Details of payment for Reservation
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@Getter
@Setter
public class PaymentResponseDTO {
    private Long paymentId;
    private UUID transactionId;
    private Timestamp paidAt;
    private double amount;
    private PaymentStatus status;
}
