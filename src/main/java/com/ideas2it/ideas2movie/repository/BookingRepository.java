package com.ideas2it.ideas2movie.repository;

import com.ideas2it.ideas2movie.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
