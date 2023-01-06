package com.ideas2it.ideas2movie.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import com.ideas2it.ideas2movie.util.constant.Constant;
import com.ideas2it.ideas2movie.util.constant.Message;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleDTO {
    @NotBlank(message = Message.ROLE_NAME_SHOULD_NOT_BE_EMPTY)
    @Pattern(regexp = Constant.ROLE_PATTERN, message = Message.ENTER_VALID_ROLE)
    private String name;
}
