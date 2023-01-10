/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.controller;

import com.ideas2it.ideas2movie.dto.PaymentDTO;
import com.ideas2it.ideas2movie.dto.responsedto.PaymentResponseDTO;
import com.ideas2it.ideas2movie.exception.AlreadyExistException;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.service.PaymentService;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>
 *     Payment Controller
 * </h1>
 * <p>
 *     Gets the Input Parameter as a Request from the Client
 *     for Create, Get, Update and Delete the Payment Details
 *     by sending those parameter and Object
 *     to the Payment Service to perform Business Logics on them
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
     *      Used to Achieve the Autowiring for Payment Service
     * </p>
     *
     * @param paymentService - reference variable of the User Service
     */
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * <h1>
     *      Make Payment
     * </h1>
     * <p>
     *      Gets the Input Parameter as a Request from the Client
     *      to Make a Payment for the Booking Ticket
     *      by sending the Payment DTO
     *      to Payment Service to perform Business Logic to Pay
     * </p>
     *
     * @param paymentDTO - Holds the details of the payment
     * @return ResponseEntity - Holds the PaymentResponseDTO and Http Status
     */
    @PostMapping
    public ResponseEntity<PaymentResponseDTO> makePayment(@RequestBody PaymentDTO paymentDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.makePayment(paymentDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDTO> getByTransactionId(@PathVariable("id") UUID id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.getByTransactionId(id));
    }
}
