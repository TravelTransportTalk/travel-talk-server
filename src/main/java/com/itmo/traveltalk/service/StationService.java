package com.itmo.traveltalk.service;

import java.util.List;

import com.itmo.traveltalk.entity.RawStation;
import com.itmo.traveltalk.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StationService {

    private final StationRepository stationRepository;

    public List<RawStation> getAllStations() {
        return stationRepository.findAll();
    }

    public List<RawStation> getStationsByTransportType(String type) {
        return stationRepository.findByTransportType(type);
    }
}
