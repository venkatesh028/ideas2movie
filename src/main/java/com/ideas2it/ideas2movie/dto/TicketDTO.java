/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.ideas2it.ideas2movie.model.Seat;

/**
 * <h1>
 *     Ticket DTO
 * </h1>
 * <p>
 *     Gets the Input from the Client for the Ticket Entity
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since  06-01-2023
 */
@Getter
@Setter
@NoArgsConstructor
public class TicketDTO {
    private ShowDTO showDTO;
    private List<SeatDTO> seats;
    private double price;
}
