package com.office.mall.web.controller;

import com.office.mall.entiy.OrderKey;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;
    @RequestMapping(value = "/getById" ,method = RequestMethod.POST)
    CommonResult getOrderById(OrderKey orderKey){
       return orderService.getProductById(orderKey);
    }
    @RequestMapping(value = "/changeStatus" ,method = RequestMethod.POST)
    CommonResult changeStatus(OrderKey orderKey){
        return orderService.getProductById(orderKey);
    }
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    CommonResult update(OrderKey orderKey){
        return orderService.getProductById(orderKey);
    }
}
