package com.office.mall.entiy;

public class Cart {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ums_cart.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ums_cart.user_id
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ums_cart.product_id
     *
     * @mbg.generated
     */
    private Integer productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ums_cart.shop_id
     *
     * @mbg.generated
     */
    private Integer shopId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ums_cart.id
     *
     * @return the value of ums_cart.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ums_cart.id
     *
     * @param id the value for ums_cart.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ums_cart.user_id
     *
     * @return the value of ums_cart.user_id
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ums_cart.user_id
     *
     * @param userId the value for ums_cart.user_id
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ums_cart.product_id
     *
     * @return the value of ums_cart.product_id
     *
     * @mbg.generated
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ums_cart.product_id
     *
     * @param productId the value for ums_cart.product_id
     *
     * @mbg.generated
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ums_cart.shop_id
     *
     * @return the value of ums_cart.shop_id
     *
     * @mbg.generated
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ums_cart.shop_id
     *
     * @param shopId the value for ums_cart.shop_id
     *
     * @mbg.generated
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }
}