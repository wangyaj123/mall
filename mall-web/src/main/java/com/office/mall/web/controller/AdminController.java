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
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public CommonResult login(@RequestBody AdminRequest request){
        return adminService.select(request);
    }
    @RequestMapping(value = "/query/list",method = RequestMethod.POST)
    public CommonResult queryList(@RequestBody AdminRequest request){
        return adminService.queryList(request);
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public CommonResult saveAdmin(@RequestBody AdminRequest request){
        return adminService.saveAdmin(request);
    }
    @RequestMapping(value = "/change",method = RequestMethod.POST)
    public CommonResult changeStatus(@RequestBody AdminRequest request){
        return adminService.changeStatus(request);
    }
    @RequestMapping(value = "/setPwd",method = RequestMethod.POST)
    public CommonResult setPwd(@RequestBody AdminRequest request){
        return adminService.setPwd(request);
    }

}
