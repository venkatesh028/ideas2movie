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
 *     Language
 * </h1>
 * <p>
 *     Contains the Language of the Movie as a Enum
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   05-01-2023
 */
@AllArgsConstructor
public enum Language {
    TAMIL("Tamil"), ENGLISH("English"), TELUGU("Telugu"), HINDI("Hindi");

    @Getter
    @Setter
    private String language;
}
