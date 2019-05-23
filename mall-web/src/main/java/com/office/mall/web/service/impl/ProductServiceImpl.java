package com.office.mall.web.service.impl;

import com.office.mall.dao.CartMapper;
import com.office.mall.dao.ProductMapper;
import com.office.mall.entiy.Cart;
import com.office.mall.request.CartRequest;
import com.office.mall.request.ProductKey;
import com.office.mall.entiy.ProductWithBLOBs;
import com.office.mall.request.ProductRequest;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.ProductService;
import com.office.mall.web.utils.FileUtil;
import com.office.mall.web.utils.ImageUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;
    @Resource
    private CartMapper cartMapper;
    @Resource
    private CommonResult commonResult;

    public CommonResult getProductById(ProductKey request) {
        ProductWithBLOBs product = productMapper.selectByPrimaryKey(request);
        return commonResult.success(product);
    }

    public CommonResult queryList(ProductRequest request) {
        List<ProductWithBLOBs> productList = productMapper.queryList(request);
        return commonResult.pageSuccess(productList);
    }

    public CommonResult addProduct(ProductWithBLOBs product, MultipartFile goodsImg) {
        int flag = productMapper.insert(product);
        addGoodsImg(product,goodsImg);
        return null;
    }

    public CommonResult addToCart(CartRequest request) {

        int insert = cartMapper.insert(request);
        if(insert == 1){
            return commonResult.success(request);
        }
        return commonResult.validateFailed("添加购物车失败");
    }

    public CommonResult queryCartList() {
        List<Cart> carts = cartMapper.queryList();
        List<ProductWithBLOBs> products = new ArrayList<ProductWithBLOBs>();
        ProductKey productKey = new ProductKey();
        if(carts.size()==0){
            return commonResult.validateFailed("购物车为空");
        }
        for (Cart item: carts) {
            productKey.setId(item.getProductId());
            ProductWithBLOBs product = productMapper.selectByPrimaryKey(productKey);
            products.add(product);
        }
        return commonResult.pageSuccess(products);
    }
    private void addGoodsImg(ProductWithBLOBs product, MultipartFile goodsImg) {
        String dest = FileUtil.getGoodsInfoImagePath(product.getId());
        String goodsImgAddr = ImageUtil.generateThumbnail(goodsImg, dest);
        product.setPic(goodsImgAddr);
    }
}
