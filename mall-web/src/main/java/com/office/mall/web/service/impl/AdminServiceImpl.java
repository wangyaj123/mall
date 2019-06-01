package com.office.mall.web.service.impl;

import com.office.mall.dao.AdminMapper;
import com.office.mall.entiy.Admin;
import com.office.mall.request.AdminRequest;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    public CommonResult saveAdmin(AdminRequest request) {
        Admin admin = adminMapper.selectByName(request.getUsername());
        if(admin == null) {
            request.setPassword("123456");
            int result = adminMapper.insert(request);
            return result==1?commonResult.success(request):commonResult.validateFailed("添加失败");
        }
        return commonResult.validateFailed("用户已存在");
    }

    public CommonResult queryList(AdminRequest request) {
        List<Admin> adminList = adminMapper.queryList(request);
        return commonResult.pageSuccess(adminList);
    }

    public CommonResult changeStatus(AdminRequest request) {
        int result = adminMapper.changeStatus(request);
        if(result==1) {
            return commonResult.success(result);
        }else{
            return commonResult.failed();
        }
    }

    public CommonResult setPwd(AdminRequest request) {
        int result = adminMapper.setPwd(request);
        if(result==1) {
            return commonResult.success(result);
        }else{
            return commonResult.validateFailed("密码输入错误");
        }
    }
}
