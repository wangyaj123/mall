package com.office.mall.web.service.impl;

import com.office.mall.dao.UserMapper;
import com.office.mall.entiy.User;
import com.office.mall.request.UserRequest;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl  implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private CommonResult commonResult;


    public CommonResult select(UserRequest request) {
        User user = userMapper.select(request);
        if(user!=null){
            return commonResult.success(user);
        }
        return commonResult.validateFailed("用户名密码错误或用户不存在");
    }

    public CommonResult register(UserRequest request) {
        userMapper.insert(request);
        return null;
    }

}

