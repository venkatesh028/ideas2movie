/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import com.ideas2it.ideas2movie.dto.PaymentDTO;
import com.ideas2it.ideas2movie.dto.responsedto.PaymentResponseDTO;

/**
 * <h1>
 *     Payment Service
 * </h1>
 * <p>
 *     Service Layer for the payment
 *     to Make, update, Get the Details of the Payment
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
public interface PaymentService {
    /**
     * <h1>
     *     Make Payment
     * </h1>
     * <p>
     *     Makes the Payment
     *     By getting PaymentDTO from Controller
     *     and checks the Entered Amount is equals to ticket price
     *     and returns the response accordingly
     * </p>
     *
     * @param paymentDTO - holds the Payment Details to Make
     * @return PaymentResponseDTO - holds the response of the Payment
     */
    PaymentResponseDTO makePayment(PaymentDTO paymentDTO);
}
