package com.example.bohataalarider;

import com.google.gson.annotations.SerializedName;

public class NewRetro {
    @SerializedName("taskId")
    private String taskId;
    @SerializedName("orderId")
    private String orderId;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("delivery_address")
    private String deliveryAddress;
    @SerializedName("orderTime")
    private String orderTime;
    @SerializedName("orderStatus")
    private String orderStatus;
    @SerializedName("taskAssignTime")
    private String taskAssignTime;
    @SerializedName("taskStatus")
    private String taskStatus;
    @SerializedName("instructionFromAdmin")
    private String instructionFromAdmin;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getTaskAssignTime() {
        return taskAssignTime;
    }

    public void setTaskAssignTime(String taskAssignTime) {
        this.taskAssignTime = taskAssignTime;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getInstructionFromAdmin() {
        return instructionFromAdmin;
    }

    public void setInstructionFromAdmin(String instructionFromAdmin) {
        this.instructionFromAdmin = instructionFromAdmin;
    }

}
