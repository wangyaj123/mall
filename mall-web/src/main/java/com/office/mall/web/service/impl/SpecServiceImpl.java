package com.office.mall.web.service.impl;


import com.office.mall.dao.SpecificationsMapper;
import com.office.mall.entiy.Specifications;
import com.office.mall.request.SpecRequest;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.SpecService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpecServiceImpl implements SpecService {
    @Resource
    private SpecificationsMapper specMapper;
    @Resource
    private CommonResult commonResult;

    public CommonResult queryList(SpecRequest request) {
        return null;
    }

    public CommonResult getById(SpecRequest request) {
        return null;
    }

    public CommonResult saveSpec(SpecRequest request) {
        return null;
    }

    public CommonResult updateSpec(SpecRequest request) {
        return null;
    }

    public CommonResult removeSpec(SpecRequest request) {
        return null;
    }
}
