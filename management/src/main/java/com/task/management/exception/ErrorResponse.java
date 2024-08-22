package com.task.management.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {

    private LocalDateTime errorTime;
    private int status;
    private String error;
    private String message;
    private String path;

    public ErrorResponse(LocalDateTime errorTime, int status, String error, String message, String path) {
        this.errorTime = errorTime;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
