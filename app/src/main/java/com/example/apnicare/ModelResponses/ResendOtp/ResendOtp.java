package com.example.apnicare.ModelResponses.ResendOtp;

public class ResendOtp {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResendOtp(String message) {
        this.message = message;
    }
}
