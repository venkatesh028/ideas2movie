/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.ideas2it.ideas2movie.model.Theater;
@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {
    boolean existsByCity(String city);
    boolean existsByTheaterName(String theatreName);
}
