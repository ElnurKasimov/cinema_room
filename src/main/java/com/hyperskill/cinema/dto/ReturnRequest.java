package com.hyperskill.cinema.dto;

public class ReturnRequest {
    private String token;

    public ReturnRequest(String token) {
        this.token = token;
    }

    public ReturnRequest() {}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
