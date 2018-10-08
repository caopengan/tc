package com.simba.es.entity;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

@Document(indexName = "productinfo",type = "product")
public class ESProductInfo implements Serializable{
    @Id
    private Long id;
    @Field
    private String productId;//商品id
    @Field
    private String productName;//商品名称
    @Field
    private Double productPrice;//价格
    @Field
    private String productMainImage;//主图
    @Field
    private Long inventory;//总库存
    @Field
    private Timestamp createdDateTime;//创建时间
    @Field
    private Timestamp updatedDateTime;//更新时间

    public ESProductInfo() {
    }

    public ESProductInfo(Long id, String productId, String productName, Double productPrice, String productMainImage, Long inventory, Timestamp createdDateTime, Timestamp updatedDateTime) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productMainImage = productMainImage;
        this.inventory = inventory;
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

    public Long getInventory() {
        return inventory;
    }

    public void setInventory(Long inventory) {
        this.inventory = inventory;
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
}
