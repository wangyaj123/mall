package com.office.mall.web.service;

import com.office.mall.request.AdminRequest;
import com.office.mall.web.commons.CommonResult;

public interface AdminService {

    CommonResult select(AdminRequest request);
    CommonResult register(AdminRequest request);
}
