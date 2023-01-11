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
 *     City
 * </h1>
 * <p>
 *     Contains the City of the Theater as a Enum
 * </p>
 *
 * @author  YOGESHWAR
 * @version 1.0
 * @since   11-01-2023
 */
@AllArgsConstructor
public enum City {
    BENGALURU("Bengaluru"), CHENNAI("Chennai"), COIMBATORE("Coimbatore"), DELHI("Delhi"),
    KOCHI("Kochi"), MADURAI("Madurai"), MUMBAI("Mumbai"), MYSURU("Mysuru"), SALEM("salem"),
    PONDICHEERY("Pondicheery"), TIRUCHIRAPPALLI("Tiruchirappalli"), THIRUVANNAMALAI("Thiruvannamalai");
    @Setter
    @Getter
    private String city;
}
