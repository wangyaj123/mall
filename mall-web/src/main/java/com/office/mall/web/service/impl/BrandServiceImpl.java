package com.office.mall.web.service.impl;

import com.office.mall.dao.BrandMapper;
import com.office.mall.entiy.Brand;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.BrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandMapper brandMapper;
    @Resource
    private CommonResult commonResult;
    public CommonResult queryList(Brand brandRequest) {
        List<Brand> brands = brandMapper.queryList(brandRequest);
        return commonResult.pageSuccess(brands);
    }

    public CommonResult updateBrand(Brand brand) {
        int result = brandMapper.updateByPrimaryKey(brand);
        if(result == 1){
            commonResult.success(result);
        }
        return commonResult.validateFailed("修改失败");
    }

    public CommonResult saveBrand(Brand brand) {
        int result = brandMapper.insert(brand);
        if(result == 1){
            commonResult.success(result);
        }
        return commonResult.validateFailed("添加失败");
    }

    public CommonResult getById(Brand brand) {
        Brand brandResponse = brandMapper.selectByPrimaryKey(brand.getId());
        if(brandResponse != null){
            return commonResult.success(brandResponse);
        }else{
            return commonResult.failed();
        }
    }
}
