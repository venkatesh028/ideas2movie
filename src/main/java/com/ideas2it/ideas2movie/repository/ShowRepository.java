/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ideas2it.ideas2movie.model.Screen;
import com.ideas2it.ideas2movie.model.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    boolean existsByScreeningDateAndStartTimeAndScreen(LocalDate screeningDate,
                                                       LocalTime startTime,
                                                       Screen screen);

    List<Show> findByMovieName(String movieName);
}
