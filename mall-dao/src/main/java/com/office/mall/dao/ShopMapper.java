package com.office.mall.dao;

import com.office.mall.entiy.Shop;
import com.office.mall.request.ShopRequest;
import com.office.mall.response.ShopResponse;

import java.util.List;

public interface ShopMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Shop record);

    int insertSelective(Shop record);


    Shop selectByPrimaryKey(Integer id);

    List<Shop> queryList(ShopRequest request);

    int updateByPrimaryKeySelective(Shop record);

    int updateById(ShopRequest request);
}