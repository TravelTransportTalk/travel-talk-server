package com.itmo.traveltalk.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddTripRequest {

    private UUID fromId;

    private UUID toId;

    private String date;

    private String time;

    private String code;

    private UUID transportId;

    private UUID authorId;

}
