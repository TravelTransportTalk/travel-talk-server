package com.itmo.traveltalk.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {

    private String nick;

    private String fullName;

    private String description;

    private String tgUsername;

    private Integer tgId;
}
