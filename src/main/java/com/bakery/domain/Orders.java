package com.bakery.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Certificate Details Domain
 *
 *******************************************************************************************************
 *  ###   Date         Story Point   Task No       Author       Description
 *------------------------------------------------------------------------------------------------------
 *    1   23-01-2024                 order-1    ashansen      Created
 *
 *******************************************************************************************************
 */

@Entity
@Table(name ="orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "reference_Code")
    private String referenceCode;

    @Column(name="description")
    private String description;

    @Column(name="status")
    private String status;

    @Column(name="created_date")
    private Date createdDate;

    @Column(name="created_user")
    private String createdUser;

    @Column(name="modified_date")
    private Date modifiedDate;

    @Column(name="modified_user")
    private String modifiedUser;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Transient
    private List<OrderItem> orderItems;

    @Transient
    private Long customersId;


//----------------Getters & Setters----------------


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Long getCustomersId() {
        if(customer!=null){
            return customer.getId();
        }else{
            return customersId;
        }
    }

    public void setCustomersId(Long customersId) {
        this.customersId = customersId;
    }
}
