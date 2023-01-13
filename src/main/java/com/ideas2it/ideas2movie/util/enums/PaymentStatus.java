/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <h1>
 *      Payment Status
 * </h1>
 * <p>
 *      Contains the Status of the Payment as a Enum
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   05-01-2023
 */
@AllArgsConstructor
public enum PaymentStatus {
    PAID("Paid"), FAILED("Failed"), REFUNDED("Refunded"), PROCESSING("Processing");
    @Setter
    @Getter
    private String status;
}
