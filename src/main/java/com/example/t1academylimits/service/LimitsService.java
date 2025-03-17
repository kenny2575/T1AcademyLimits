package com.example.t1academylimits.service;


import com.example.t1academylimits.configuration.ApplicationConfig;
import com.example.t1academylimits.dto.LimitsDto;
import com.example.t1academylimits.model.Limits;
import com.example.t1academylimits.repository.LimitsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class LimitsService {

    private final LimitsRepository repository;
    private final ApplicationConfig appConfig;

    @Transactional
    public LimitsDto getAvailableLimit(Long userId) {
        var result = repository.findByClientId(userId);
        var limit = result.orElseGet(() -> repository.save(new Limits(null, appConfig.getAmount(), BigDecimal.ZERO, userId)));

        return new LimitsDto(limit.getClientId(), limit.getAmount(), limit.getHold());
    }
}
