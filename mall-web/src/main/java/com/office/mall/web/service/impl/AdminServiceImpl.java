package com.office.mall.web.service.impl;

import com.office.mall.dao.AdminMapper;
import com.office.mall.entiy.Admin;
import com.office.mall.request.AdminRequest;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private CommonResult commonResult;

    public CommonResult select(AdminRequest request) {
        Admin login = adminMapper.select(request);
        if(login !=null){
            return commonResult.success(login);
        }
        return commonResult.validateFailed("用户不存在");
    }

    public CommonResult register(AdminRequest request) {
        Admin admin = adminMapper.selectByName(request.getUsername());
        if(admin == null) {
            int result = adminMapper.insert(request);
            return result==1?commonResult.success(request):commonResult.validateFailed("注册失败");
        }
        return commonResult.validateFailed("用户已存在");
    }
}
