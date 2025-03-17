package com.example.t1academylimits.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OperationResultDto (
        @JsonProperty(value = "client-id") Long clientId,
        @JsonProperty(value = "message") String message) {
}
