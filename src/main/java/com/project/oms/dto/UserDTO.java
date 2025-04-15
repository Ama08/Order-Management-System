package com.project.oms.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {
    private Long id;
    private String userName;
    private String role;

    public UserDTO() {
    }

    public UserDTO(Long id, String userName, String role) {
        this.id = id;
        this.userName = userName;
        this.role = role;
    }

}
