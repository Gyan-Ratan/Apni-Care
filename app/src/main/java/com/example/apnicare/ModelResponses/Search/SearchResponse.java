package com.example.apnicare.ModelResponses.Search;

import com.google.gson.annotations.SerializedName;

public class SearchResponse {

    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
