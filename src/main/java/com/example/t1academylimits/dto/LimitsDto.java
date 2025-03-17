package com.example.t1academylimits.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record LimitsDto (
        @JsonProperty(value = "client-id") Long clientId,
        @JsonProperty(value = "available-limit") BigDecimal limit,
        @JsonProperty(value = "hold") BigDecimal hold
        ) {
}
