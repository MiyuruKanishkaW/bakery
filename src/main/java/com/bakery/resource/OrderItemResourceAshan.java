package com.bakery.resource;

import java.util.Date;

public class OrderItemResourceAshan {

    private Long item;

    private String status;

    private Date createdDate;

    private String createdUser;

    private Date modifiedDate;

    private String modifiedUser;

    private Long orderItem;



    //---------------getters & setters---------------


    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
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

    public Long getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Long orderItem) {
        this.orderItem = orderItem;
    }
}
