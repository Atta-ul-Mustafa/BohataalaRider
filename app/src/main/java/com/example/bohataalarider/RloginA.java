package com.example.bohataalarider;

import com.google.gson.annotations.SerializedName;

public class RloginA {

    @SerializedName("status")

    private String status;
    @SerializedName("message")

    private String message;
    @SerializedName("data")

    private RloginB data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RloginB getData() {
        return data;
    }

    public void setData(RloginB data) {
        this.data = data;
    }

}
