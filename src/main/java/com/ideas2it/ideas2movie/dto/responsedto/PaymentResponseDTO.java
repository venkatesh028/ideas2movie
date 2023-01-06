package com.ideas2it.ideas2movie.dto.responsedto;

import java.sql.Timestamp;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentResponseDTO {
    private Timestamp paidAt;
    private UUID transactionId;
    private double amount;
    private String status;
}
