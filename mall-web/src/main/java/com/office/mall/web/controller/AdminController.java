package com.office.mall.web.controller;

import com.office.mall.web.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Resource
    private AdminService adminservice;
    @RequestMapping(value="/query",method = RequestMethod.GET)
    public String querySingle(Long id){
       return adminservice.querySingle(id).toString();
    }

}
