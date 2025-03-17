package com.example.t1academylimits.controller;

import com.example.t1academylimits.dto.LimitsDto;
import com.example.t1academylimits.dto.OperationResultDto;
import com.example.t1academylimits.service.LimitsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LimitsController {

    private final LimitsService limitsService;

    @GetMapping("/limit")
    public ResponseEntity<LimitsDto> getAvailableLimit(
            @RequestParam("client_id") Long clientId
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(limitsService.getAvailableLimit(clientId));
    }

    @PostMapping("hold")
    public ResponseEntity<OperationResultDto> setHold(
            @RequestParam("amount") Long clientId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
