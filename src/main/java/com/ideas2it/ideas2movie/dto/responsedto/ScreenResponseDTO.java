package com.ideas2it.ideas2movie.dto.responsedto;

import lombok.Getter;
import lombok.Setter;

/**
 * <h1>
 *     ScreenResponseDTO
 * </h1>
 * <p>
 *     Contains the response of the Screen
 * </p>
 *
 * @author Venkatesh TM
 * @version 1.0
 * @since 06/01/2023
 */

@Getter
@Setter
public class ScreenResponseDTO {
    private Long id;
    private String name;
    private int totalNumberOfRows;
    private int totalNumberOfColumns;
    private TheaterResponseDTO theater;
}
