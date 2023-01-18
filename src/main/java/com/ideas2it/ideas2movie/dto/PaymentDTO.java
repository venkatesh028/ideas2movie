/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.util.enums.ModeOfPayment;

/**
 * <h2>
 *     PaymentDTO
 * </h2>
 * <p>
 *     PaymentDTO represents the Simplified version of Payment Model
 *     which Holds the Details of the payment to Get from User to pay for Reservation
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@Getter
@Setter
@NoArgsConstructor
public class PaymentDTO {
    @NotNull(message = Message.RESERVATION_ID_SHOULD_NOT_BE_EMPTY)
    private Long reservationId;
    @NotNull(message = Message.PAYMENT_MODE_SHOULD_NOT_BE_EMPTY)
    private ModeOfPayment modeOfPayment;
    @NotNull(message = Message.AMOUNT_SHOULD_NOT_BE_EMPTY)
    private Double enteredAmount;
}
