/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.model;

import com.ideas2it.ideas2movie.util.enums.ReservationStatus;
import java.sql.Timestamp;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;

/**
 * <h1>
 *      Ticket
 * </h1>
 * <p>
 *      Ticket Entity have the attributes which is used to Hold the Details of the Ticket
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
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private int numberOfSeatsSelected;
    @NotNull
    private Long showId;
    @NotNull
    private LocalDate showDate;
    @NotNull
    private String theaterName;
    @NotNull
    private String screenName;
    @NotNull
    private String MovieName;
    @NotNull
    private String seats;
    private ReservationStatus reservationStatus;
    @CreationTimestamp
    private Timestamp createdAt;
}
