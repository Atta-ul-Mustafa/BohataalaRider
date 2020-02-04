package com.example.bohataalarider;

import com.google.gson.annotations.SerializedName;

public class ForderDetails {

    @SerializedName("orderId")

    private String orderId;

    public ForderDetails(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
