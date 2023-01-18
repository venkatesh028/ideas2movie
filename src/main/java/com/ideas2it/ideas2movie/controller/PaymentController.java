/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.controller;

import java.util.UUID;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.ideas2movie.dto.PaymentDTO;
import com.ideas2it.ideas2movie.dto.responsedto.PaymentResponseDTO;
import com.ideas2it.ideas2movie.service.PaymentService;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.logger.CustomLogger;

/**
 * <h2>
 *     PaymentController
 * </h2>
 * <p>
 *     PaymentController provides the RESTful endpoints to Handle CRUD Operation for Payment
 *     for the Reservation of the Application and validate the Information of the PaymentDTO
 *     according to Validation constraints and throws an exception when occurred
 *     and returns the Details of Payment and Http Status
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {
    private final PaymentService paymentService;
    private final CustomLogger logger = new CustomLogger(PaymentController.class);
    /**
     * <h1>
     *      PaymentController Constructor
     * </h1>
     * <p>
     *      Used to inject the PaymentService dependency and initialize the paymentService variable
     * </p>
     *
     * @param paymentService - An instance of the UserService
     */
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * <h1>
     *      makePayment
     * </h1>
     * <p>
     *     Makes the Payment of the Reservation for the Seats of the Show by validating the PaymentDTO
     *     according to validation constraints If Details of the Payment is Not Valid throws an exception
     *     else process the request and returns the ResponseEntity with Http status and Details of the Payment
     * </p>
     *
     * @param paymentDTO - Holds the details of the payment
     * @return ResponseEntity - Holds the PaymentResponseDTO and Http Status ACCEPTED
     * @throws NotFoundException - when Reservation Not Found to Pay
     */
    @PostMapping
    public ResponseEntity<PaymentResponseDTO> makePayment(@Valid @RequestBody PaymentDTO paymentDTO)
            throws NotFoundException {
        logger.info("Inside the PaymentController Make payment");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(paymentService.makePayment(paymentDTO));
    }

    /**
     * <h1>
     *     getByTransactionId
     * </h1>
     * <p>
     *     Retrieves the Details of the Payment by Transaction ID of Payment
     *     by process the request If payment is not found throws an exception
     *     otherwise returns the ResponseEntity with Http status OK and Details of the Payment
     * </p>
     *
     * @param id - ID of the Transaction
     * @return ResponseEntity - Holds the PaymentResponseDTO and Http Status OK
     * @throws NotFoundException - when Payment is Not Found for Transaction ID
     */
    @GetMapping("/by-transaction/{id}")
    public ResponseEntity<PaymentResponseDTO> getByTransactionId(@PathVariable("id") UUID id)
            throws NotFoundException {
        logger.info("Inside the PaymentController get by Transaction ID");
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.getByTransactionId(id));
    }

    /**
     * <h1>
     *     getById
     * </h1>
     * <p>
     *     Retrieves the Details of the Payment by  ID of Payment by process the request
     *     If payment is not found for the transaction ID throws an exception
     *     otherwise returns the ResponseEntity with Http status OK and Details of the Payment
     * </p>
     *
     * @param id - ID of the payment to Retrieve Details of the Payment
     * @return ResponseEntity - Holds the PaymentResponseDTO and Http Status OK
     * @throws NotFoundException - when Payment Not found for ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDTO> getPaymentById(@PathVariable("id") Long id)
            throws NotFoundException {
        logger.info("Inside the PaymentController get By Id");
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.getPaymentById(id));
    }
}
