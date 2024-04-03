package com.itmo.traveltalk.service;

import com.itmo.traveltalk.dto.AddTripRequest;
import com.itmo.traveltalk.entity.RawStation;
import com.itmo.traveltalk.entity.Transport;
import com.itmo.traveltalk.entity.Trip;
import com.itmo.traveltalk.entity.User;
import com.itmo.traveltalk.utils.TripFilter;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetTime;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.UUID;

@Component
public class TripRequestConverter {

    private final TransportService transportService;
    private final StationService stationService;

    private final UserService userService;

    public TripRequestConverter(TransportService transportService,
                                StationService stationService,
                                UserService userService) {
        this.transportService = transportService;
        this.stationService = stationService;
        this.userService = userService;
    }

    public  Trip convertRequestToTrip (AddTripRequest request) {

        RawStation from = null;
        RawStation to = null;
        Transport transport = null;
        User author = null;
        Date date = null;
        OffsetTime time = null;

        if (request.getFromId() != null) {
            from = stationService.findById(request.getFromId()).orElseThrow(() -> new IllegalArgumentException("Location by specified fromId is not found"));
        }

        if (request.getToId() != null) {
            to = stationService.findById(request.getToId()).orElseThrow(() -> new IllegalArgumentException("Location by specified toId is not found"));
        }

        if (uuidIsNotNull(request.getTransportId())) {
            transport = transportService.findById(request.getTransportId()).orElseThrow(() -> new IllegalArgumentException("Transport by specified transportId is not found"));
        }

        if (uuidIsNotNull(request.getAuthorId())) {
            author = userService.findById(request.getAuthorId()).orElseThrow(() -> new IllegalArgumentException("User by specified authorId is not found"));
        } else {
            throw new IllegalArgumentException("authorId is required field");
        }

        if (isNotEmpty(request.getDate())) {
            date = parseDate(request.getDate());
        }

        if (isNotEmpty(request.getTime())) {
            try {
                time = OffsetTime.parse(request.getTime());
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException(("Wrong time format! Time should be specified in following format: hh:mm:ss+zone, example 10:15:30+01"));
            }
        }

        return  new Trip(from, to, date, time, request.getCode(), transport, author);
    }


    public TripFilter convertRequestToTripFilter (AddTripRequest request) {

        RawStation from = null;
        RawStation to = null;
        Transport transport = null;
        Date date = null;

        if (request.getFromId() != null) {
            from = stationService.findById(request.getFromId()).orElseThrow(() -> new IllegalArgumentException("Location by specified fromId is not found"));
        }

        if (request.getToId() != null) {
            to = stationService.findById(request.getToId()).orElseThrow(() -> new IllegalArgumentException("Location by specified toId is not found"));
        }

        if (uuidIsNotNull(request.getTransportId())) {
            transport = transportService.findById(request.getTransportId()).orElseThrow(() -> new IllegalArgumentException("Transport by specified transportId is not found"));
        }

        if (request.getDate() != null && !request.getDate().isEmpty()) {
                date = parseDate(request.getDate());
        }


        return  TripFilter.newBuilder().setDate(date).setCode(request.getCode()).setFrom(from).setTo(to).setTransport(transport).build();
    }

    private Date parseDate (String date) {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return formatter.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException(("Wrong date format! Date should be specified in following format: dd-MM-yyyy"));
        }
    }

    private boolean uuidIsNotNull(UUID uuid) {
        return uuid != null;
    }

    private boolean isNotEmpty(String param) {
        return param != null && !param.isEmpty();
    }

}
