package com.itmo.traveltalk.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FindTripResponse {

    String message;
    List<TripDto> trips;

    public FindTripResponse(String message) {
        this.message = message;
    }
}
