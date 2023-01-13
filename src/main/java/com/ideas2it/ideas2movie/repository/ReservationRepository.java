package com.ideas2it.ideas2movie.repository;

import com.ideas2it.ideas2movie.model.Reservation;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>
 *     ReservationRepository
 * </h1>
 * <p>
 *     Repository of the Reservation
 *     to Save, Fetch and Update the Reservation
 *     by Using the JPA Repository
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    /**
     * <h1>
     *     findAllByShowId
     * </h1>
     * <p>
     *     Fetches the Details of the Reservation
     *     for Show by using the ID of the Show
     * </p>
     *
     * @param id - ID of the Show to fetch the Details of Reservation
     * @return List<reservation> - Holds the List of reservation made for the Show
     */
    List<Reservation> findAllByShowId(Long id);

    /**
     * <h1>
     *     findAllByUserId
     * </h1>
     * <p>
     *     Fetches the Details of the reservation
     *     for User by using ID of the User
     * </p>
     *
     * @param id - ID of the User to fetch the Details of the Reservation
     * @return List<reservation> - Holds the List of reservation made for the User
     */
    List<Reservation> findAllByUserId(Long id);
}
