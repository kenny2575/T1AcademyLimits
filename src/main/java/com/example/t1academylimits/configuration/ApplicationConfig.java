package com.example.t1academylimits.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Setter
@Configuration
@ConfigurationProperties(prefix = "application.limits")
public class ApplicationConfig {

    @Getter
    private BigDecimal amount;
    private String renew;

}
