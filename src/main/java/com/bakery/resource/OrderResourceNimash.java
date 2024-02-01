package com.bakery.resource;

/*
 * Certificate Details Resource
 *
******************************************************************************************************
 ###      Date           Story Point       Task No.          Author            Description
 -----------------------------------------------------------------------------------------------------
  1    23-01-2024                                            NimashL           Created

******************************************************************************************************
*/

import java.util.Date;
import java.util.List;

public class OrderResourceNimash {

    private Long customerId;
    private String referenceCode;
    private String description;
    private String status;
    private Date createdDate;
    private String createdUser;
    private Date modifiedDate;
    private String modifiedUser;
    private List<OrderItemResourceNimash> oderItems;


//------------getters and setters-------------------------------------------
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public List<OrderItemResourceNimash> getOderItems() {
        return oderItems;
    }

    public void setOderItems(List<OrderItemResourceNimash> oderItems) {
        this.oderItems = oderItems;
    }
}
