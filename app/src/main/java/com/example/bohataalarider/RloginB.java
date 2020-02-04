package com.example.bohataalarider;

import com.google.gson.annotations.SerializedName;

public class RloginB {
    @SerializedName("full_name")

    private String fullName;
    @SerializedName("email")

    private String email;
    @SerializedName("riderId")

    private String riderId;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRiderId() {
        return riderId;
    }

    public void setRiderId(String riderId) {
        this.riderId = riderId;
    }

}
