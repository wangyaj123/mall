package com.office.mall.response;

public class CartResponse {
        private Integer id;

        /**
         *
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database column ums_cart.user_id
         *
         * @mbg.generated
         */
        private Integer userId;

        private ProductResponse product;

        private Integer num;

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }
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


    public ProductResponse getProduct() {
        return product;
    }

    public void setProduct(ProductResponse product) {
        this.product = product;
    }

    /**
         * This method was generated by MyBatis Generator.
         * This method returns the value of the database column ums_cart.product_id
         *
         * @return the value of ums_cart.product_id
         *
         * @mbg.generated
         */

        private Integer shopId;

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
