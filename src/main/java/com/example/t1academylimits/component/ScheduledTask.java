package com.example.t1academylimits.component;

import com.example.t1academylimits.configuration.ApplicationConfig;
import com.example.t1academylimits.service.RefreshLimitsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
@RequiredArgsConstructor
public class ScheduledTask {

    private final ApplicationConfig appConfig;
    private final RefreshLimitsService refreshService;

    @Scheduled(cron = "${application.limits.renew}")
    public void restartLimits() {
        log.info("Limits restarted to {}", appConfig.getAmount());
        refreshService.refreshLimits(appConfig.getAmount());

    }
}
