package com.ideas2it.ideas2movie.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.ideas2movie.model.Payment;

/**
 * <h2>
 *     PaymentRepository
 * </h2>
 * <p>
 *     PaymentRepository provides the CRUD for the Payment by extending the JPARepository
 *     like Saving, Updating and Fetching the Details of the Payment from the repository
 *     and Contains Custom Methods for Fetching Details of the payment by the Transaction ID
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    /**
     * <h1>
     *     getByTransactionId
     * </h1>
     * <p>
     *     Retrieves the Details of the Payment by the Unique Transaction ID of the Payment
     * </p>
     *
     * @param id - Transaction ID to fetch the Payment Details
     * @return Optional - Holds the Details of the Payment or null
     */
    Optional<Payment> getByTransactionId(UUID id);
}
