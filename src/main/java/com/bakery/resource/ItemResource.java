package com.bakery.resource;

import java.util.Date;

public class ItemResource {

   private Long categoryId;
    private String Name;
    private String code;
    private String Description;
    private String ImageURL;
    private String Price;
    private String Discount;
    private String SalesPrice;
    private String Status;
    private Date CreatedDate;
    private Date CreatedUser;
    private Date ModifiedDate;
    private Date ModifiedUser;

    //getters and setters


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getSalesPrice() {
        return SalesPrice;
    }

    public void setSalesPrice(String salesPrice) {
        SalesPrice = salesPrice;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }

    public Date getCreatedUser() {
        return CreatedUser;
    }

    public void setCreatedUser(Date createdUser) {
        CreatedUser = createdUser;
    }

    public Date getModifiedDate() {
        return ModifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        ModifiedDate = modifiedDate;
    }

    public Date getModifiedUser() {
        return ModifiedUser;
    }

    public void setModifiedUser(Date modifiedUser) {
        ModifiedUser = modifiedUser;
    }
}
