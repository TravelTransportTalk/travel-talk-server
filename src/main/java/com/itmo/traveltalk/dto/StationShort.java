package com.itmo.traveltalk.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StationShort {

    @JsonProperty("station_code")
    String stationCode;

    @JsonProperty("transport_type")
    String transportType;

    @JsonProperty("short_name")
    String shortName;
    @JsonProperty("long_name")
    String longName;
}
