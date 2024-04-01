package com.itmo.traveltalk.dto;

import com.itmo.traveltalk.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserControllerResp {

    private String message;
    private User user;

    public UserControllerResp(String message) {
        this.message = message;
    }
}
