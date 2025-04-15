package com.project.oms.dto;


import lombok.Getter;

@Getter
public class AuthResponse {
    private String token;

//    public AuthResponse() {
//    }

    public AuthResponse(String token) {
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}
