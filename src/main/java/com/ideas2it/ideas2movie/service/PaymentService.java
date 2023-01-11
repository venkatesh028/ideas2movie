/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service;

import java.util.UUID;

import com.ideas2it.ideas2movie.dto.PaymentDTO;
import com.ideas2it.ideas2movie.dto.responsedto.PaymentResponseDTO;
import com.ideas2it.ideas2movie.exception.NotFoundException;

/**
 * <h1>
 *     PaymentService
 * </h1>
 * <p>
 *     PaymentService used to manage the Operations for the Payment
 *     Like Make Payment, viewing the Details of the payment
 *     and Throws an Exception accordingly
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
public interface PaymentService {
    /**
     * <h1>
     *     makePayment
     * </h1>
     * <p>
     *     Makes the Payment
     *     By getting PaymentDTO from Controller
     *     and checks the Entered Amount is equals to ticket price
     *     and returns the response accordingly
     * </p>
     *
     * @param paymentDTO - Holds the Payment Details to Make
     * @return PaymentResponseDTO - Holds the response of the Payment
     */
    PaymentResponseDTO makePayment(PaymentDTO paymentDTO) throws NotFoundException;

    /**
     * <h1>
     *     getByTransactionId
     * </h1>
     * <p>
     *     Gets the Payment details
     *     by getting the Transaction ID from controller
     *     and checks the Payment is present or not
     *     and returns the Response accordingly
     * </p>
     *
     * @param id - ID of the Transaction of the Payment
     * @return PaymentResponseDTO - Holds the details of the Payment
     * @throws NotFoundException - when Payment is Not Found
     */
    PaymentResponseDTO getByTransactionId(UUID id) throws NotFoundException;
}
