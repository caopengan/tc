package com.simba.spider.entity;


import javax.persistence.*;

@Entity
@Table(name = "goods_info")
public class GoodsInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String goodsId;
    private String goodsName;
    private String imgUrl;
    private Double goodsPrice;

    public GoodsInfo(String goodsId, String goodsName, String imgUrl, Double goodsPrice) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.imgUrl = imgUrl;
        this.goodsPrice = goodsPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}
