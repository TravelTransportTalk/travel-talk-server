package com.itmo.traveltalk.controller;

import com.itmo.traveltalk.dto.AddTripRequest;
import com.itmo.traveltalk.entity.Location;
import com.itmo.traveltalk.entity.Transport;
import com.itmo.traveltalk.entity.Trip;
import com.itmo.traveltalk.entity.User;
import com.itmo.traveltalk.service.LocationService;
import com.itmo.traveltalk.service.TransportService;
import com.itmo.traveltalk.service.TripService;
import com.itmo.traveltalk.service.UserService;
import com.itmo.traveltalk.utils.GlobalConstants;
import com.itmo.traveltalk.utils.TripFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetTime;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(GlobalConstants.GLOBAL_API_PREFIX + "/trips")
public class TripController {

    private final TripService tripService;
    private final TransportService transportService;
    private final LocationService locationService;

    private final UserService userService;

    public TripController(TripService tripService, TransportService transportService, LocationService locationService, UserService userService) {
        this.tripService = tripService;
        this.transportService = transportService;
        this.locationService = locationService;
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<Trip> add(@RequestBody AddTripRequest request) throws ParseException {

        Location from = locationService.findById(request.getFromId()).get();
        Location to = locationService.findById(request.getToId()).get();
        Transport transport = transportService.findById(request.getTransportId()).get();
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(request.getDate());
        //for example 10:15:30
        OffsetTime time = OffsetTime.parse(request.getTime());
        User author = userService.findById(request.getAuthorId()).get();

        Trip trip = new Trip(from, to, date, time, request.getCode(), transport, author);

        return new ResponseEntity<>(
                tripService.save(trip),
                HttpStatus.OK);
    }

    @PostMapping("/find")
    public ResponseEntity<List<Trip>> find(@RequestBody AddTripRequest request) throws ParseException {


        Location from = (request.getFromId()!=null) ? locationService.findById(request.getFromId()).get(): null;
        Location to = (request.getToId()!=null) ?locationService.findById(request.getToId()).get() : null ;
        Transport transport = (request.getTransportId()!=null) ? transportService.findById(request.getTransportId()).get(): null;
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = (request.getDate() != null) ? formatter.parse(request.getDate()) : null;


        TripFilter tripFilter = TripFilter.newBuilder().setDate(date).setCode(request.getCode()).setFrom(from).setTo(to).setTransport(transport).build();

        return new ResponseEntity<>(
                tripService.findByFilter(tripFilter),
                HttpStatus.OK);
    }
}
