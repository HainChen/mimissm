package com.bjpowernode.controller;

import com.bjpowernode.pojo.Admin;
import com.bjpowernode.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName AdminAction
 * @Description TODO
 * @Author hainc
 * @Date 2022/7/27 19:40
 * @Version 1.0
 **/
@Controller
@RequestMapping("/admin")
public class AdminAction {
    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request) {
        Admin admin = adminService.login(name, pwd);

        if (admin != null) {
            request.setAttribute("admin", admin);
            return "main";
        } else {
            request.setAttribute("errmsg", "用户名或密码错误！");
            return "login";
        }

    }
}
