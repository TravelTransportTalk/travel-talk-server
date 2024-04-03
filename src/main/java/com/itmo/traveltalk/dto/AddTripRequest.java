package com.itmo.traveltalk.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddTripRequest {

    private String fromId;

    private String toId;

    private String date;

    private String time;

    private String code;

    private UUID transportId;

    private UUID authorId;

}
