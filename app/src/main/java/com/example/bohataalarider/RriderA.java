package com.example.bohataalarider;

import com.google.gson.annotations.SerializedName;

public class RriderA {
    @SerializedName("status")

    private String status;
    @SerializedName("message")

    private String message;
    @SerializedName("data")

    private RriderB data;

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

    public RriderB getData() {
        return data;
    }

    public void setData(RriderB data) {
        this.data = data;
    }

}
