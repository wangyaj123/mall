package com.office.mall.web.controller;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class SendMsg_webchinese {

//    public static void main(String[] args)throws Exception
//    {
//
//        HttpClient client = new HttpClient();
//        PostMethod post = new PostMethod("http://utf8.api.smschinese.cn"); //该第三方短信服务地址
//        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");//在头文件中设置转码
//        NameValuePair[] data ={ new NameValuePair("Uid", "王雅静szm"),new NameValuePair("Key", "d41d8cd98f00b204e980"),new NameValuePair("smsMob","18483613321"),new NameValuePair("smsText","验证码：8888")};
//        post.setRequestBody(data);
//
//        client.executeMethod(post);
//        Header[] headers = post.getResponseHeaders();
//        int statusCode = post.getStatusCode();
//        System.out.println("statusCode:"+statusCode);
//        for(Header h : headers)
//        {
//            System.out.println(h.toString());
//        }
//        String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
//        System.out.println(result); //打印返回消息状态
//
//
//        post.releaseConnection();
//
//    }

}