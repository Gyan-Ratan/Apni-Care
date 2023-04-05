package com.example.apnicare.ModelResponses.Address;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AddressResponse {
    @SerializedName("data")
    @Expose
    private List<User_Address> addressdata = null;

    public List<User_Address> getAddressdata() {
        return addressdata;
    }

    public void setData(List<User_Address> data1) {
        this.addressdata = data1;
    }
}
