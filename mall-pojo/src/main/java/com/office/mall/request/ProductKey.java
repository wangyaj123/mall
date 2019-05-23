package com.office.mall.request;

public class ProductKey {

    private Integer id;


    private Integer shopId;


    private Integer brandId;


    private Integer productCategoryId;


    private Integer productSpecificationsId;

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }


    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }


    public Integer getBrandId() {
        return brandId;
    }


    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }


    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Integer getProductSpecificationsId() {
        return productSpecificationsId;
    }


    public void setProductSpecificationsId(Integer productSpecificationsId) {
        this.productSpecificationsId = productSpecificationsId;
    }
}