package com.example.t1academylimits.service;


import com.example.t1academylimits.configuration.ApplicationConfig;
import com.example.t1academylimits.dto.LimitsDto;
import com.example.t1academylimits.dto.OperationResultDto;
import com.example.t1academylimits.exceptions.IllegalOperationIdException;
import com.example.t1academylimits.exceptions.InsufficientFundsException;
import com.example.t1academylimits.exceptions.NoSuchLimitException;
import com.example.t1academylimits.model.Holds;
import com.example.t1academylimits.model.Limits;
import com.example.t1academylimits.repository.HoldsRepository;
import com.example.t1academylimits.repository.LimitsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LimitsService {

    private final LimitsRepository limitsRepository;
    private final HoldsRepository holdsRepository;
    private final ApplicationConfig appConfig;

    @Transactional
    public LimitsDto getAvailableLimit(Long userId) {
        var result = limitsRepository.findByClientId(userId);
        var limit = result.orElseGet(() -> limitsRepository.save(new Limits(null, appConfig.getAmount(), BigDecimal.ZERO, userId)));

        return new LimitsDto(limit.getClientId(), limit.getAmount(), limit.getHold());
    }

    @Transactional
    public OperationResultDto setHold(Long clientId, BigDecimal amount) {
        var limit =  limitsRepository.findByClientId(clientId)
                .orElseGet(() -> limitsRepository.save(new Limits(null, appConfig.getAmount(), BigDecimal.ZERO, clientId)));

        if (limit.getAmount().compareTo(limit.getHold().add(amount)) < 0) {
            throw new InsufficientFundsException(limit);
        }

        limit.setHold(limit.getHold().add(amount));
        var operationId = UUID.randomUUID();
        holdsRepository.save(new Holds(null, limit.getId(), amount, operationId));
        limitsRepository.save(limit);
        return new OperationResultDto(operationId, clientId, "Средства зарезервированы");
    }

    @Transactional
    public OperationResultDto confirmOperation(UUID operationId) {

        var hold = holdsRepository.findByOperationId(operationId)
                .orElseThrow(() -> new IllegalOperationIdException(operationId));

        var limit = limitsRepository.findById(hold.getLimit())
                .orElseThrow(() -> new NoSuchLimitException(hold.getLimit()));

        limit.setHold(limit.getHold().subtract(hold.getAmount()));
        limit.setAmount(limit.getAmount().subtract(hold.getAmount()));

        holdsRepository.deleteByOperationId(operationId);
        limitsRepository.save(limit);

        return new OperationResultDto(operationId, limit.getClientId(), "Операция выполнена");
    }
}
