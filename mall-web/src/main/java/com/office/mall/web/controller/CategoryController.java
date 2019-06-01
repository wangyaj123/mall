package com.office.mall.web.controller;

import com.office.mall.entiy.Category;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/cate")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @RequestMapping(value = "/query/List", method = RequestMethod.POST)
    public CommonResult queryList(Category category){
        return categoryService.queryList(category);
    }
}
