package com.bakery.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Certificate Details Controller
 * ********************************************************************************************************************
 *  ###      Date             Story point       Task No        Author         Description
 *  -------------------------------------------------------------------------------------------------------------------
 *  01       10-01-2024                                        Ravindu        Created
 *
 *  *******************************************************************************************************************
 */
@Entity
@Table(name="item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;
    @Column(name="code")
    private String code;
    @Column(name="description")
    private String description;
    @Column(name="image_url")
    private String imageUrl;
    @Column(name="price")
    private String price;
    @Column(name="discount")
    private String discount;
    @Column(name="sale_price")
    private String salePrice;
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
    @JoinColumn(name = "category_id", nullable = false)
    public Category category;

    //-----------------------------------------getters and setters-----------------------------------


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCade(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(String salePrice) {
        this.salePrice = salePrice;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category= category;
    }
}
