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
        User user = userMapper.getByName(request.getUsername());
        if (user == null) {
            int result = userMapper.insert(request);
            return result==1?commonResult.success(request):commonResult.validateFailed("注册失败");
        } else {
            return commonResult.validateFailed("用户名已注册");
        }
    }

    public User getByPhone(String phone) {
        return userMapper.getByPhone(phone);
    }

}

