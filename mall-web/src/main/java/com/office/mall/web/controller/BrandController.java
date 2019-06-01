package com.office.mall.web.controller;

import com.office.mall.entiy.Brand;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.BrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Resource
    private BrandService brandService;
    @RequestMapping(value = "/query/list",method = RequestMethod.POST)
    public CommonResult queryList(@RequestBody Brand request){
        return brandService.queryList(request);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public CommonResult saveBrand(@RequestBody Brand request){
        return brandService.saveBrand(request);
    }
    @RequestMapping(value = "/updateById",method = RequestMethod.POST)
    public CommonResult updateBrandById(@RequestBody Brand request){
        return brandService.updateBrand(request);
    }
    @RequestMapping(value = "/getById",method = RequestMethod.POST)
    public CommonResult getBrandById(@RequestBody Brand request){
        return brandService.getById(request);
    }

}
