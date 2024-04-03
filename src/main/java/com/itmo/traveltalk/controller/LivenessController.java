package com.itmo.traveltalk.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivenessController {

    @GetMapping("/ready")
    public ResponseEntity<String> ready() {
        return ResponseEntity.ok("200;OK");
    }
}
