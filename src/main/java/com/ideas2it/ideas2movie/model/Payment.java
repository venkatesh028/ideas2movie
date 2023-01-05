/*
 * Copyright 2022 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.model;

import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;

import com.ideas2it.ideas2movie.util.enums.PaymentStatus;
import com.ideas2it.ideas2movie.util.enums.ModeOfPayment;

/**
 * <h1>
 *      Payment
 * </h1>
 * <p>
 *      Entity of the Payment
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   05-01-2023
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "transaction_id")
    private UUID transactionId;

    @CreationTimestamp
    private Timestamp paidOn;
    private double amount;
    @Enumerated(EnumType.STRING)
    private ModeOfPayment modeOfPayment;
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
}
