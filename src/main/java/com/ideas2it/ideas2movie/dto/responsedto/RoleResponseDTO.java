/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto.responsedto;

import lombok.Getter;
import lombok.Setter;

/**
 * <h2>
 *     RoleResponseDTO
 * </h2>
 * <p>
 *     RoleResponseDTO represents the Response sent to the Client with ID of Role
 *     after Creating the Role for User Model.
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@Getter
@Setter
public class RoleResponseDTO {
    private Long id;
    private String name;
}
