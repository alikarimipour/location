package com.devglan.dto;

import com.devglan.model.Tags;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by m.shahoseini on 7/16/2018.
 */
public class ProductDto {

    private String name;
    private String price;
    private Date dateManufacture;
    private Long businessId;

    private List<Tags> tags = new ArrayList();



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getDateManufacture() {
        return dateManufacture;
    }

    public void setDateManufacture(Date dateManufacture) {
        this.dateManufacture = dateManufacture;
    }

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }
}
