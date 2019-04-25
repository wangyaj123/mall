package com.office.mall.web.controller;

import com.office.mall.request.AdminRequest;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.AdminService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/api/admin")
@RestController
public class AdminController {
    @Resource
    private AdminService adminService;
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult register(@RequestBody AdminRequest request){
        return adminService.register(request);
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public CommonResult login(AdminRequest request){
        return adminService.select(request);
    }
}