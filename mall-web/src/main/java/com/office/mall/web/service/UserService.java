package com.office.mall.web.service;

import com.office.mall.request.UserRequest;
import com.office.mall.response.UserResponse;
import com.office.mall.web.commons.CommonResult;

public interface UserService {
     CommonResult select(UserRequest request);
     CommonResult register(UserRequest request);
}
