package com.office.mall.web.controller;

import com.office.mall.request.SpecRequest;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.SpecService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/spec")
public class SpecController {
    @Resource
    private SpecService specService;
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public CommonResult addToCart(@RequestBody SpecRequest request){
        return specService.saveSpec(request);
    }
    @RequestMapping(value = "/query/list",method = RequestMethod.POST)
    public CommonResult queryList(SpecRequest request){
        return specService.queryList(request);
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public CommonResult updateSpec(SpecRequest request){
        return specService.updateSpec(request);
    }
    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public CommonResult removeProduct(@RequestBody SpecRequest request){
        return specService.removeSpec(request);
    }

}
