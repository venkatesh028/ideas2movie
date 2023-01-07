/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.model;

import jakarta.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

/**
 * <h1>
 *      Ticket
 * </h1>
 * <p>
 *      Entity of the Ticket
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
    @ManyToMany
    @JoinTable(
            name = "ticket_seat",
            joinColumns = {
                    @JoinColumn(name = "ticket_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "seat_id")
            }
    )
    private List<Seat> seats;
    private int numberOfSeatsSelected;
    @ManyToOne
    @JoinColumn(
            name = "show_id",
            referencedColumnName = "id"
    )
    private Show showId;
    private double price;
    @CreationTimestamp
    private Timestamp createdAt;
}
