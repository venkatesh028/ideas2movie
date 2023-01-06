package com.ideas2it.ideas2movie.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private String name;
    private String email;
    private String phoneNumber;
    private RoleResponseDTO role;
}
