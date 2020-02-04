package com.example.bohataalarider;

import com.google.gson.annotations.SerializedName;

public class FRiderStatus {
    @SerializedName("orderId")

    private String orderId;
    @SerializedName("taskId")

    private String taskId;
    @SerializedName("status")

    private String status;


    public FRiderStatus(String orderId, String taskId, String status) {
        this.orderId = orderId;
        this.taskId = taskId;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
