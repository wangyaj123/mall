package com.office.mall.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HttpController {
    @RequestMapping("/")
    public String indexPage() {
        return "views/index";
    }
    @RequestMapping("/header")
    public String headPage() {
        return "views/header";
    }
    @RequestMapping("/body")
    public String bodyPage() {
        return "views/body";
    }
    @RequestMapping("/footer")
    public String footerPage() {
        return "views/footer";
    }
    @RequestMapping("/foot")
    public String footPage() {
        return "views/foot";
    }
    @RequestMapping("/register")
    public String registerPage() {
        return "views/register";
    }
    @RequestMapping("/shop/register")
    public String shopRegisterPage() {
        return "views/shopregister";
    }
    @RequestMapping("/shopLogin")
    public String loginPage() {
        return "views/shoplogin";
    }
    @RequestMapping("/admin")
    public String adminLoginPage() {
        return "admin/login";
    }
    @RequestMapping("/admin/page")
    public String adminPage() {
        return "admin/index";
    }
    @RequestMapping("/admin/home")
    public String adminHomePage() {
        return "admin/home";
    }
    @RequestMapping("/admin/brand")
    public String adminBrandPage() {
        return "admin/brand";
    }
    @RequestMapping("/admin/goods")
    public String adminGoodPage() {
        return "admin/goods";
    }
    @RequestMapping("/admin/content")
    public String adminContentPage() {
        return "admin/content";
    }
    @RequestMapping("/admin/category")
    public String adminCategoryPage() {
        return "admin/contentCategory";
    }
    @RequestMapping("/admin/item")
    public String adminItemPage() {
        return "admin/item_cat";
    }
    @RequestMapping("/admin/seller")
    public String adminSellerPage() {
        return "admin/seller";
    }
    @RequestMapping("/admin/seller1")
    public String adminSeller1Page() {
        return "admin/seller_1";
    }
    @RequestMapping("/admin/specification")
    public String adminSpecificationPage() {
        return "admin/specification";
    }
    @RequestMapping("/admin/template")
    public String adminTemplatePage() {
        return "admin/type_template";
    }
}
