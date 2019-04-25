package com.office.mall.web.service;

import com.office.mall.request.UserRequest;
import com.office.mall.response.UserResponse;

public interface UserService {
     UserResponse queryByName(String username);
     Integer save(UserRequest request);
}
