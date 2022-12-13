package com.example.apnicare.ModelResponses.UpdateUser;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateUserResponse {
    @SerializedName("data")
    @Expose
    private Data dataUser;

    public Data getDataUser() {
        return dataUser;
    }

    public void setDataUser(Data dataUser) {
        this.dataUser = dataUser;
    }
    @SerializedName("message")
    @Expose
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
