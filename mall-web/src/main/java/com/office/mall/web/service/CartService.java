package com.office.mall.web.service;

import com.office.mall.request.CartRequest;
import com.office.mall.web.commons.CommonResult;

public interface CartService {
    CommonResult addToCart(CartRequest request);
    CommonResult queryCartList();
    CommonResult removeProduct(CartRequest request);
}
