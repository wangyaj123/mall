package com.office.mall.web.service.impl;

import com.office.mall.dao.CartMapper;
import com.office.mall.dao.ProductMapper;
import com.office.mall.entiy.Cart;
import com.office.mall.entiy.ProductWithBLOBs;
import com.office.mall.request.CartRequest;
import com.office.mall.request.ProductKey;
import com.office.mall.response.CartResponse;
import com.office.mall.response.ProductResponse;
import com.office.mall.web.commons.BaseConverter;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Resource
    private ProductMapper productMapper;
    @Resource
    private CartMapper cartMapper;
    @Resource
    private CommonResult commonResult;
    @Resource
    private BaseConverter<Cart, CartResponse> cartResponseConverter;
    @Resource
    private BaseConverter<ProductWithBLOBs, ProductResponse> productConverter;

    public CommonResult addToCart(CartRequest request) {
        int insert = cartMapper.insert(request);
        if(insert == 1){
            return commonResult.success(insert);
        }
        return commonResult.validateFailed("添加购物车失败");
    }

    public CommonResult queryCartList() {
        List<Cart> carts = cartMapper.queryList();
        List<CartResponse> cartList = new ArrayList<CartResponse>();
        ProductKey productKey = new ProductKey();
        if(carts.size()==0){
            return commonResult.validateFailed("购物车为空");
        }
        for (Cart item: carts) {
            productKey.setId(item.getProductId());
            ProductWithBLOBs product = productMapper.selectByPrimaryKey(productKey);
            CartResponse cartConvert = cartResponseConverter.convert(item, CartResponse.class);
            ProductResponse productConvert = productConverter.convert(product, ProductResponse.class);
            cartConvert.setProduct(productConvert);
            cartList.add(cartConvert);
        }
        return commonResult.pageSuccess(cartList);
    }

    public CommonResult removeProduct(CartRequest request) {
        int result = cartMapper.deleteByPrimaryKey(request.getId());
        if(result == 1){
            commonResult.success(request);
        }
        return commonResult.validateFailed("删除失败");
    }
}
