package com.office.mall.web.service.impl;

import com.office.mall.dao.CategoryMapper;
import com.office.mall.entiy.Category;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private CommonResult commonResult;
    public CommonResult queryList(Category category) {
        List<Category> categories = categoryMapper.queryList(category);
        return commonResult.pageSuccess(categories);
    }
}
