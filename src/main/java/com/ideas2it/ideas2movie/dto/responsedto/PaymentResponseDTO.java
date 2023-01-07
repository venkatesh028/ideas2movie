/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto.responsedto;

import java.sql.Timestamp;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

/**
 * <h1>
 *     Payment Response DTO
 * </h1>
 * <p>
 *     Contains the Response of the Payment Entity
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@Getter
@Setter
public class PaymentResponseDTO {
    private Long id;
    private Long ticketId;
    private Timestamp paidAt;
    private UUID transactionId;
    private double amount;
    private String status;
}
