/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.util.enums.ModeOfPayment;

/**
 * <h1>
 *     PaymentDTO
 * </h1>
 * <p>
 *     PaymentDTO represents the Simplified version of Payment Model
 *     which Holds the Details of the payment to Get from User to pay for Reservation
 * </p>
 */
@Getter
@Setter
@NoArgsConstructor
public class PaymentDTO {
    @NotNull
    private Long reservationId;
    @NotNull(message = Message.PAYMENT_MODE_SHOULD_NOT_BE_EMPTY)
    //@Pattern(regexp = Constant.PAYMENT_MODE_PATTER, message = Message.ENTER_VALID_PAYMENT_MODE)
    private ModeOfPayment modeOfPayment;
    @NotNull(message = Message.AMOUNT_SHOULD_NOT_BE_EMPTY)
    //@Pattern(regexp = Constant.AMOUNT_PATTERN, message = Message.ENTER_VALID_AMOUNT)
    private Double enteredAmount;
}
