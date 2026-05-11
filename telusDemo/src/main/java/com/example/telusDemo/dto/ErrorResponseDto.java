package com.example.telusDemo.dto;

public class ErrorResponseDto {

    private String message;
    private int status;

    public ErrorResponseDto(
            String message,
            int status) {

        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}