package com.office.mall.web.service;

import com.office.mall.dao.AdminMapper;
import com.office.mall.entiy.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminService {
    @Resource
    private AdminMapper adminMapper;
    public Admin querySingle(Long id){
        return adminMapper.selectByPrimaryKey(id);
    }
}
