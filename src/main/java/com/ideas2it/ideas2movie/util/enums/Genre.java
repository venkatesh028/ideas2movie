/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <h2>
 *     Genre
 * </h2>
 * <p>
 *     Contains the Genre of the Movie as a Enum
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   05-01-2023
 */
@AllArgsConstructor
public enum Genre {
    ACTION("Action"), THRILLER("Thriller"), ROMANCE("Romance"), SI_FI("Si-Fi");
    @Setter
    @Getter
    private String genre;
}
