package com.itmo.traveltalk.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChangeUserRequest {

    Integer tgId;

    String nick;

    String fullName;

    String description;
}
