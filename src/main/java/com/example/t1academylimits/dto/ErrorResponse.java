package com.example.t1academylimits.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ErrorResponse(
        @JsonProperty(required = true, value = "message")
        String errorMessage,
        @JsonProperty(required= true, value = "details")
        String details
) {
}
