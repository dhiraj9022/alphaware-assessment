package com.alphaware_assessment.dto;

import lombok.Data;

@Data
public class ErrorResponse {
    private String message;

    public ErrorResponse(String msg) {
        message = msg;
    }
}
