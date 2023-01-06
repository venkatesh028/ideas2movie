package com.ideas2it.ideas2movie.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.ideas2it.ideas2movie.util.constant.Constant;
import com.ideas2it.ideas2movie.util.constant.Message;
import com.ideas2it.ideas2movie.util.enums.ModeOfPayment;

@Getter
@Setter
@NoArgsConstructor
public class PaymentDTO {
    private Timestamp paidAt;
    @NotBlank(message = Message.PAYMENT_MODE_SHOULD_NOT_BE_EMPTY)
    @Pattern(regexp = Constant.PAYMENT_MODE_PATTER, message = Message.ENTER_VALID_PAYMENT_MODE)
    private ModeOfPayment modeOfPayment;
    @NotBlank(message = Message.AMOUNT_SHOULD_NOT_BE_EMPTY)
    @Pattern(regexp = Constant.AMOUNT_PATTERN, message = Message.ENTER_VALID_AMOUNT)
    private double amount;
}
