package com.ideas2it.ideas2movie.repository;

import com.ideas2it.ideas2movie.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
