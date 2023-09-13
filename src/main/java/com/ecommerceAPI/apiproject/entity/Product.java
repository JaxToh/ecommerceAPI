package com.ecommerceAPI.apiproject.entity;

import java.time.LocalDate;
import lombok;

public class Product {
    private String name;
    private Integer productid;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getProductid() {
        return productid;
    }
    public void setProductid(Integer productid) {
        this.productid = productid;
    }
}
