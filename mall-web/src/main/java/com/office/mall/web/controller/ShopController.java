package com.office.mall.web.controller;

import com.office.mall.request.ShopRequest;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.ShopService;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.COMM_FAILURE;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/shop")
public class ShopController {
    @Resource
    private ShopService shopService;
    @Resource
    private CommonResult commonResult;
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public CommonResult queryShop(@RequestBody  ShopRequest request){
       return commonResult.pageSuccess( shopService.queryList(request));
   }
   @RequestMapping(value = "/query/detail",method = RequestMethod.GET)
    public CommonResult queryDetailById(@Param("shopId") Integer shopId){
        return commonResult.success(shopService.selectByPrimaryKey(shopId));
   }
    @RequestMapping(value = "/changeStatus",method = RequestMethod.POST)
    public CommonResult changeStatus(@RequestBody ShopRequest request){
        return commonResult.success(shopService.changeStatus(request));
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public CommonResult loginShop(@RequestBody ShopRequest shopRequest){
        return shopService.login(shopRequest);
    }
}
