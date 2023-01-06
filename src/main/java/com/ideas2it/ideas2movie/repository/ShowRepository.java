/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.ideas2movie.model.Show;

public interface ShowRepository extends JpaRepository<Show, Long> {
    Show[] findAllByMovieName(String movieName);

    boolean existsByDateAndTimeAndMovieId(
            @NotBlank(message = "Show Date should not be empty") LocalDate streamingDate,
            @NotBlank() LocalTime startTime,
            @NotBlank(message = "Movie id should not be empty") Long movieId);
}
