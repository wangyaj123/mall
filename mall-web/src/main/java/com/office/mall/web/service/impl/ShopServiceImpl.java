package com.office.mall.web.service.impl;

import com.office.mall.dao.ShopMapper;
import com.office.mall.entiy.Shop;
import com.office.mall.request.ShopRequest;
import com.office.mall.response.ShopResponse;
import com.office.mall.web.commons.BaseConverter;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Resource
    private ShopMapper shopMapper;
    @Resource
    private BaseConverter<Shop,ShopResponse> shopResponseConverter;
    @Resource
    private CommonResult commonResult;

    public List<ShopResponse> queryList(ShopRequest request) {
        List<Shop> shop =  shopMapper.queryList(request);
        List<ShopResponse> shopResponseList = shopResponseConverter.convert(shop, ShopResponse.class);
        return shopResponseList;
    }

    public Shop selectByPrimaryKey(Integer id) {
        return shopMapper.selectByPrimaryKey(id);
    }

    public Integer changeStatus(ShopRequest request) {
        return shopMapper.updateById(request);
    }

    public CommonResult login(ShopRequest request) {
        Shop shop = shopMapper.selectByNameAndPwd(request);
        if(shop != null){
            return commonResult.success(shop);
        }
        return commonResult.validateFailed("用户不存在或审核未通过");
    }
}
