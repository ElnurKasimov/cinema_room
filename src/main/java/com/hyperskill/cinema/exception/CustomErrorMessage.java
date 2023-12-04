package com.hyperskill.cinema.exception;

import java.time.LocalDateTime;

public class CustomErrorMessage {
    private String error;

    public CustomErrorMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
