package com.example.t1academylimits.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    @GetMapping("/limit")
    public ResponseEntity<String> getAvailableLimit(
            @RequestParam("client_id") Long clientId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }

}
