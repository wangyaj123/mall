package com.office.mall.web.service;

import com.office.mall.entiy.Shop;
import com.office.mall.request.ShopRequest;
import com.office.mall.response.ShopResponse;

import java.util.List;

public interface ShopService {
    List<ShopResponse> queryList(ShopRequest request);
    Shop selectByPrimaryKey(Integer id);
}
