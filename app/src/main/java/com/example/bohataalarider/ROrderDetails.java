package com.example.bohataalarider;

import com.google.gson.annotations.SerializedName;

public class ROrderDetails {


    @SerializedName("status")

    private String status;
    @SerializedName("message")

    private String message;
    @SerializedName("data")

    private RorderDb data;

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

    public RorderDb getData() {
        return data;
    }

    public void setData(RorderDb data) {
        this.data = data;
    }
}
