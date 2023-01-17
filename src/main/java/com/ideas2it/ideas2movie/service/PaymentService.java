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
 *     PaymentService provides the Methods for Payment Operation to handle the Payment for a Reservation
 *     Like Processing the payment, updating the Status of the payment
 *     and retrieving the Details of the Payment by Transaction ID for the Reservation of Seats for a Show
 *     and throws an Exception when occurred
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
     *     Making Payment for the Reservation by getting the Payment Details
     *     and validates if the amount paid is equal to the total amount of the reservation
     *     then payment is success then sets the Status of payment to PAID otherwise FAILED
     *     and sets the Other Details of the payment and stores it.
     * </p>
     *
     * @param paymentDTO - Holds the Payment Details to Make
     * @return PaymentResponseDTO - Holds the response of the Payment
     * @throws NotFoundException - when Reservation is Not Found
     */
    PaymentResponseDTO makePayment(PaymentDTO paymentDTO) throws NotFoundException;

    /**
     * <h1>
     *     getByTransactionId
     * </h1>
     * <p>
     *     Retrieves the Details of the payment using the Transaction ID
     *     If payment not found then throws an Exception otherwise returns the Payment Details
     * </p>
     *
     * @param id - Transaction ID of the Payment
     * @return PaymentResponseDTO - Holds the details of the Payment
     * @throws NotFoundException - when Payment is Not Found
     */
    PaymentResponseDTO getByTransactionId(UUID id) throws NotFoundException;

    /**
     * <h1>
     *      getByTransactionId
     * </h1>
     * <p>
     *     Retrieves the Details of the payment using the ID of the Payment
     *     If payment not found then throws an Exception otherwise returns the Payment Details
     * </p>
     *
     * @param id - ID of the Payment
     * @return PaymentResponseDTO - Holds the details of the Payment
     * @throws NotFoundException - when Payment is Not Found
     */
    PaymentResponseDTO getById(Long id) throws NotFoundException;
}
