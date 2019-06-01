package com.office.mall.web.controller;

import com.office.mall.request.CartRequest;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.CartService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Resource
    private CartService cartService;
    @Resource
    private CommonResult commonResult;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public CommonResult addToCart(@RequestBody CartRequest request){
        return cartService.addToCart(request);
    }
    @RequestMapping(value = "/showCartList",method = RequestMethod.POST)
    public CommonResult queryCartList(){
        return cartService.queryCartList();
    }
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public CommonResult removeProduct(@RequestBody CartRequest request){
        return cartService.removeProduct(request);
    }

}
