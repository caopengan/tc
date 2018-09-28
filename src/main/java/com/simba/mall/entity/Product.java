package com.simba.mall.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String productId;//商品id
    private String productName;//商品名称
    private Double productPrice;//价格
    private String productMainImage;//主图
    private Long inventory;//总库存
    private Timestamp createdDateTime;//创建时间
    private Timestamp updatedDateTime;//更新时间

    public Product() {

    }

    public Product(String productId, String productName, Double productPrice, String productMainImage, Timestamp createdDateTime, Timestamp updatedDateTime, Long inventory) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.inventory = inventory;
        this.productMainImage = productMainImage;
        this.createdDateTime = createdDateTime;
        this.updatedDateTime = updatedDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductMainImage() {
        return productMainImage;
    }

    public void setProductMainImage(String productMainImage) {
        this.productMainImage = productMainImage;
    }

    public Timestamp getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Timestamp createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Timestamp getUpdatedDateTime() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(Timestamp updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
    }
}
