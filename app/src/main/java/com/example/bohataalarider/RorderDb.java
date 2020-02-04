package com.example.bohataalarider;

import com.google.gson.annotations.SerializedName;

public class RorderDb {
    @SerializedName("orderDetail")

    private OrderDetailC orderDetail;

    public OrderDetailC getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetailC orderDetail) {
        this.orderDetail = orderDetail;
    }
}
