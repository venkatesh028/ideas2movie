package com.ideas2it.ideas2movie.repository;

import com.ideas2it.ideas2movie.model.Payment;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <h1>
 *     PaymentRepository
 * </h1>
 * <p>
 *     Repository of the Payment
 *     to save, and fetch the Details of the Payment
 *     by using the JPA Repository
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
     *     Fetches the Details of the Payment
     *     by using the Transaction ID
     * </p>
     *
     * @param id - ID of the Transaction to fetch the Payment Details
     * @return payment - Details of the Payment
     */
    Optional<Payment> getByTransactionId(UUID id);
}
