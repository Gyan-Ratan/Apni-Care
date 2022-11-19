package com.example.apnicare.ModelResponses.DeleteAddress;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeleteAddressResponse {
    @SerializedName("data")
    @Expose
    private Data deleteaddress;

    public Data getDeleteaddress() {
        return deleteaddress;
    }

    public void setDeleteaddress(Data deleteaddress) {
        this.deleteaddress = deleteaddress;
    }

    public class Data {

        @SerializedName("message")
        @Expose
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

}}
