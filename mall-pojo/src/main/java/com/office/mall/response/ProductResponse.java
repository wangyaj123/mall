package com.office.mall.response;

import com.office.mall.request.ProductRequest;

public class ProductResponse extends ProductRequest {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product.description
     *
     * @mbg.generated
     */
    private String description;
    private String shopName;

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    private String BrandName;


    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product.detail_desc
     *
     * @mbg.generated
     */
    private String detailDesc;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product.description
     *
     * @return the value of pms_product.description
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product.description
     *
     * @param description the value for pms_product.description
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product.detail_desc
     *
     * @return the value of pms_product.detail_desc
     *
     * @mbg.generated
     */
    public String getDetailDesc() {
        return detailDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product.detail_desc
     *
     * @param detailDesc the value for pms_product.detail_desc
     *
     * @mbg.generated
     */
    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc == null ? null : detailDesc.trim();
    }
}