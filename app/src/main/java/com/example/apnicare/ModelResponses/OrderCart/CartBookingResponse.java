package com.example.apnicare.ModelResponses.OrderCart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartBookingResponse {
    @SerializedName("data")
    @Expose
    private Data order;

    public Data getOrder() {
        return order;
    }

    public void setOrder(Data order) {
        this.order = order;
    }
}
