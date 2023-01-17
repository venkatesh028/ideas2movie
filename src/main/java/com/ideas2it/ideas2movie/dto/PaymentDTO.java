/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.ideas2it.ideas2movie.util.constant.Constant;
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
    @Pattern(regexp = Constant.PAYMENT_MODE_PATTERN, message = Message.ENTER_VALID_PAYMENT_MODE)
    private ModeOfPayment modeOfPayment;
    @NotNull(message = Message.AMOUNT_SHOULD_NOT_BE_EMPTY)
    @Pattern(regexp = Constant.AMOUNT_PATTERN, message = Message.ENTER_VALID_AMOUNT)
    private Double enteredAmount;
}
