package com.office.mall.web.service;

import com.office.mall.entiy.Category;
import com.office.mall.web.commons.CommonResult;

public interface CategoryService {
    CommonResult queryList(Category category);
}
