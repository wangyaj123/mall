package com.office.mall.dao;

import com.office.mall.entiy.User;
import com.office.mall.request.UserRequest;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User queryByName(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}