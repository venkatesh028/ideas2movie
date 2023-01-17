/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.model;

import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ideas2it.ideas2movie.util.enums.ModeOfReservation;
import com.ideas2it.ideas2movie.util.enums.ReservationStatus;

/**
 *<h1>
 *     Reservation
 *</h1>
 * <p>
 *     Reservation Entity represents the Reservation made by the user which holds
 *     Information about the User, Show and the ticket.
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
    private ReservationStatus status;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "mode_of_reservation")
    private ModeOfReservation modeOfReservation;

    @OneToOne
    @JoinColumn(
            name = "ticket_id",
            referencedColumnName = "id"
    )
    private Ticket ticket;

    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "id"
    )
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "show_id",
            referencedColumnName = "id"
    )
    private Show show;

    @NotNull
    private Double totalPrice;

    @NotNull
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

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}

