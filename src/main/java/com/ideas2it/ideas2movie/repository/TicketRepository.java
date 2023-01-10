package com.ideas2it.ideas2movie.repository;

import com.ideas2it.ideas2movie.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>
 *     TicketRepository
 * </h1>
 * <p>
 *     Repository of the Ticket
 *     to Save, Fetch, and Update the details of the Ticket
 *     by using the JPA Repository
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
