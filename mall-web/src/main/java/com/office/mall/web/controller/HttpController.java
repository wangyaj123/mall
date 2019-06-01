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
    @RequestMapping("/login")
    public String loginPage(){return "views/login";}
    @RequestMapping("/cart")
    public String cartPage(){return "views/cart";}
    @RequestMapping("/shop")
    public String shopPage() {
        return "shop/index";
    }
    @RequestMapping("/shop/register")
    public String shopRegisterPage() {
        return "shop/shopregister";
    }
    @RequestMapping("/shop/login")
    public String shopLoginPage() {
        return "shop/shoplogin";
    }
    @RequestMapping("/shop/goods")
    public String shopGoodsPage() {
        return "shop/goods";
    }
    @RequestMapping("/shop/goodsEdit")
    public String shopGoodsEdit() {
        return "shop/goods_edit";
    }
    @RequestMapping("/shop/home")
    public String shopHomePage() {
        return "shop/home";
    }
    @RequestMapping("/shop/seller")
    public String shopSellerPage() {
        return "shop/seller";
    }
    @RequestMapping("/shop/password")
    public String shopPwdPage() {
        return "shop/password";
    }
    @RequestMapping("/admin/password")
    public String adminPwdPage() {
        return "admin/password";
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
    public String adminGoodsPage() {
        return "admin/goods";
    }
    @RequestMapping("/admin/content")
    public String adminContentPage() {
        return "admin/content";
    }
    @RequestMapping("/admin/sysUser")
    public String adminUserPage() {
        return "admin/sysUser";
    }
    @RequestMapping("/admin/category")
    public String adminCategoryPage() {
        return "sysUser";
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
    @RequestMapping("/productInfo")
    public String ProductInfoPage() {
        return "views/product-list";
    }
    @RequestMapping("/getOrderInfo")
    public String OrderInfoPage() {
        return "views/getOrderInfo";
    }
}
