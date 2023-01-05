package com.ideas2it.ideas2movie.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum ModeOfBooking {
    OFFLINE("Offline"), ONLINE("Online");

    @Getter
    @Setter
    private String mode;
}
