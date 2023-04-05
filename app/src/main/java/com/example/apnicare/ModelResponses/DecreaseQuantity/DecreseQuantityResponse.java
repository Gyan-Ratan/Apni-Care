package com.example.apnicare.ModelResponses.DecreaseQuantity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DecreseQuantityResponse {
    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
