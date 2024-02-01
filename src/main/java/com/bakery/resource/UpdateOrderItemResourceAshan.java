package com.bakery.resource;

import java.util.List;

public class UpdateOrderItemResourceAshan {

    private Long orderId;

    private Long orderItemId;

    private List<OrderItemResourceAshan> orderItemResourceAshanList;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public List<OrderItemResourceAshan> getOrderItemResourceAshanList() {
        return orderItemResourceAshanList;
    }

    public void setOrderItemResourceAshanList(List<OrderItemResourceAshan> orderItemResourceAshanList) {
        this.orderItemResourceAshanList = orderItemResourceAshanList;
    }
}
