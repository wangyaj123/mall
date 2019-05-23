package com.office.mall.web.service.impl;

import com.office.mall.dao.OrderMapper;
import com.office.mall.entiy.Order;
import com.office.mall.entiy.OrderKey;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private CommonResult commonResult;
    public CommonResult getProductById(OrderKey request) {
        Order order = orderMapper.selectByPrimaryKey(request);
        return commonResult.success(order);
    }

    public CommonResult changeStatus(Order request) {
        int i = orderMapper.updateByPrimaryKey(request);
        if(i==1){
            return commonResult.success(request);
        }
        return commonResult.validateFailed("操作失败");
    }
}
