package com.itmo.traveltalk.dto;

import com.itmo.traveltalk.entity.Trip;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FindTripResponse {

    String message;
    List<Trip> trips;

    public FindTripResponse(String message) {
        this.message = message;
    }
}
