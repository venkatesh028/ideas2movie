/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto.responsedto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import com.ideas2it.ideas2movie.model.Seat;

/**
 *<h1>
 *     Ticket Response DTO
 *</h1>
 * <p>
 *     Contains the Response of the Ticket Entity
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@Getter
@Setter
public class TicketResponseDTO {
    private Long ticketId;
    private ShowResponseDTO showResponseDTO;
    private LocalDate showDate;
    private String theaterName;
    private String movieName;
    private String screenName;
    private List<SeatResponseDTO> seats;
}
