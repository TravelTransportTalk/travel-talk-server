package com.itmo.traveltalk.controller;

import com.itmo.traveltalk.dto.AddTripRequest;
import com.itmo.traveltalk.dto.AddTripResponse;
import com.itmo.traveltalk.dto.FindTripResponse;
import com.itmo.traveltalk.entity.Trip;
import com.itmo.traveltalk.service.TripService;
import com.itmo.traveltalk.utils.GlobalConstants;
import com.itmo.traveltalk.utils.TripFilter;
import com.itmo.traveltalk.service.TripRequestConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@CrossOrigin
@RestController
@RequestMapping(GlobalConstants.GLOBAL_API_PREFIX + "/trips")
public class TripController {

    private final TripService tripService;

    private final TripRequestConverter tripRequestConverter;

    public TripController(TripService tripService, TripRequestConverter tripRequestConverter) {
        this.tripService = tripService;
        this.tripRequestConverter = tripRequestConverter;
    }

    @PostMapping("/add")
    public ResponseEntity<AddTripResponse> add(@RequestBody AddTripRequest request) {

        try {
            Trip trip = tripRequestConverter.convertRequestToTrip(request);
            return new ResponseEntity<>(
                    new AddTripResponse("Trip is succesfully created", tripService.save(trip)),
                    HttpStatus.OK);

        } catch (IllegalArgumentException e) {

            return new ResponseEntity<>(
                    new AddTripResponse(e.getMessage()),
                    HttpStatus.BAD_REQUEST);

        }

    }

    @PostMapping("/find")
    public ResponseEntity<FindTripResponse> find(@RequestBody AddTripRequest request) throws ParseException {

        try {
            TripFilter tripFilter = tripRequestConverter.convertRequestToTripFilter(request);

            return new ResponseEntity<>(
                    new FindTripResponse("The followed trips were found by filter: ", tripService.findByFilter(tripFilter)),
                    HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(
                    new FindTripResponse(e.getMessage()),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
