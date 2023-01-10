/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.model;

import java.sql.Timestamp;

import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;

import com.ideas2it.ideas2movie.util.enums.BookingStatus;
import com.ideas2it.ideas2movie.util.enums.ModeOfBooking;

/**
 * <h1>
 * Booking
 * </h1>
 * <p>
 * Entity of the Booking
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 05-01-2023
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private BookingStatus status;
    @NotNull
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
    @ManyToOne
    @JoinColumn(
            name = "show_id",
            referencedColumnName = "id"
    )
    private Show show;
    private double totalPrice;
    @ManyToMany
    @JoinTable(
            name = "reserved_seat",
            joinColumns = {
                    @JoinColumn(
                            name = "reservation_id",
                            referencedColumnName = "id"
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "seat_id",
                            referencedColumnName = "id"
                    )
            }
    )
    private List<Seat> seats;
    @CreationTimestamp
    @Column(name = "booked_at")
    private Timestamp bookedAt;
}

