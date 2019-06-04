package com.office.mall.web.service.impl;

import ch.qos.logback.core.util.FileUtil;
import com.office.mall.dao.BrandMapper;
import com.office.mall.dao.CartMapper;
import com.office.mall.dao.ProductMapper;
import com.office.mall.dao.ShopMapper;
import com.office.mall.entiy.Brand;
import com.office.mall.entiy.Cart;
import com.office.mall.entiy.Shop;
import com.office.mall.request.ProductKey;
import com.office.mall.entiy.ProductWithBLOBs;
import com.office.mall.request.ProductRequest;
import com.office.mall.response.CartResponse;
import com.office.mall.response.ProductResponse;
import com.office.mall.web.commons.BaseConverter;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;
    @Resource
    private CartMapper cartMapper;
    @Resource
    private CommonResult commonResult;
    @Resource
    private ShopMapper shopMapper;
    @Resource
    private BrandMapper brandMapper;
    @Resource
    private BaseConverter<Cart, CartResponse> cartResponseConverter;
    @Resource
    private BaseConverter<ProductWithBLOBs, ProductResponse> productConverter;

    public CommonResult getProductById(ProductKey request) {
        Shop shop = shopMapper.selectByPrimaryKey(request.getShopId());
        Brand brand = brandMapper.selectByPrimaryKey(request.getBrandId());
        ProductWithBLOBs product = productMapper.selectByPrimaryKey(request);
        ProductResponse productResponse = productConverter.convert(product, ProductResponse.class);
        //productResponse.setShopName(shop.getShopName());
//        productResponse.setBrandName(brand.getName());
        return commonResult.success(productResponse);
    }

    public CommonResult queryList(ProductRequest request) {
        List<ProductWithBLOBs> productList = productMapper.queryList(request);
        return commonResult.pageSuccess(productList);
    }


    public CommonResult updateProduct(ProductRequest product) {
        int result = productMapper.updateByPrimaryKey(product);
        if(result == 1){
            return commonResult.success(result);
        }
        return commonResult.failed();
    }

    public CommonResult saveProduct(ProductWithBLOBs request) {
        int result = productMapper.insert(request);
        if(result == 1){
            return commonResult.success(result);
        }
        return commonResult.failed();
    }

    public CommonResult changeStatus(ProductRequest record) {
        int result = productMapper.changeStatus(record);
        if(result == 1){
            return commonResult.success(result);
        }
        return commonResult.failed();
    }

    public CommonResult updateProduct(ProductWithBLOBs product, MultipartFile goodsImg) {
        int flag = productMapper.updateByPrimaryKeyWithBLOBs(product);
        if(flag == 1){
            return commonResult.success(flag);
        }
        return commonResult.validateFailed("更新失败");
    }

}
