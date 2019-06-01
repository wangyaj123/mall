package com.office.mall.web.service;

import com.office.mall.request.SpecRequest;
import com.office.mall.web.commons.CommonResult;

public interface SpecService {
    CommonResult queryList(SpecRequest request);
    CommonResult getById(SpecRequest request);
    CommonResult saveSpec(SpecRequest request);
    CommonResult updateSpec(SpecRequest request);
    CommonResult removeSpec(SpecRequest request);
}
