package com.itmo.traveltalk.controller;

import com.itmo.traveltalk.entity.Transport;
import com.itmo.traveltalk.service.TransportService;
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
@RequestMapping(GlobalConstants.GLOBAL_API_PREFIX + "/transports")
public class TransportController {

    private final TransportService transportService;

    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }

    @PostMapping("/add")
    public ResponseEntity<Transport> register(@RequestParam(value = "name") String name) {
        return new ResponseEntity<>(transportService.save(new Transport(name)), HttpStatus.OK);

    }
}
