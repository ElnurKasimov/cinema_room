package com.hyperskill.cinema.exception;

import java.time.LocalDateTime;

public class CustomErrorMessage {
//    private int statusCode;
//    private LocalDateTime timestamp;
//    private String message;
//    private String description;

    private String error;

    public CustomErrorMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
