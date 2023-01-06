/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import com.ideas2it.ideas2movie.util.constant.Constant;
import com.ideas2it.ideas2movie.util.constant.Message;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h1>
 *     Role DTO
 * </h1>
 * <p>
 *     Gets the Input from the Client for the Role Entity
 * </p>
 *
 * @author AJAISHARMA
 * @version 1.0
 * @since 06-01-2023
 */
@Getter
@Setter
@NoArgsConstructor
public class RoleDTO {
    private Long id;
    @NotBlank(message = Message.ROLE_NAME_SHOULD_NOT_BE_EMPTY)
    //@Pattern(regexp = Constant.ROLE_PATTERN, message = Message.ENTER_VALID_ROLE)
    private String name;
}
