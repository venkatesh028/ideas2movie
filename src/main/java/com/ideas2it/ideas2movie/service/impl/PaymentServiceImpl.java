/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import com.ideas2it.ideas2movie.dto.PaymentDTO;
import com.ideas2it.ideas2movie.dto.responsedto.PaymentResponseDTO;
import com.ideas2it.ideas2movie.model.Payment;
import com.ideas2it.ideas2movie.model.Ticket;
import com.ideas2it.ideas2movie.repository.PaymentRepository;
import com.ideas2it.ideas2movie.service.PaymentService;
import com.ideas2it.ideas2movie.service.TicketService;
import com.ideas2it.ideas2movie.util.enums.PaymentStatus;
import java.sql.Timestamp;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * <h1>
 *     Payment Service Impl
 * </h1>
 * <p>
 *     Implements the Payment Service and
 *     Holds the Business Logic to perform
 *     Make payment
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final TicketService ticketService;
    private final ModelMapper mapper = new ModelMapper();

    /**
     * <h1>
     *     Paymeent Service Impl Constructor
     * </h1>
     * <p>
     *     Used to Achieve the Autowiring for Payment Repository, Ticket Service
     * </p>
     *
     * @param paymentRepository - reference variable for Payment repository
     * @param ticketService - reference variable for Ticket Service
     */
    public PaymentServiceImpl(PaymentRepository paymentRepository, TicketService ticketService) {
        this.paymentRepository = paymentRepository;
        this.ticketService = ticketService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaymentResponseDTO makePayment(PaymentDTO paymentDTO) {
        Payment payment = mapper.map(paymentDTO, Payment.class);

        Ticket ticket = ticketService.getTicketById(payment.getTicketId());
        double ticketPrice = ticket.getPrice();

        if (ticketPrice == payment.getAmount()) {
            payment.setStatus(PaymentStatus.PAID);
        } else {
            payment.setStatus(PaymentStatus.FAILED);
        }

        payment.setTransactionAt(new Timestamp(System.currentTimeMillis()));
        payment.setTransactionId(UUID.randomUUID());
        return mapper.map(paymentRepository.save(payment), PaymentResponseDTO.class);
    }
}
