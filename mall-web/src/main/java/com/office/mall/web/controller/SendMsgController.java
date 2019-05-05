package com.office.mall.web.controller;

import com.office.mall.entiy.User;
import com.office.mall.request.UserRequest;
import com.office.mall.web.commons.CommonResult;
import com.office.mall.web.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class SendMsgController {
    @Resource
    private CommonResult commonResult;
    @Resource
    private UserService userService;

    /**
     * @author hang
     * @Decription 注册，发送短信验证码,保存到Session中
     * @return 返回状态参数
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value ="/sendMsg", method = RequestMethod.POST)
    public CommonResult SendCheckMessage(HttpServletRequest request, @RequestBody UserRequest userRequest)
            throws Exception {
        String message = "发送成功";
        String phone=userRequest.getPhone();   //获取到客户端发来的手机号
        User user = userService.getByPhone(phone);
        if (user != null) {
            message = "该手机号已被注册";
            return commonResult.validateFailed(message);
        } else {
            //HashMap<String, String> m = SendMsg_webchineseController.getMessageStatus(phone);  //应用发送短信接口
            HashMap<String, String> m = new HashMap<String, String>();
            m.put("result","1");
            String result = m.get("result");              //获取到result值
            if (result.trim().equals("1")) {             //如果为1，表示成功发送
              //  String code = m.get("code");           //获取发送的验证码内容
                String code = "8888";
                //logger.info("发送的验证码:"+code);     //打印日志
                System.out.println(code);
                HttpSession session = request.getSession(); //设置session
                session.setAttribute("code", code);             //将短信验证码放到session中保存
                session.setMaxInactiveInterval(60 * 5);//保存时间 暂时设定为5分钟
                return commonResult.success(code);
            } else {
                message = "短信发送失败";
                return commonResult.validateFailed(message);
            }
        }
    }
}
