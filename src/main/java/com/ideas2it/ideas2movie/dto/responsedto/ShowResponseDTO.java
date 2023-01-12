package com.ideas2it.ideas2movie.dto.responsedto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * <h1>
 *     ShowResponseDTO
 * </h1>
 * <p>
 *     Contains the response of the Show
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 06/01/2023
 */
@Getter
@Setter
public class ShowResponseDTO {
    private Long id;
    private LocalDate screeningDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private List<SeatResponseDTO> availableSeats;
    private MovieResponseDTO movie;
    private ScreenResponseDTO screen;
    private Double price;
}
