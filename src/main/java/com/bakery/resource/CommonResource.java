package com.bakery.resource;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class CommonResource {

    @NotBlank(message = "{common.not-null}")
    private String name;

    private String description;

    @NotBlank(message = "{common.not-null}")
    @Pattern(regexp = "^$|Active|Inactive",message="{common-status.pattern}")
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
