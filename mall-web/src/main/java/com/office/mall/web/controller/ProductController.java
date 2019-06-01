package com.office.mall.web.controller;

import com.office.mall.entiy.ProductWithBLOBs;
import com.office.mall.request.ProductKey;
import com.office.mall.request.ProductRequest;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;
    @Resource
    private CommonResult commonResult;
    @Value("${filePath}")
    private String FilePath;
    @Value("${localPath}")
    private String LocalPath;
    @Value("${localPathImg}")
    private String localPathImg;
    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    public CommonResult getProductById(@RequestBody ProductKey request) {

        return productService.getProductById(request);
    }

    @RequestMapping(value = "/query/list", method = RequestMethod.POST)
    public CommonResult queryList(@RequestBody ProductRequest request) {
        return productService.queryList(request);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult updateProduct(@RequestBody ProductRequest productRequest, @RequestParam(value = "files", required = false) MultipartFile multipartFile,HttpServletRequest request) {
            return productService.updateProduct(productRequest);
    }
    @RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
    public CommonResult changeStatus(@RequestBody ProductRequest productRequest) {
        return productService.changeStatus(productRequest);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public CommonResult saveProduct(@RequestBody ProductWithBLOBs productRequest,HttpServletRequest request,@RequestParam(value = "files", required = false) MultipartFile multipartFile) throws IOException {
        CommonResult commonResult = addImg(request, multipartFile);
        System.out.println(commonResult.getData().toString());
        productRequest.setPic(commonResult.getData().toString());
        return productService.saveProduct(productRequest);
    }
    @RequestMapping(value = "/addImg",method = RequestMethod.POST)
    public CommonResult addImg(HttpServletRequest request, @RequestParam(value = "files", required = false) MultipartFile multipartFile) throws IOException {
        //这里一定要写required=false 不然前端不传文件一定报错。到不了后台。
        if (multipartFile != null) {
            Long size = multipartFile.getSize();
            if (size > 5242880) {
               return  commonResult.validateFailed("图片太大，无法上传");
            }
            String name = multipartFile.getOriginalFilename();//直接返回文件的名字
            String subffix = name.substring(name.lastIndexOf(".") + 1, name.length());//我这里取得文件后缀
            String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            //文件保存进来，我给他重新命名，数据库保存有原本的名字，所以输出的时候再把他附上原本的名字就行了。
            //获取项目路径到templates
            File file = new File(FilePath);
            if (!file.exists()) {//目录不存在就创建
               file.mkdirs();
            }
            File realFile = new File(file+"\\"+fileName+"."+subffix);
            multipartFile.transferTo(realFile);//保存文件到指定目录
            String imgUrl = localPathImg+FilePath+fileName+"."+subffix;
            return commonResult.success(imgUrl);
        }
        return commonResult.failed();
    }
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(LocalPath);
        return factory.createMultipartConfig();
    }

}
