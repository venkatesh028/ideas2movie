/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.controller;

import java.util.UUID;

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

/**
 * <h1>
 *     Payment Controller
 * </h1>
 * <p>
 *     Gets the Input Parameter as a Request from the Client
 *     for Create, Get, Update and Delete the Payment Details
 *     by handling and mapping the Request to appropriate function
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@RestController
@RequestMapping("api/v1/payments")
public class PaymentController {
    private final PaymentService paymentService;

    /**
     * <h1>
     *      Payment Controller Constructor
     * </h1>
     * <p>
     *     Used to initialize the Services for calling the Operation performers of Service
     *     and also achieves the Autowiring
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
     *      Gets the Input Parameter as a Request from the Client
     *      to Make a Payment for the Booking Ticket by sending the Payment DTO
     *      to Payment Service to perform Business Logic to Pay
     * </p>
     *
     * @param paymentDTO - Holds the details of the payment
     * @return ResponseEntity - Holds the PaymentResponseDTO and Http Status
     */
    @PostMapping
    public ResponseEntity<PaymentResponseDTO> makePayment(@RequestBody PaymentDTO paymentDTO) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.makePayment(paymentDTO));
    }

    /**
     * <h1>
     *     getByTransactionId
     * </h1>
     * <p>
     *     Gets the ID of the Transaction from the Client to Get the Details of the Payment
     *     in the form of PaymentResponseDTO by sending the Transaction ID to PaymentService
     * </p>
     *
     * @param id - ID of the Transaction
     * @return ResponseEntity - Holds the PaymentResponseDTO and Http Status
     * @throws NotFoundException - when Payment is Not Found
     */
    @GetMapping("/by-transaction/{id}")
    public ResponseEntity<PaymentResponseDTO> getByTransactionId(@PathVariable("id") UUID id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.getByTransactionId(id));
    }

    /**
     * <h1>
     *     getById
     * </h1>
     * <p>
     *     Gets the ID of the payment from the Client to get the Details of the payment
     *     in the form of PaymentResponseDTO by sending the ID to the PaymentService
     * </p>
     *
     * @param
     */
    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDTO> getById(@PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.getById(id));
    }
}
