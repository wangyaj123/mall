package com.office.mall.web.service;

import com.office.mall.entiy.Order;
import com.office.mall.entiy.OrderKey;
import com.office.mall.web.commons.CommonResult;

public interface OrderService {
    CommonResult getProductById(OrderKey request);
    CommonResult changeStatus(Order request);
}
