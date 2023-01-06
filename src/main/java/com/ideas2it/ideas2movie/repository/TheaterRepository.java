package com.ideas2it.ideas2movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.ideas2movie.model.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Long> {
    Theater getTheaterById();
}
