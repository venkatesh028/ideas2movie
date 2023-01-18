/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.service.impl;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ideas2it.ideas2movie.model.Payment;
import com.ideas2it.ideas2movie.model.Reservation;
import com.ideas2it.ideas2movie.dto.PaymentDTO;
import com.ideas2it.ideas2movie.dto.responsedto.PaymentResponseDTO;
import com.ideas2it.ideas2movie.service.PaymentService;
import com.ideas2it.ideas2movie.service.ReservationService;
import com.ideas2it.ideas2movie.repository.PaymentRepository;
import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.util.enums.PaymentStatus;
import com.ideas2it.ideas2movie.exception.NotFoundException;
import com.ideas2it.ideas2movie.logger.CustomLogger;

/**
 * <h2>
 *     PaymentServiceImpl
 * </h2>
 * <p>
 *     PaymentServiceImpl provides the Business logic to handle the Payment for Reservation
 *     Like Processing the payment, updating the Status of the payment
 *     and Viewing the Details of the Payment by Transaction ID from the Storage
 *     and throws an Exception when occurred
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final ReservationService reservationService;
    private final CustomLogger logger = new CustomLogger(PaymentServiceImpl.class);
    private final ModelMapper mapper = new ModelMapper();

    /**
     * <h1>
     *     PaymentServiceImpl Constructor
     * </h1>
     * <p>
     *     Used to inject the PaymentRepository, ReservationService dependency
     *     and initialize the paymentRepository, reservationService variable
     * </p>
     *
     * @param paymentRepository - reference variable for Payment repository
     * @param reservationService - reference variable for Reservation Service
     */
    public PaymentServiceImpl(PaymentRepository paymentRepository, ReservationService reservationService) {
        this.paymentRepository = paymentRepository;
        this.reservationService = reservationService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaymentResponseDTO makePayment(PaymentDTO paymentDTO) throws NotFoundException {
        logger.info("Inside the PaymentServiceImpl make Payment");
        Reservation reservation = reservationService.getReservationById(paymentDTO.getReservationId());
        Payment payment = mapper.map(paymentDTO, Payment.class);

        if (Objects.equals(reservation.getTotalPrice(), paymentDTO.getEnteredAmount())) {
            payment.setStatus(PaymentStatus.PAID);
        } else {
            payment.setStatus(PaymentStatus.FAILED);
        }
        payment.setTransactionAt(new Timestamp(System.currentTimeMillis()));
        payment.setTransactionId(UUID.randomUUID());
        reservationService.confirmReservation(payment);

        return mapper.map(paymentRepository.save(payment), PaymentResponseDTO.class);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public PaymentResponseDTO getByTransactionId(UUID id) throws NotFoundException {
        logger.info("Inside the PaymentServiceImpl get by Transaction ID");
        Optional<Payment> existingPayment = paymentRepository.getByTransactionId(id);

        if (existingPayment.isEmpty()) {
            logger.error(Message.PAYMENT_NOT_FOUND);
            throw new NotFoundException(Message.PAYMENT_NOT_FOUND);
        }
        return mapper.map(existingPayment.get(), PaymentResponseDTO.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaymentResponseDTO getPaymentById(Long id) throws NotFoundException {
        logger.info("Inside the PaymentServiceImpl get By ID");
        Optional<Payment> existingPayment = paymentRepository.findById(id);

        if (existingPayment.isEmpty()) {
            logger.error(Message.PAYMENT_NOT_FOUND);
            throw new NotFoundException(Message.PAYMENT_NOT_FOUND);
        }
        return mapper.map(existingPayment.get(), PaymentResponseDTO.class);
    }
}
