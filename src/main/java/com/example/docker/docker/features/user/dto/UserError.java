package com.example.docker.docker.features.user.dto;

import jakarta.validation.constraints.NotBlank;

public class UserError {
    private int code;
    private String message;

    public UserError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
