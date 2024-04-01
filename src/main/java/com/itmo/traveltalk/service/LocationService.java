package com.itmo.traveltalk.service;

import com.itmo.traveltalk.entity.Location;
import com.itmo.traveltalk.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Optional<Location> findById(UUID id) {
        return locationRepository.findById(id);
    }

    public Location save(Location location) {
        return locationRepository.saveAndFlush(location);
    }
}
