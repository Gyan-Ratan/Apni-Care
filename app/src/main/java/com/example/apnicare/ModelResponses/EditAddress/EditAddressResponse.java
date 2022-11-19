package com.example.apnicare.ModelResponses.EditAddress;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EditAddressResponse {
    @SerializedName("data")
    @Expose
    private Data editaddressdata;

    public Data getEditaddressdata() {
        return editaddressdata;
    }

    public void setEditaddressdata(Data editaddressdata) {
        this.editaddressdata = editaddressdata;
    }

}
