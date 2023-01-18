package com.ideas2it.ideas2movie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.ideas2movie.model.Ticket;

/**
 * <h2>
 *     TicketRepository
 * </h2>
 * <p>
 *     TicketRepository provides the CRUD for the Ticket by extending the JPARepository
 *     like Saving, and Fetching the Details of the Ticket from the repository
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
