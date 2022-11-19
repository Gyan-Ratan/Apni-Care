package com.example.apnicare.ModelResponses.Address;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddressResponse {
    @SerializedName("data")
    @Expose
    private List<Datum> addressdata = null;

    public List<Datum> getAddressdata() {
        return addressdata;
    }

    public void setData(List<Datum> data1) {
        this.addressdata = data1;
    }
}
