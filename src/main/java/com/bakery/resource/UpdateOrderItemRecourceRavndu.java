package com.bakery.resource;

public class UpdateOrderItemRecourceRavndu {

    private String status;
    private String modifiedUser;
    private Long itemId;
    //---------------------------------------------getters and setters-----------------------------------


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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
}
