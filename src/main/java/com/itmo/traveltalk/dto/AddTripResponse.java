package com.itmo.traveltalk.dto;

import com.itmo.traveltalk.entity.Trip;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AddTripResponse {

    private String message;
    private Trip trip;

    public AddTripResponse(String message) {
        this.message = message;
    }
}
