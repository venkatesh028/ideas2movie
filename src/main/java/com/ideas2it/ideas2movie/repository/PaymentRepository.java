package com.ideas2it.ideas2movie.repository;

import com.ideas2it.ideas2movie.model.Payment;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> getByTransactionId(UUID id);
}
