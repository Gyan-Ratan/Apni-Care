package com.example.apnicare.ModelResponses;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
    @SerializedName("message")
    String message;

    public RegisterResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
