package com.example.bohataalarider;

import com.google.gson.annotations.SerializedName;

public class FRider {
    @SerializedName("riderId")

    private String riderId;

    public FRider(String riderId) {
        this.riderId = riderId;
    }

    public String getRiderId() {
        return riderId;
    }

    public void setRiderId(String riderId) {
        this.riderId = riderId;
    }
}
