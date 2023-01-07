package com.ideas2it.ideas2movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.ideas2movie.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    Seat findByName(String name);
}
