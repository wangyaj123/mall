package com.office.mall.entiy;

public class Category {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_category.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_category.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_category.level
     *
     * @mbg.generated
     */
    private Integer level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pms_product_category.show_status
     *
     * @mbg.generated
     */
    private Integer showStatus;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_category.id
     *
     * @return the value of pms_product_category.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_category.id
     *
     * @param id the value for pms_product_category.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_category.name
     *
     * @return the value of pms_product_category.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_category.name
     *
     * @param name the value for pms_product_category.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_category.level
     *
     * @return the value of pms_product_category.level
     *
     * @mbg.generated
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_category.level
     *
     * @param level the value for pms_product_category.level
     *
     * @mbg.generated
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pms_product_category.show_status
     *
     * @return the value of pms_product_category.show_status
     *
     * @mbg.generated
     */
    public Integer getShowStatus() {
        return showStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pms_product_category.show_status
     *
     * @param showStatus the value for pms_product_category.show_status
     *
     * @mbg.generated
     */
    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }
}