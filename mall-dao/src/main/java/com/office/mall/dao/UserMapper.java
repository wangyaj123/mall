package com.office.mall.dao;

import com.office.mall.entiy.User;
import com.office.mall.request.UserRequest;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(UserRequest record);


    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User select(UserRequest request);

    User getByName(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getByPhone(String phone);
}