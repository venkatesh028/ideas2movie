package com.ideas2it.ideas2movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.ideas2movie.model.Reservation;

/**
 * <h2>
 *     ReservationRepository
 * </h2>
 * <p>
 *     ReservationRepository provides the CRUD for the Reservation of the Seats for the Show
 *     by extending the JPA Repository like Saving, Updating and Fetching the Details of the Reservation
 *     and Contains the Custom methods to Retrieve all Reservation for a Show and User by the ID
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
     *     Retrieves the Details of All Reservation for the Show By the given ID
     *     and returns the List of Reservation
     * </p>
     *
     * @param id - Show ID to fetch the Details of Reservation
     * @return List - Holds the List of reservation made for the Show or Empty
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
     * @param id - User ID to fetch the Details of the Reservation
     * @return List - Holds the List of reservation made for the User or Empty
     */
    List<Reservation> findAllByUserId(Long id);
}
