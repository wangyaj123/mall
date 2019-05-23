package com.office.mall.web.controller;

import com.office.mall.request.UserRequest;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.UserService;
import com.office.mall.web.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/api/view")
@RestController
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public CommonResult login(@RequestBody UserRequest request){
        return userService.select(request);
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult register(@RequestBody UserRequest request){
        return userService.register(request);
    }
}
