/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.model;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;

import com.ideas2it.ideas2movie.util.enums.ModeOfPayment;
import com.ideas2it.ideas2movie.util.enums.PaymentStatus;

/**
 * <h1>
 *      Payment
 * </h1>
 * <p>
 *      Payment Entity have the Attribute which is used to Hold the Details of the Payment
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
    @NotNull
    @Column(name = "transaction_id")
    private UUID transactionId;
    @NotNull
    @CreationTimestamp
    private Timestamp transactionAt;
    @NotNull
    private Double amount;
    @NotNull
    @Enumerated(EnumType.STRING)
    private ModeOfPayment modeOfPayment;
    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
}
