package com.bakery.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UpdateResourceRavindu {

    private String status;
    private String modifiedUser;
    @JsonProperty
    private List<OrderItemResourceRavindu> orderItems;

    //-------------------------------------------getters and setters----------------------------------------

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public List<OrderItemResourceRavindu> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemResourceRavindu> orderItems) {
        this.orderItems = orderItems;
    }
}
