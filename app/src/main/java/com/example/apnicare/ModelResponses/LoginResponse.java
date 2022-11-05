package com.example.apnicare.ModelResponses;

public class LoginResponse {
    Data data;

    public LoginResponse(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
