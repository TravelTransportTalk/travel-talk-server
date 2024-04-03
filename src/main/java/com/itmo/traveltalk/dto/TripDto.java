package com.itmo.traveltalk.dto;

import java.time.OffsetTime;
import java.util.Date;
import java.util.UUID;

import com.itmo.traveltalk.entity.Transport;
import com.itmo.traveltalk.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

// это дичь, но пофиг
@Data
@AllArgsConstructor
public class TripDto {

    private UUID id;

    private StationShort from;

    private StationShort to;

    private Date date;

    private OffsetTime time;

    private String code;

    private Transport transport;

    private User authorId;
}
