package com.ideas2it.ideas2movie.dto.responsedto;

import java.time.LocalTime;

import com.ideas2it.ideas2movie.model.CastAndCrew;
import com.ideas2it.ideas2movie.util.enums.Genre;
import com.ideas2it.ideas2movie.util.enums.Language;

public class MovieResponseDTO {
    private Long id;
    private String name;
    private Language language;
    private LocalTime duration;
    private Genre genre;
    private CastAndCrew castAndCrew;
}
