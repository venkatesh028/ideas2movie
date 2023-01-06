package com.ideas2it.ideas2movie.dto.responsedto;

import java.time.LocalDate;
import java.time.LocalTime;

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
public class ShowResponseDTO {
    private Long id;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private MovieResponseDTO movie;
    private ScreenResponseDTO screen;
}
