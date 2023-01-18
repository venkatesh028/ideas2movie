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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.UpdateTimestamp;

import com.ideas2it.ideas2movie.util.enums.ModeOfPayment;
import com.ideas2it.ideas2movie.util.enums.PaymentStatus;

/**
 * <h2>
 *      Payment
 * </h2>
 * <p>
 *      Payment Entity Represent the Details of the Payment Made for the Reservation
 *      Like Amount, Mode Of payment, and a Unique Transaction ID
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
    private Timestamp transactionAt;

    @NotNull
    private Double amount;

    @OneToOne
    @JoinColumn(
            name = "reservation_id",
            referencedColumnName = "id"
    )
    private Reservation reservation;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ModeOfPayment modeOfPayment;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    @UpdateTimestamp
    private Timestamp updatedAt;
}
