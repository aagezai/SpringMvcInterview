package com.facebooked.demofacebooked.ViewStroedProcedureDataSql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductView {

    @Id
    @Column(name = "product_id")
    private Long productId;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "price", nullable = false)
    private Double price;

    public ProductView() {
    }

    public ProductView(Long productId, String name, Double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
