package com.itmo.traveltalk.controller;

import java.util.List;
import java.util.Set;

import com.itmo.traveltalk.dto.StationShort;
import com.itmo.traveltalk.entity.RawStation;
import com.itmo.traveltalk.service.StationService;
import com.itmo.traveltalk.utils.GlobalConstants;
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

    private static final Set<String> FEDERAL_CITIES = Set.of(
            "Москва",
            "Санкт-Петербург"
    );

    private final StationService stationService;

    @GetMapping("")
    public ResponseEntity<List<StationShort>> getAllStations() {
        return ResponseEntity.ok(
                stationService.getAllStations()
                        .stream()
                        .map(this::convert)
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
                        .map(this::convert)
                        .toList()
        );
    }

    private StationShort convert(RawStation raw) {
        return new StationShort(
                raw.getStationYndxCode(),
                raw.getTransportType(),
                raw.getTitle(),
                raw.getTitle() + ", " + constructRegionTitle(raw)
        );
    }

    private String constructRegionTitle(RawStation raw) {
        if (raw.getSettlementTitle() == null) {
            return raw.getRegionTitle();
        } else {
            if (FEDERAL_CITIES.contains(raw.getSettlementTitle())) {
                return raw.getSettlementTitle();
            } else {
                return raw.getSettlementTitle() + ", " + raw.getRegionTitle();
            }
        }
    }


}
