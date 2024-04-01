package com.itmo.traveltalk.controller;

import com.itmo.traveltalk.entity.Location;
import com.itmo.traveltalk.service.LocationService;
import com.itmo.traveltalk.utils.GlobalConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(GlobalConstants.GLOBAL_API_PREFIX + "/locations")
public class LocationController {

    LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/add")
    public ResponseEntity<Location> register(@RequestParam(value = "name") String name) {
        return new ResponseEntity<>(locationService.save(new Location(name)), HttpStatus.OK);

    }
}
