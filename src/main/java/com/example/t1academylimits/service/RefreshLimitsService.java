package com.example.t1academylimits.service;

import com.example.t1academylimits.repository.LimitsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class RefreshLimitsService {

    private final LimitsRepository repository;

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void refreshLimits(BigDecimal amount) {
        repository.updateLimitsWhereHoldIsLessThan(amount);
    }
}
