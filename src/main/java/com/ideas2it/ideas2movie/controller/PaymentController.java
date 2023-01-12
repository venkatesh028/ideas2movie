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
 *     Gets the Input as a Request from the Client and validates them
 *     for making and Getting the Details of the Payment by Instance of the PaymentService
 *     and used to Handle and Mapping the request to Appropriate Function
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
     *      Gets the RequestBody for Making Payment for Reservation and Validates according to Validation Constraints
     *      and process the Request by sending to PaymentService and returns the PaymentResponseDTO and Http Status
     *      or throws an exception when occurred
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
     *     Gets the PathVariable to get the Details of the Payment by Transaction ID
     *     and process the Request by sending to PaymentService and returns the PaymentResponseDTO and Http Status
     *     or throws an exception when occurred
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
     *     Gets the PathVariable to get the Details of the Payment by Payment ID
     *     and process the Request by sending to PaymentService and returns the PaymentResponseDTO and Http Status
     *     or throws an exception when occurred
     * </p>
     *
     * @param
     */
    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDTO> getById(@PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(paymentService.getById(id));
    }
}
