package com.office.mall.dao;

import com.office.mall.entiy.Admin;
import com.office.mall.request.AdminRequest;

import java.util.List;

public interface AdminMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_admin
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_admin
     *
     * @mbg.generated
     */
    int insert(AdminRequest request);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_admin
     *
     * @mbg.generated
     */
    int insertSelective(Admin record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_admin
     *
     * @mbg.generated
     */
    Admin selectByPrimaryKey(Integer id);
    Admin selectByName(String username);
    List<Admin> queryList(AdminRequest request);
    Admin select(AdminRequest request);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_admin
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Admin record);
    int setPwd(AdminRequest request);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ums_admin
     *
     * @mbg.generated
     */
    int changeStatus(AdminRequest record);
}