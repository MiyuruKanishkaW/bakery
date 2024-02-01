package com.bakery.resource;


import com.bakery.domain.OrderItem;

import java.util.Date;
import java.util.List;

public class OrderResourceAshan {

    private String referenceCode;
    private String description;
    private String status;
    private Date createdDate;
    private String createdUser;
    private Date modifiedDate;
    private String modifiedUser;
    private Long customer;
    private Long orderId;

    private List<OrderItemResourceAshan> orderItems;





//------------------getters & setters-----------------------


    public String getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Long getCustomer() {
        return customer;
    }

    public void setCustomer(Long customer) {
        this.customer = customer;
    }


    public List<OrderItemResourceAshan> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemResourceAshan> orderItems) {
        this.orderItems = orderItems;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

}
