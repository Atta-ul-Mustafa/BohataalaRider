package com.example.bohataalarider;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RriderHistory {
    @SerializedName("status")

    private String status;
    @SerializedName("message")

    private String message;
    @SerializedName("data")

    private List<RriderHistoryB> data = null;

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

    public List<RriderHistoryB> getData() {
        return data;
    }

    public void setData(List<RriderHistoryB> data) {
        this.data = data;
    }
}
