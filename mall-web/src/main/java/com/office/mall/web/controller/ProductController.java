package com.office.mall.web.controller;

import com.alibaba.fastjson.JSON;
import com.office.mall.entiy.ProductWithBLOBs;
import com.office.mall.request.CartRequest;
import com.office.mall.request.ProductKey;
import com.office.mall.request.ProductRequest;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.ProductService;
import com.office.mall.web.utils.JsonUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;
    @Resource
    private CommonResult commonResult;

    @RequestMapping(value = "/getById",method = RequestMethod.POST)
    public CommonResult getProductById(@RequestBody ProductKey request){
        return productService.getProductById(request);
    }
    @RequestMapping(value = "/query/list",method = RequestMethod.POST)
    public CommonResult queryList(@RequestBody ProductRequest request){
        return productService.queryList(request);
    }

    @RequestMapping(value="/addProduct", method = RequestMethod.POST)
    public CommonResult registerGoods(@RequestBody HttpServletRequest request, HttpServletResponse response) {
        String productStr = JsonUtil.getString(request, "objJson");
        ProductWithBLOBs product = JSON.parseObject(productStr, ProductWithBLOBs.class);
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("objImg");
        if(files.size() > 0){
            MultipartFile goodsImg = files.get(0);
            return productService.addProduct(product,goodsImg);
        }else{
            return commonResult.validateFailed("添加失败");
        }
    }

    @RequestMapping(value = "/addToCart",method = RequestMethod.POST)
    public CommonResult addToCart(@RequestBody CartRequest request){
        return productService.addToCart(request);
    }
    @RequestMapping(value = "/showCartList",method = RequestMethod.POST)
    public CommonResult queryCartList(){
        return productService.queryCartList();
    }


}
