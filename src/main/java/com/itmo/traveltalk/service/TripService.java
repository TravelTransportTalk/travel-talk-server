package com.itmo.traveltalk.service;

import com.itmo.traveltalk.entity.Trip;
import com.itmo.traveltalk.repository.TripRepository;
import com.itmo.traveltalk.utils.TripFilter;
import com.itmo.traveltalk.utils.TripSpec;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip save(Trip trip) {
        return tripRepository.saveAndFlush(trip);
    }

    public List<Trip> findByFilter(TripFilter tripFilter) {
        return tripRepository.findAll(TripSpec.filterBy(tripFilter));
    }


}
