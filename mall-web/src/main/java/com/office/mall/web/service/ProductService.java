package com.office.mall.web.service;

import com.office.mall.entiy.ProductWithBLOBs;
import com.office.mall.request.CartRequest;
import com.office.mall.request.ProductKey;
import com.office.mall.request.ProductRequest;
import com.office.mall.web.commons.CommonResult;
import org.springframework.web.multipart.MultipartFile;


public interface ProductService {
    CommonResult getProductById(ProductKey request);
    CommonResult queryList(ProductRequest request);
    CommonResult addProduct(ProductWithBLOBs product, MultipartFile goodsImg);
    CommonResult addToCart(CartRequest request);
    CommonResult queryCartList();
}
