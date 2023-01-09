package com.ideas2it.ideas2movie.dto.responsedto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CastAndCrewResponseDTO {

    private Long id;
    @NotBlank()
    private String director;
    @NotBlank()
    private String hero;
    @NotBlank()
    private String heroine;
}
