package com.office.mall.web.service.impl;

import com.office.mall.dao.UserMapper;
import com.office.mall.entiy.User;
import com.office.mall.request.UserRequest;
import com.office.mall.response.UserResponse;
import com.office.mall.web.commons.BaseConverter;
import com.office.mall.web.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl  implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private BaseConverter<User, UserResponse> responseConverter;

    public UserResponse queryByName(String username) {
        return null;
    }

    public Integer save(UserRequest request) {
        return null;
    }
}
