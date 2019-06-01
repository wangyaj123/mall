package com.office.mall.web.service;

import com.office.mall.entiy.Brand;
import com.office.mall.web.commons.CommonResult;

public interface BrandService {
    CommonResult queryList(Brand brandRequest);
    CommonResult updateBrand(Brand brand);
    CommonResult saveBrand(Brand brand);
    CommonResult getById(Brand brand);
}
