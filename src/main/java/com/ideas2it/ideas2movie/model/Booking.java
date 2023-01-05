/*
 * Copyright 2022 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.model;

import com.ideas2it.ideas2movie.util.enums.ModeOfBooking;
import jakarta.persistence.Table;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;

import com.ideas2it.ideas2movie.util.enums.BookingStatus;

/**
 * <h1>
 *      Booking
 * </h1>
 * <p>
 *      Entity of the Booking
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
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private BookingStatus status;
    @Enumerated(EnumType.STRING)
    @Column(name = "mode_of_booking")
    private ModeOfBooking modeOfBooking;
    @OneToOne
    @JoinColumn(
            name = "ticket_id",
            referencedColumnName = "id"
    )
    private Ticket ticket;
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private User user;
    @OneToOne
    @JoinColumn(
            name = "payment_id",
            referencedColumnName = "id"
    )
    private Payment payment;
    @CreationTimestamp
    @Column(name = "booked_on")
    private Timestamp bookedOn;
}
