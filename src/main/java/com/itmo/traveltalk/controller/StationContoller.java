package com.itmo.traveltalk.controller;

import java.util.List;

import com.itmo.traveltalk.dto.StationShort;
import com.itmo.traveltalk.service.StationService;
import com.itmo.traveltalk.utils.GlobalConstants;
import com.itmo.traveltalk.utils.StationsConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GlobalConstants.GLOBAL_API_PREFIX + "/stations")
@RequiredArgsConstructor
public class StationContoller {

    private final StationService stationService;

    @GetMapping("")
    public ResponseEntity<List<StationShort>> getAllStations() {
        return ResponseEntity.ok(
                stationService.getAllStations()
                        .stream()
                        .map(StationsConverter::convert)
                        .toList()
        );
    }

    @GetMapping("/{type}")
    public ResponseEntity<List<StationShort>> getStationsByTransportType(
            @PathVariable("type")  String transportType
    ) {
        return ResponseEntity.ok(
                stationService.getStationsByTransportType(transportType)
                        .stream()
                        .map(StationsConverter::convert)
                        .toList()
        );
    }


}
