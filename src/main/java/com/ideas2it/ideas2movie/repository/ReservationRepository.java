package com.ideas2it.ideas2movie.repository;

import com.ideas2it.ideas2movie.model.Reservation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findAllByShowId(Long id);
}
