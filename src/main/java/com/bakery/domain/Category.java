package com.bakery.domain;

import javax.persistence.*;
import java.util.Date;


/**
 * Certificate Details Domain
 *
 *******************************************************************************************************
 *  ###   Date         Story Point   Task No       Author       Description
 *------------------------------------------------------------------------------------------------------
 *    1   12-01-2024                 category-1    ashansen      Created
 *
 *******************************************************************************************************
 */

@Entity
@Table(name ="Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name ="code")
    private String code;

    @Column(name ="description")
    private String description;

    @Column(name ="image_url")
    private String imageUrl;

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

//--------------getters & setters---------------


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

    public void setCode(String code) {
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
}
