package com.bakery.resource;

import com.bakery.domain.OrderItem;
import com.fasterxml.jackson.annotation.JsonProperty;


import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
@Resource
public class OrderResurceRaivndu {



    private String referenceCode;
    private String description;
    private String status;
    private String createdUser;
    private Date createdDate;
    private String modifiedUser;
    private Date modifiedDate;
    private Long customers;
    //@JsonProperty("order_details")
    @JsonProperty
    private List<OrderItemResourceRavindu> orderItems;


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

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Long getCustomers() {
        return customers;
    }

    public void setCustomers(Long customers) {
        this.customers = customers;
    }

    public List<OrderItemResourceRavindu> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemResourceRavindu> orderItems) {
        this.orderItems = orderItems;
    }
}
