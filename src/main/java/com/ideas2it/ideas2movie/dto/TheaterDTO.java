package com.ideas2it.ideas2movie.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheaterDTO {
    private Long id;
    @NotBlank(message = "please enter the theater name")
    private String theaterName;
    @NotBlank(message = "Please enter the city name")
    private String city;
    @NotBlank(message = "Please enter the area name")
    private String area;
    @NotBlank(message = "Please enter the pincode")
    private String pincode;
}
