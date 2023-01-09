package com.ideas2it.ideas2movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ideas2it.ideas2movie.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    Seat findByName(String name);

    List<Seat> findAllByScreenId(Long id);
}
