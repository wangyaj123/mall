package com.office.mall.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HttpController {
    @RequestMapping("/")
    public String indexPage() {
        return "index";
    }
    @RequestMapping("/header")
    public String headPage() {
        return "header";
    }
    @RequestMapping("/body")
    public String bodyPage() {
        return "body";
    }
    @RequestMapping("/footer")
    public String footPage() {
        return "footer";
    }
}
