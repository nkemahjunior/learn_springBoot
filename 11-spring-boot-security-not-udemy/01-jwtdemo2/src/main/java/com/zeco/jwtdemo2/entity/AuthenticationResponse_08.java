package com.zeco.jwtdemo2.entity;

public class AuthenticationResponse_08 {
    private String token;
    private String message;

    public AuthenticationResponse_08(String token, String message) {
        this.token = token;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }
}