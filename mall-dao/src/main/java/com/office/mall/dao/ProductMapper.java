package com.office.mall.dao;

import com.office.mall.entiy.Product;
import com.office.mall.request.ProductKey;
import com.office.mall.entiy.ProductWithBLOBs;
import com.office.mall.request.ProductRequest;

import java.util.List;

public interface ProductMapper {

    int deleteByPrimaryKey(ProductKey key);


    int insert(ProductWithBLOBs record);


    int insertSelective(ProductWithBLOBs record);


    ProductWithBLOBs selectByPrimaryKey(ProductKey key);

    List<ProductWithBLOBs> queryList(ProductRequest request);

    int updateByPrimaryKeySelective(ProductWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProductWithBLOBs record);

    int updateByPrimaryKey(Product record);
}