/*
 * Copyright 2023 Ideas2IT Technologies. All rights reserved.
 * IDEAS2IT PROPRIETARY/CONFIDENTIAL.
 */
package com.ideas2it.ideas2movie.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.ideas2it.ideas2movie.util.constant.Constant;
import com.ideas2it.ideas2movie.util.constant.Message;

/**
 * <h1>
 *      UserDTO
 * </h1>
 * <p>
 *      UserDTO is used to get the Details for the User
 * </p>
 *
 * @author  AJAISHARMA
 * @version 1.0
 * @since   05-01-2023
 */
@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    @NotBlank(message = Message.NAME_SHOULD_NOT_BE_EMPTY)
    //@Pattern(regexp = Constant.NAME_PATTERN, message = Message.ENTER_VALID_NAME)
    private String name;
    @NotBlank(message = Message.EMAIL_SHOULD_NOT_BE_EMPTY)
    //@Email(message = Message.ENTER_VALID_EMAIL)
    private String email;
    @NotBlank(message = Message.PHONE_SHOULD_NOT_BE_EMPTY)
    //@Pattern(regexp = Constant.PHONE_NUMBER_PATTERN, message = Message.ENTER_VALID_PHONE_NUMBER)
    private String phoneNumber;
    @NotBlank(message = Message.PASSWORD_SHOULD_NOT_BE_EMPTY)
    //@Pattern(regexp = Constant.PASSWORD_PATTERN, message = Message.ENTER_VALID_PASSWORD)
    private String password;
    @NotNull
    private RoleDTO role;
}




